<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="parts/meta.jsp"%>
    <title>Totals</title>
    <%@ include file="parts/header.jsp" %>
</head>
<body>
    <jsp:include page="parts/nav.html"/>

    <div class="container">

        <c:url var="current" value="ServletControllerQueryDb">
            <c:param name="command" value="CURRENT"/>
        </c:url>
        <h1 class="text-center stock-info-date">Portfolio Details By Date/Time</h1>
        <a href="${current}"><button type="button" class="btn btn-outline-primary btn-block">Get Current Portfolio Information</button></a>

        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>Date/Time</th>
                <th>Total Value</th>
                <th>Daily Gain/Loss</th>
                <th>See Daily Info</th>
            </tr>
            </thead>
            <c:forEach var="totals" items="${TOTALS_LIST}">
                <c:url var="tempLink" value="ServletControllerQueryDb">
                    <c:param name="command" value="LOAD"/>
                    <c:param name="date" value="${totals.key}"/>
                </c:url>
                <tbody>
                <tr>
                    <td>${totals.key}</td>
                    <td>${totals.value.portfolioTotal}</td>
                    <td>${totals.value.portfolioDayGain}</td>
                    <td><a href="${tempLink}"><button type="button" class="btn btn-outline-primary btn-block">More Info</button></a></td>
                </tr>
                </tbody>
            </c:forEach>
        </table>
    </div>
</body>
</html>
