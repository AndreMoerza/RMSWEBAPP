<%-- 
    Document   : listbook
    Created on : Apr 16, 2018, 11:05:05 AM
    Author     : Andre_P772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Handphone</title>
</head>
<body>
    <% if (session.getAttribute("userName") == null || session.getAttribute("userName") == "") { %>
        <jsp:forward page="/LoginController?action=login" />
    <% } else {%>
        <table border=1>
            <thead>
                <tr>
                    <th>Hp id</th>
                    <th>Hp name</th>
                    <th>Hp type</th>
                    <th>Production Date</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hps}" var="hp">
                    <tr>
                        <td><c:out value="${hp.hp_id}" /></td>
                        <td><c:out value="${hp.hp_name}" /></td>
                        <td><c:out value="${hp.hp_type}" /></td>
                        <td><fmt:formatDate pattern="MMM dd,yyyy" value="${hp.hp_prod_date}" /></td>
                        <td><a href="HpController?action=edit&hp_id=<c:out value="${hp.hp_id}"/>">Edit</a></td>
                        <td><a href="HpController?action=delete&hp_id=<c:out value="${hp.hp_id}"/>">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p><a href="HpController?action=insert">Add Handphone</a> | <a href="LoginController?action=logout">Logout</a></p>
    <% } %>
    
</body>
</html>