<%-- 
    Document   : index
    Created on : Apr 24, 2018, 1:03:33 PM
    Author     : Andre_P772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Study Case 1</title>
    </head>
    <body>
        <% if (session.getAttribute("userName") == null || session.getAttribute("userName") == "") { %>
            <jsp:forward page="/LoginController?action=login" />
        <% } else {%>
            <jsp:forward page="/HpController?action=listhandphone" />
        <% } %>


        
    </body>
</html>
                   