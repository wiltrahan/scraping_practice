<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Stock Info</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>
<div class="container">
    <h2 id="stock-info-date" class="text-center">
        Individual Stock Information for:
        ${DATE}
    </h2>
    <table class="table table-striped table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Symbol</th>
            <th>Value</th>
            <th>Amount Change</th>
            <th>Percent Change</th>
            <th>Total Shares</th>
        </tr>
        </thead>

    <c:forEach var="tempStock" items="${STOCKS_LIST}">
    <tbody>
        <tr>
            <td>${tempStock.symbol}</td>
            <td>$${tempStock.value}</td>
            <td>${tempStock.dayAmtChg}</td>
            <td>${tempStock.dayPctChg}</td>
            <td>${tempStock.totalShrs}</td>
        </tr>
    </tbody>
    </c:forEach>

    </table>

    <a href="ServletControllerQueryDb">Back to daily listings</a>
</div>
    </body>
</html>