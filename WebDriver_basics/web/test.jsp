<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.List" %>

<%
    Querydb querydb = new Querydb();
    querydb.getTables();
    List<Total> totals = querydb.getTotals();

    request.setAttribute("myTotals", totals);
%>

<html>
    <body>

        <c:forEach var="tempTotals" items="${myTotals}">

            ${tempTotals.portfolioTotal}
        </c:forEach>


    </body>

</html>