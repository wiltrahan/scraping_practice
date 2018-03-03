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
                <th>See Stock Info</th>
            </tr>
            <c:forEach var="totals" items="${TOTALS_LIST}">
                <c:url var="tempLink" value="ServletControllerQueryDb">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="date" value="${totals.key}"/>
                </c:url>

                <tr>
                    <td>${totals.key}</td>
                    <td>${totals.value.portfolioTotal}</td>
                    <td>${totals.value.portfolioDayGain}</td>
                    <td> <a href="${tempLink}">More Info</a> </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>



<%--<form method="get" action="ServletControllerQueryDb">--%>
    <%--<td>${totals.key}--%>
        <%--<input type="submit" name="stockDetails" value="Get Details">--%>
    <%--</td>--%>
<%--</form>--%>