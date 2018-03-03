package com.wiltrahan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ServletControllerQueryDb extends HttpServlet {

    private Querydb querydb;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            querydb = new Querydb();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            portfolioTotals(request, response);
        } catch (Exception e) {
           throw new ServletException(e);
        }
    }

    private void portfolioTotals(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        LinkedHashMap<String, Total> port = Querydb.getTables();

        request.setAttribute("TOTALS_LIST", port);

        RequestDispatcher dispatcher = request.getRequestDispatcher("portfolioTotals.jsp");

        dispatcher.forward(request, response);
    }
}
