<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">


<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Totals</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    </head>
    <body>
        <div class="container">
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
                            <td> <a href="${tempLink}">More Info</a> </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
