package com.wiltrahan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(name = "/ServletControllerInsertDb")
public class ServletControllerInsertDb extends HttpServlet {

    private InsertDbUtil insertDbUtil;
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            insertDbUtil = new InsertDbUtil();
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
