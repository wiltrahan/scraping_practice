<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="parts/meta.jsp"%>
        <title>Stock Info</title>
        <%@ include file="parts/header.jsp" %>
    </head>
    <body>
        <jsp:include page="parts/nav.html"/>

        <div class="container">
            <h1 class="text-center stock-info-date">
                Stock Information For:
                <p id="date">${DATE}  <span id="time"> ${TIME}</span></p>
            </h1>
            <table class="table table-striped table-bordered animated zoomInUp">
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
            <a href="ServletControllerQueryDb"><button type="button" class="btn btn-outline-primary">Back to daily listings</button></a>
        </div>
    </body>