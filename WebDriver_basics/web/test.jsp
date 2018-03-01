<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="static java.lang.Thread.*" %>

<%
    Querydb querydb = new Querydb();
    try {
        querydb.getTables();
    } catch (SQLException e) {
        System.out.println("sorry: " + e.getMessage());
        e.printStackTrace();
    }

//    List<Total> totals =
    sleep(5000);
    request.setAttribute("myTotals", querydb.getTotals());

%>

<html>
    <body>

        <c:forEach var="tempTotals" items="${myTotals}">

            ${tempTotals.portfolioTotal}
        </c:forEach>

    <p>PLEASE WORK</p>

    </body>

</html>