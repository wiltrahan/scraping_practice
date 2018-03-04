package com.wiltrahan;

import java.sql.*;
import java.util.*;

public class QuerydbUtil {

    private static final String COLUMN_STOCK_SYMBOL = "symbol";
    private static final String COLUMN_STOCK_VALUE = "value";
    private static final String COLUMN_STOCK_DAYAMTCHG = "dayAmtChg";
    private static final String COLUMN_STOCK_DAYPCTCHG = "dayPctChg";
    private static final String COLUMN_STOCK_TOTALSHRS = "totalShrs";

    private static final String COLUMN_TOTAL_PORTFOLIO = "portfolioTotal";
    private static final String COLUMN_TOTAL_DAYGAIN = "portfolioDayGain";

    private static Connection conn;

    public static ArrayList<Total> totals = new ArrayList<>();
    private static ArrayList<String> dates = new ArrayList<>();

    private static LinkedHashMap port = new LinkedHashMap<String, Total>();



    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        QuerydbUtil.getTables();
    }
    //getTables called from index.jsp, sets table date as the key, and the Total object as the value
    //then returns the map to the jsp file

    public static LinkedHashMap<String, Total> getTables() throws ClassNotFoundException {
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            //rs = stmt.executeQuery("SELECT * FROM " + "'" + DATE + "'" );
            rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table'");
            while(rs.next()) {
                //dates.add(rs.getString(1));
                port.put(rs.getString(1), getTotals(rs.getString(1)));
            }
            rs.close();
            return port;

        } catch (SQLException e) {
            System.out.println("So sorry: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    public static List<Stock> getStocks(String date) {
        List<Stock> stockInfo = new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

                rs = stmt.executeQuery("SELECT * FROM " + "'" + date + "'" + " WHERE" + " symbol " + "IS NOT NULL");
                while (rs.next()) {
                    String symbol = rs.getString(COLUMN_STOCK_SYMBOL);
                    String value = rs.getString(COLUMN_STOCK_VALUE);
                    String dayAmtChg = rs.getString(COLUMN_STOCK_DAYAMTCHG);
                    String dayPctChg = rs.getString(COLUMN_STOCK_DAYPCTCHG);
                    String totalShrs = rs.getString(COLUMN_STOCK_TOTALSHRS);
                    System.out.println(symbol + " " + value + " " + dayAmtChg + " " + dayPctChg + " " + totalShrs);
                    stockInfo.add(new Stock(symbol, value, dayAmtChg, dayPctChg, totalShrs));
                }
            rs.close();
                conn.close();
            return stockInfo;

        } catch (SQLException e) {
            System.out.println("Stocks Error: " + e.getMessage());
            e.printStackTrace();
        }

        return stockInfo;
    }

    private static Total getTotals(String date) {
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

                rs = stmt.executeQuery("SELECT " + "portfolioTotal" + ", " +
                                                        "portfolioDayGain "  +
                                                        "FROM " + "'" + date + "'" +
                                                        "WHERE " + "portfolioTotal " + "IS NOT NULL");
                    String total = rs.getString(COLUMN_TOTAL_PORTFOLIO);
                    String dayGain = rs.getString(COLUMN_TOTAL_DAYGAIN);
                    conn.close();
                    return new Total(total, dayGain);

        } catch (SQLException e) {
            System.out.println("Totals Error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
