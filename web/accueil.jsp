<%-- 
    Document   : index
    Created on : 30 nov. 2021, 17:40:38
    Author     : rykuz
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
        <style>
            #by {
              position: fixed;
              bottom: 0;
              right: 0;
            }
            #submit {
                font-size:20px; 
                height:60px; 
                width:200px;
                
            }
        </style>
    </head>
    <body>
        <center><H1>Welcome to Technical Support</H1></center>
        <hr color="#1C9DD9">
        <center>
            <form action="/Projet_E5_1/TechSuppServlet" method="get">
                <input id="submit" type="submit" name="formulaire" value="Submit a request">
            </form>
            <hr color="#1C9DD9">
            <img src="img/technicalsupportimg.png">
            <div id="by">By Ningman XU and Peter THAY</div>
        </center>   
            
    </body>
</html>