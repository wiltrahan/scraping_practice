package com.wiltrahan;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/ServletControllerQueryDb")

//THIS IS WHERE THE MAGIC.....BEGINS!

public class ServletControllerQueryDb extends HttpServlet {

    private QuerydbUtil queryDbUtil;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            queryDbUtil = new QuerydbUtil();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            //if 'MORE INFO' button on portfolioTotals.jsp is clicked -- stockInfo is called
            if(request.getParameter("command") != null) {
                stockInfo(request, response);
            } else {
                portfolioTotals(request, response);
            }
            //if it is not clicked, or click registers null -- portfolioTotals is called
            //portfolioTotals(request, response);

        } catch (Exception e) {
           throw new ServletException(e.getMessage());
        }
    }

    private void portfolioTotals(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {

        LinkedHashMap<String, Total> port = QuerydbUtil.getTables();

        request.setAttribute("TOTALS_LIST", port);

        RequestDispatcher dispatcher = request.getRequestDispatcher("portfolioTotals.jsp");

        dispatcher.forward(request, response);
    }

    private void stockInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {

        String date = request.getParameter("date");
        List<Stock> stocks = QuerydbUtil.getStocks(date);

        String[] timeSplit = date.split("\\s+");

        String time = formatTime(timeSplit[1]);

        request.setAttribute("STOCKS_LIST", stocks);
        request.setAttribute("DATE", timeSplit[0]);
        request.setAttribute("TIME", time);

        RequestDispatcher dispatcher = request.getRequestDispatcher("stock-info.jsp");
        dispatcher.forward(request, response);
    }

    private String formatTime(String time) throws ParseException {
        //old format
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date3 = sdf.parse(time);
        //new format
        SimpleDateFormat sdf2 = new SimpleDateFormat("h:mm aa");
        //formatting the given time to new format with AM/PM
        return sdf2.format(date3);
    }

}
