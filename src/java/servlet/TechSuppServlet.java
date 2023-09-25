/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import bean.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rykuz
 */
public class TechSuppServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String formulaire = request.getParameter("formulaire");
        
        if(formulaire.equals("Submit a request")){
            
            this.getServletContext().getRequestDispatcher("/techsupp.jsp").forward( request, response );
        }
        
        if(formulaire.equals("techsupp")) {
            
            TechSupportBean techSupportBean = new TechSupportBean();
            String email = request.getParameter("email");
            String logiciel = request.getParameter("logiciel");
            String os = request.getParameter("os");
            String probleme = request.getParameter("probleme");
            
            techSupportBean.setEmail(email);
            techSupportBean.setLogiciel(logiciel);
            techSupportBean.setOs(os);
            techSupportBean.setProbleme(probleme);

            try{
                techSupportBean.registerSupportRequest();
            } catch(SQLException e){}
            
            getServletContext().setAttribute("techSupportBean", techSupportBean);
            
            if (techSupportBean.isRegistered()) {
                RequestDispatcher disp = request.getRequestDispatcher("response.jsp");
                disp.forward (request, response);
            } else { 
                RequestDispatcher disp = request.getRequestDispatcher("inscription.jsp");
                disp.forward (request, response);
            }
        }
        
        if(formulaire.equals("regform")) {
            
                TechSupportBean techSupportBean = (TechSupportBean) getServletContext().getAttribute ("techSupportBean");
                
                String prenom = request.getParameter("prenom");
                String nom = request.getParameter("nom");
                String telephone = request.getParameter("telephone");

                techSupportBean.setPrenom(prenom);
                techSupportBean.setNom(nom);
                techSupportBean.setTelephone(telephone);

                try{
                    techSupportBean.registerCustomer();
                } catch(SQLException e){}
                
                getServletContext().setAttribute("techSupportBean", techSupportBean);
                
                RequestDispatcher disp = request.getRequestDispatcher("response.jsp");
                disp.forward (request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet (request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
