<%--
  Created by IntelliJ IDEA.
  User: twilorip
  Date: 2/25/18
  Time: 7:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.wiltrahan.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Querydb.getTables();
    List<Total> totals = Querydb.totals;
    Iterator<Total> iterator = totals.iterator();

    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  %>







  BYE

  </body>
</html>
