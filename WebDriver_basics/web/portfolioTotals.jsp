<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Totals</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
              integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


    </head>
    <body>


        <table class="table table-striped">
            <thead>
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
            </c:forEach>
            </tbody>
        </table>

    </body>
</html>
