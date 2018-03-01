<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.Map" %>
<%@ page import="static com.wiltrahan.Querydb.*" %>


<%

    Map<String, Total> port = Querydb.getTables();
    request.setAttribute("myPort", port);

%>

<html>
    <body>

        <c:forEach var="port" items="${myPort}" >
            ${port.key}
            ${port.value.portfolioTotal} ${port.value.portfolioDayGain}
        </c:forEach>
    </body>

</html>