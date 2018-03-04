package com.wiltrahan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/ServletControllerQueryDb")

public class ServletControllerQueryDb extends HttpServlet {

    private QuerydbUtil querydbUtil;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            querydbUtil = new QuerydbUtil();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            //if 'more' button click
            if(request.getParameter("command") != null) {
                stockInfo(request, response);
            } else {
                portfolioTotals(request, response);
            }

            portfolioTotals(request, response);
        } catch (Exception e) {
           throw new ServletException(e);
        }
    }

    private void stockInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date = request.getParameter("date");
        List<Stock> stocks = QuerydbUtil.getStocks(date);

        request.setAttribute("STOCKS_LIST", stocks);
        request.setAttribute("DATE", date);

        RequestDispatcher dispatcher = request.getRequestDispatcher("stock-info.jsp");
        dispatcher.forward(request, response);
    }

    private void portfolioTotals(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        LinkedHashMap<String, Total> port = QuerydbUtil.getTables();

        request.setAttribute("TOTALS_LIST", port);

        RequestDispatcher dispatcher = request.getRequestDispatcher("portfolioTotals.jsp");

        dispatcher.forward(request, response);
    }
}
