<%-- 
    Document   : login
    Created on : Apr 24, 2018, 2:20:54 PM
    Author     : Andre_P772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>

    </head>
    <body bgcolor="silver">
    <center>
        <form method="POST" action="LoginController" >
              
            <table border="0" width="10%" cellpadding="3">
                <thead>
                    <tr align="center">
                        <th colspan="2">Login Page</th>
                    </tr>
                </thead>
                <tbody>
                    <tr align="center">
                        <td>Username</td>
                        <td><input type="text" name="userName"/></td>
                    </tr>
                    <tr align="center">
                        <td>Password</td>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value="Login"/>
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <span style="color:red"><%=(session.getAttribute("errMessage") == null) ? "": session.getAttribute("errMessage")%></span>
        <br/>
        New User ? <a href="register.jsp">Register Here</a>
        </center>
    </body>
</html>
