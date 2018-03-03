<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <title>Stock Info</title>
        <link type="text/css" rel="stylesheet" href="css/style.css">
    </head>
    <body>

    <c:forEach var="tempStock" items="${STOCKS_LIST}">
        ${tempStock.symbol}
        ${tempStock.value}
        ${tempStock.dayAmtChg}
        ${tempStock.dayPctChg}
        ${tempStock.totalShrs}
    </c:forEach>

    </body>

</html>