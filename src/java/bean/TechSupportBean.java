package bean;
import java.sql.*;
import javax.servlet.UnavailableException;
public class TechSupportBean {
    
    private String email;
    private String logiciel;
    private String os;
    private String probleme;
    private String prenom;
    private String nom;
    private String telephone;
    private boolean registered;

    public TechSupportBean() throws UnavailableException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch(ClassNotFoundException e) { throw new UnavailableException("Driver non trouve dans CLASSPATH."); }
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public void setLogiciel(String logiciel) {
    this.logiciel = logiciel;
    }

    public void setOs(String os) {
    this.os = os;
    }

    public void setProbleme(String probleme) {
    this.probleme = probleme;
    }

    public void setPrenom(String prenom) {
    this.prenom = prenom;
    }

    public void setNom(String nom) {
    this.nom = nom;
    }

    public void setTelephone(String telephone) {
    this.telephone = telephone;
    }

    public String getEmail() {
    return email;
    }

    public String getLogiciel() {
    return logiciel;
    }

    public String getOs() {
    return os;
    }

    public String getProbleme() {
    return probleme;
    }

    public String getPrenom() {
    return prenom;
    }

    public String getNom() {
    return nom;
    }

    public String getTelephone() {
    return telephone;
    }

    public boolean isRegistered() {
    return registered;
    }

    public void registerSupportRequest() throws SQLException {

        Connection connection = null;

        String insertStatementStr = "INSERT INTO REQUETE VALUES(?, ?, ?, ?)";
        String selectCustomerStr = "SELECT PRENOM, NOM, TELEPHONE FROM client WHERE EMAIL = ?";

        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/E5_hotline", "peter", "thay");
            PreparedStatement insertStatement = connection.prepareStatement(insertStatementStr);

            insertStatement.setString(1, email);
            insertStatement.setString(2, logiciel);
            insertStatement.setString(3, os);
            insertStatement.setString(4, probleme);
            insertStatement.executeUpdate();

            PreparedStatement selectStatement = connection.prepareStatement(selectCustomerStr);

            selectStatement.setString(1, email);
            ResultSet rs = selectStatement.executeQuery();

            if (rs.next()) {
                setPrenom(rs.getString("prenom"));
                setNom(rs.getString("nom"));
                setTelephone(rs.getString("telephone"));
                registered = true;
            } else {
                registered = false;
            }
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {}
            }
        }
    }
    
    public void registerCustomer() throws SQLException {
        
        Connection connection = null;
        
        String insertStatementStr = "INSERT INTO CLIENT VALUES(?, ?, ?, ?)";
        
        try {
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/E5_hotline", "peter", "thay");
            
            PreparedStatement insertStatement = connection.prepareStatement(insertStatementStr);
            
            insertStatement.setString(1, prenom);
            insertStatement.setString(2, nom);
            insertStatement.setString(3, email);
            insertStatement.setString(4, telephone);
            insertStatement.executeUpdate();
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqle) {}
            }
        }
    }
 
}