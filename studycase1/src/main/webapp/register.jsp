<%-- 
    Document   : register
    Created on : Apr 25, 2018, 12:20:46 PM
    Author     : Andre_P772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body bgcolor="silver">
    <center>
        <form method="POST" action="RegisterController" >
              
            <table border="0" width="10%" cellpadding="3">
                <thead>
                    <tr align="center">
                        <th colspan="2">Registration Page</th>
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
                        <td>Email</td>
                        <td><input type="text" name="email"/></td>
                    </tr>
                    
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value="Register"/>
                            <input type="reset" value="Reset" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <br/>
        </center>
    </body>
</html>
