package com.wiltrahan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class InsertDbUtil {

    private ArrayList<Stock> myStocks;
    private ArrayList<Total> myTotals;

    public void portfolioList(List<Stock>stock) {
        myStocks = new ArrayList<>(stock);
    }

    public void totalsList(List<Total>total) {
        myTotals = new ArrayList<>(total);
    }

    private static final String DB_NAME = "portfolio.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/" + DB_NAME;

    private static final String COLUMN_STOCK_SYMBOL = "symbol";
    private static final String COLUMN_STOCK_VALUE = "value";
    private static final String COLUMN_STOCK_DAYAMTCHG = "dayAmtChg";
    private static final String COLUMN_STOCK_DAYPCTCHG = "dayPctChg";
    private static final String COLUMN_STOCK_TOTALSHRS = "totalShrs";

    private static final String TABLE_TOTALS = "totals";
    private static final String COLUMN_TOTAL_PORTFOLIO = "portfolioTotal";
    private static final String COLUMN_TOTAL_DAYGAIN = "portfolioDayGain";
    private static final String COLUMN_TOTAL_GAINTOTAL = "portfolioGainTotal";

    private static final String CURRENT_TIME = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

    private Connection conn;

    public void createDB() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + "'" + CURRENT_TIME + "'" +
                                " (" + COLUMN_STOCK_SYMBOL + " text, " +
                                       COLUMN_STOCK_VALUE + " text, " +
                                       COLUMN_STOCK_DAYAMTCHG + " text, " +
                                       COLUMN_STOCK_DAYPCTCHG + " text, " +
                                       COLUMN_STOCK_TOTALSHRS + " text, " +
                                       COLUMN_TOTAL_PORTFOLIO + " text, " +
                                       COLUMN_TOTAL_DAYGAIN + " text, " +
                                       COLUMN_TOTAL_GAINTOTAL + " text" +
                                ")");

        } catch (SQLException e) {
            System.out.println("Couldn't create com.wiltrahan.InsertDbUtil: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
        }
    }

    public void close() {
        try {
            if(conn != null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public void dbInsertStocks() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            for (Stock myStock : this.myStocks) {
                statement.execute("INSERT INTO " + "'" + CURRENT_TIME + "'" +
                        " (" + COLUMN_STOCK_SYMBOL + ", " +
                        COLUMN_STOCK_VALUE + ", " +
                        COLUMN_STOCK_DAYAMTCHG + ", " +
                        COLUMN_STOCK_DAYPCTCHG + ", " +
                        COLUMN_STOCK_TOTALSHRS +
                        ") " +
                        "VALUES('" + myStock.getSymbol() + "', '" +
                        myStock.getValue() + "', '" +
                        myStock.getDayAmtChg() + "', '" +
                        myStock.getDayPctChg() + "', '" +
                        myStock.getTotalShrs() + "')"

                );
            }
            for (Total myTotal : this.myTotals) {
                statement.execute("INSERT INTO " + "'" + CURRENT_TIME + "'" +
                        " (" + COLUMN_TOTAL_PORTFOLIO + ", " +
                        COLUMN_TOTAL_DAYGAIN + ", " +
                        COLUMN_TOTAL_GAINTOTAL +
                        ") " +
                        "VALUES('" + myTotal.getPortfolioTotal() + "', '" +
                        myTotal.getPortfolioDayGain() + "', '" +
                        myTotal.getPortfolioGainTotal() + "')"
                );
            }

        } catch (SQLException e) {
            System.out.println("Could not insert data: " + e.getMessage());
            e.printStackTrace();
        }
    }

//    public void dbInsertTotals() {
//        try {
//            conn = DriverManager.getConnection(CONNECTION_STRING);
//            Statement statement = conn.createStatement();
//            for (com.wiltrahan.Total myTotal : this.myTotals) {
//                statement.execute("INSERT INTO " + TABLE_TOTALS +
//                        " (" + COLUMN_TOTAL_PORTFOLIO + ", " +
//                        COLUMN_TOTAL_DAYGAIN + ", " +
//                        COLUMN_TOTAL_GAINTOTAL +
//                        ") " +
//                        "VALUES('" + myTotal.getPortfolioTotal() + "', '" +
//                        myTotal.getPortfolioDayGain() + "', '" +
//                        myTotal.getPortfolioGainTotal() + "')"
//                );
//            }
//        } catch (SQLException e) {
//            System.out.println("Could not insert TOTALS data: " + e.getMessage());
//            e.printStackTrace();
//
//        }
//    }
}