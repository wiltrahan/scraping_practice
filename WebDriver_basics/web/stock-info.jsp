<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Stock Info</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body>

    <table border="3" width="150">
        <tr>
            <th>Symbol</th>
            <th>Value</th>
            <th>Amount Change</th>
            <th>Percent Change</th>
            <th>Total Shares</th>
        </tr>

    <c:forEach var="tempStock" items="${STOCKS_LIST}">

        <tr>
            <td>${tempStock.symbol}</td>
            <td>${tempStock.value}</td>
            <td>${tempStock.dayAmtChg}</td>
            <td>${tempStock.dayPctChg}</td>
            <td>${tempStock.totalShrs}</td>
        </tr>
    </c:forEach>
        <h2 id="stock-info-date">
            ${DATE}
        </h2>


    </table>
    </body>
</html>