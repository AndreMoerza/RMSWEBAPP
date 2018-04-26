<%-- 
    Document   : hp
    Created on : Apr 24, 2018, 1:08:29 PM
    Author     : Andre_P772
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Handphone</title>
    </head>
    <body>
        <form method="POST" action='HpController' name="frmAddHp">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <% if (action.equalsIgnoreCase("edit")) {%>
            Hp ID : <input type="text" name="hp_id"
                               value="<c:out value="${handphone.hp_id}" />" readonly="readonly"/> (You Can't Change this)<br /> 
            <%} else {%>
            Hp ID : <input type="text" name="hp_id"
                               value="<c:out value="${handphone.hp_id}" />" /> <br />
            <%}%>
            Hp Name : <input
                type="text" name="hp_name"
                value="<c:out value="${handphone.hp_name}" />" /> <br /> 
            Hp Type : <select name="hp_type">
                        <option value="Smartphone" ${handphone.hp_type == 'Smartphone' ? 'selected' : ''}>Smartphone</option>
                        <option value="Analog" ${handphone.hp_type == 'Analog' ? 'selected' : ''}>Analog</option>
                      </select> <br /> 

            <% if (action.equalsIgnoreCase("edit")) {%>
            Production Date : <input
                type="text" name="prod_date"
                value="<fmt:formatDate pattern="yyyy/MM/dd" value="${handphone.hp_prod_date}" />" readonly="readonly"/>(You Can't Change this)  <br />
            <%} else {%>
            Production Date : <input
                type="text" name="prod_date"
                value="<fmt:formatDate pattern="yyyy/MM/dd" value="${handphone.hp_prod_date}" />" />(yyyy/MM/dd)  <br /> 
            <%}%>
            <input  type="submit" value="Submit" />
        </form>
    </body>
</html>
