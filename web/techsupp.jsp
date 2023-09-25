<%-- 
    Document   : identification
    Created on : 1 déc. 2021, 10:48:26
    Author     : rykuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Technical Support</title>
        <style>
            #submit {
                font-size:15px; 
                height:40px; 
                width:150px;
            }
            table{
                font-size: 20px;
            }
            select{
                font-size: 15px;
            }
            optgroup{
                font-size: 15px;
            }
        </style>
    </head>
    <body>
        <center><h1>Technical Support</h1></center>
        <hr color="#1C9DD9"><br>
        <center>
            <form ACTION="TechSuppServlet" METHOD="GET">
                <table ALIGN="center" WIDTH="100%" CELLSPACING="2" CELLPADDING="2">
                    <tr>
                        <td ALIGN="right">Email:</td>
                        <td><input TYPE="Text" NAME="email" ALIGN="LEFT" SIZE="25" required></td>
                    </tr>
                    <tr>
                        <td ALIGN="right">Software:</td>
                        <td>
                            <select NAME="logiciel" SIZE="1">
                                <optgroup>
                                    <option VALUE="Word">Microsoft Word</option>
                                    <option VALUE="Excel">Microsoft Excel</option>
                                    <option VALUE="Access">Microsoft PowerPoint</option>
                                    <option VALUE="PowerPoint">Microsoft Access</option>
                                    <option VALUE="Teams">Microsoft Teams</option>
                                </optgroup>
                            </select>
                        </td>
                        <td ALIGN="right">Operating System:</td>
                        <td>
                            <select NAME="os" size="1">
                                <optgroup>
                                    <option VALUE="95">Windows 95</option>
                                    <option VALUE="98">Windows 98</option>
                                    <option VALUE="XP">Windows XP</option>
                                    <option VALUE="10">Windows 10</option>
                                    <option VALUE="11">Windows 11</option>
                                    <option VALUE="Linux">Linux</option>
                                    <option VALUE="MacOS">MacOS</option>
                                </optgroup>
                            </select>
                        </td>
                    </tr>
                </table>
                <br>
                <div style=" font-size: 20px">Problem description</div>
                <br>
                <textarea NAME="probleme" COLS="50" ROWS="4"></textarea>
                <hr color="#1C9DD9"><br>
                <input TYPE="Submit" id="submit" NAME="submit" VALUE="Submit the request">
                <input TYPE = "hidden" NAME = "formulaire" VALUE = "techsupp"/>
            </form>
        </center>
        <div style="position: fixed; bottom: 0;right: 0;">By Ningman XU and Peter THAY</div>
    </body>
</html>
