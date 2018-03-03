<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.wiltrahan.Querydb" %>
<%@ page import="com.wiltrahan.Total" %>
<%@ page import="java.util.Map" %>
<%@ page import="static com.wiltrahan.Querydb.*" %>
<%@ page import="java.util.LinkedHashMap" %>


<%

//  LinkedHashMap<String, Total> port = Querydb.getTables();
//  request.setAttribute("myPort", port);

%>

<html>
<body>

<%--<table border="3" width="450">--%>
  <%--<tr>--%>
    <%--<th>Date/Time</th>--%>
    <%--<th>Total Value</th>--%>
    <%--<th>Daily Gain/Loss</th>--%>
  <%--</tr>--%>
  <%--<c:forEach var="totals" items="${myPort}" >--%>
    <%--<tr>--%>
      <%--<td>${totals.key}</td>--%>
      <%--<td>${totals.value.portfolioTotal}</td>--%>
      <%--<td>${totals.value.portfolioDayGain}</td>--%>
    <%--</tr>--%>

  <%--</c:forEach>--%>
</table>


</body>

</html>
