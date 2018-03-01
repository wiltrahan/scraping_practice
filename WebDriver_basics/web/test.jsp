<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="static com.wiltrahan.Querydb.*" %>


<%
    //Querydb querydb = new Querydb();

    //List<Total> totals = querydb.getTotals();
    List<Total> totals = getTables();

    List<String> workforme = testStrings();

    request.setAttribute("myTotals", totals);
    request.setAttribute("myWork", workforme);

%>

<html>
    <body>

        <c:forEach var="tempTotals" items="${myTotals}">
            ${tempTotals.portfolioTotal}
        </c:forEach>

        <c:forEach var="pleaseWork" items="${myWork}">
            ${pleaseWork}
        </c:forEach>

    <p>PLEASE WORK</p>

    </body>

</html>