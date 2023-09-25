<%-- 
    Document   : identification
    Created on : 1 déc. 2021, 11:23:36
    Author     : rykuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register</title>
        <style>
            #by {
              position: fixed;
              bottom: 0;
              right: 0;
            }
            #submit {
                font-size:15px; 
                height:40px; 
                width:130px;
            }
            table{
                font-size: 20px;
            }
        </style>
    </head>
    
    <body>
        <center><h1>Customer registration</h1></center>
        <h3>You are not registered</h3>
        <hr color="#1C9DD9">
        <h2>Register now</h2>
        <form action="TechSuppServlet" method="POST">
            <table>
                <tr>
                    <td>Frist name:</td>
                    <td><input type="text" name="prenom" size="30"></td>
                </tr>
                <tr>
                    <td>Last name:</td>
                    <td><input type="text" name="nom" size="30"></td>
                </tr>
                <tr>
                    <td>Phone number (FR):</td>
                    <td><input type="text" name="telephone" size="30"></td>
                </tr>
            </table>
            <br><input type="submit" id="submit" value="Submit request">
            <input TYPE = "hidden" NAME = "formulaire" VALUE = "regform"/>
        </form>
        <hr color="#1C9DD9">
        <div id="by">By Ningman XU and Peter THAY</div>
    </body>
</html>
