<%--<%@page import="java.util.*, com.wiltrahan.*" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
    <title>Totals</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
    <body>

    <table border="5" width="450">
        <tr>
            <th>Date/Time</th>
            <th>Total Value</th>
            <th>Daily Gain/Loss</th>
        </tr>
        <c:forEach var="totals" items="${TOTALS_LIST}" >
            <tr>
                <td>${totals.key}</td>
                <td>${totals.value.portfolioTotal}</td>
                <td>${totals.value.portfolioDayGain}</td>
            </tr>
        </c:forEach>
    </table>

    </body>

</html>



