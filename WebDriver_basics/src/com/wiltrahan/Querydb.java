package com.wiltrahan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Querydb {

    private static final String DB_NAME = "portfolio.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db" + DB_NAME;

    //private static final String TABLE_STOCKS = "stocks";
    private static final String COLUMN_STOCK_SYMBOL = "symbol";
    private static final String COLUMN_STOCK_VALUE = "value";
    private static final String COLUMN_STOCK_DAYAMTCHG = "dayAmtChg";
    private static final String COLUMN_STOCK_DAYPCTCHG = "dayPctChg";
    private static final String COLUMN_STOCK_TOTALSHRS = "totalShrs";

    private static final String TABLE_TOTALS = "totals";
    private static final String COLUMN_TOTAL_PORTFOLIO = "portfolioTotal";
    private static final String COLUMN_TOTAL_DAYGAIN = "portfolioDayGain";
    private static final String COLUMN_TOTAL_GAINTOTAL = "portfolioGainTotal";
    //public static final String DATE = "02/22/2018 15:32:31";

    private static Connection conn;

    public static ArrayList<Total> totals = new ArrayList<>();

    private static ArrayList<String> dates = new ArrayList<>();

//    public Querydb(ArrayList<String> dates) {
//        this.dates = dates;
//    }

    public Querydb() {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Querydb querydb = new Querydb();
        querydb.getTables();
    }

    public static List<Total> getTables() throws SQLException, ClassNotFoundException {
        //List<String> dates = new ArrayList<>();
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement stmt = conn.createStatement();
            ResultSet rs;

            //rs = stmt.executeQuery("SELECT * FROM " + "'" + DATE + "'" );
            rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table'");
            while(rs.next()) {
                dates.add(rs.getString(1));
                //System.out.println(rs.getString(1));
                //System.out.println(dates.size());
            }
            //return dates;
            return getTotals();
//        conn.close();
        } catch (SQLException e) {
            System.out.println("So sorry: " + e.getMessage());
            e.printStackTrace();
        }
            //getStocks(dates);
            //getTotals(dates);

        return getTotals();

    }

    private static void getStocks(List<String>dates) {

        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement stmt = conn.createStatement();
            ResultSet rs;

            for(String date : dates) {
                System.out.println(date);
                rs = stmt.executeQuery("SELECT * FROM " + "'" + date + "'" + " WHERE" + " symbol " + "IS NOT NULL");
                while (rs.next()) {
                    //String symbol = rs.getString("symbol");
                    String symbol = rs.getString(COLUMN_STOCK_SYMBOL);
                    String value = rs.getString(COLUMN_STOCK_VALUE);
                    String dayAmtChg = rs.getString(COLUMN_STOCK_DAYAMTCHG);
                    String dayPctChg = rs.getString(COLUMN_STOCK_DAYPCTCHG);
                    String totalShrs = rs.getString(COLUMN_STOCK_TOTALSHRS);
                    System.out.println(symbol + " " + value + " " + dayAmtChg + " " + dayPctChg + " " + totalShrs);
                }
                System.out.println();
            }

            //return new com.wiltrahan.Stock(symbol, value);
            //rs.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Stocks Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    private static List<Total> getTotals() throws ClassNotFoundException {
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

            for(String date : dates) {
                rs = stmt.executeQuery("SELECT " + "portfolioTotal" + ", " +
                                                        "portfolioDayGain "  +
                                                        "FROM " + "'" + date + "'" +
                                                        "WHERE " + "portfolioTotal " + "IS NOT NULL");
                while (rs.next()) {
                    System.out.println(date);
                    String total = rs.getString(COLUMN_TOTAL_PORTFOLIO);
                    String dayGain = rs.getString(COLUMN_TOTAL_DAYGAIN);
                    System.out.println(total + " " + dayGain);
                    //Total totalView = new Total(total, dayGain);
                    totals.add(new Total(total, dayGain));
                    //toBrowser(total);

                }
                System.out.println();
            }
            //rs.close();
            //return totals;

        } catch (SQLException e) {
            System.out.println("Totals Error: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println(totals.size());
        //printTest();
        return totals;

    }

//    private static void printTest() {
//        System.out.println("TEST: " + totals.get(1).getPortfolioTotal());
//    }

    public static List<String> testStrings() {
        List<String> work = new ArrayList<>();
        work.add("Will");
        work.add("This");
        work.add("Work?");

        return work;
    }
}
