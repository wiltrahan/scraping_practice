<%@page import="java.util.*, com.wiltrahan.*" %>

<!DOCTYPE html>

<html>

<head>
    <title>Totals</title>
</head>
    <body>

    <%
        LinkedHashMap<String, Total> port = (LinkedHashMap<String, Total>) request.getAttribute("TOTALS_LIST");
    %>

    <%= port.get("02/21/2018 18:21:50").getPortfolioTotal() %>

    </body>

</html>
