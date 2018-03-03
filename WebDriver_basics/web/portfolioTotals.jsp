<%@page import="java.util.*, com.wiltrahan.*" %>

<!DOCTYPE html>

<html>

<head>
    <title>Totals</title>

    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
    <body>

    <%
        Map<String, Total> port = (LinkedHashMap<String, Total>) request.getAttribute("TOTALS_LIST");
        Set<String> keys = port.keySet();
    %>
    <table border="3" width="450">
        <tr>
            <th>Date/Time</th>
            <th>Total Value</th>
            <th>Daily Gain/Loss</th>
        </tr>
    <% for(String k: keys) { %>
        <tr>
            <td> <%= k %> </td>
            <td><%= port.get(k).getPortfolioTotal()%></td>
            <td><%= port.get(k).getPortfolioDayGain()%></td>
        </tr>
    <%}%>


    </table>

    </body>

</html>

