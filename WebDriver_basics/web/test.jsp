<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.Map" %>
<%@ page import="static com.wiltrahan.Querydb.*" %>
<%@ page import="java.util.LinkedHashMap" %>


<%

   LinkedHashMap<String, Total> port = Querydb.getTables();
    request.setAttribute("myPort", port);

%>

<html>
    <body>

        <table border="3" width="450">
            <tr>
                <th>Date</th>
                <th>Total Value</th>
                <th>Daily Gain</th>
            </tr>
            <c:forEach var="port" items="${myPort}" >
                <tr>
                    <td>${port.key}</td>
                    <td>${port.value.portfolioTotal}</td>
                    <td>${port.value.portfolioDayGain}</td>
                </tr>

            </c:forEach>
        </table>

    <%--<h3>Current Total Value</h3>--%>
    <%--//<h4>${myPort.get().portfolioTotal}</h4>--%>

    </body>



</html>