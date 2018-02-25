import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryDB {

    private static final String DB_NAME = "portfolio.db";
    private static final String CONNECTION_STRING = "jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/" + DB_NAME;

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
    public static final String DATE = "02/22/2018 15:32:31";

    private static Connection conn;

    //List<String>dates = new ArrayList<>();

    public static void main(String[] args) {
        getTables();
    }

    private static void getTables() {
        List<String> dates = new ArrayList<>();
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement stmt = conn.createStatement();
            ResultSet rs;

            //rs = stmt.executeQuery("SELECT * FROM " + "'" + DATE + "'" );
            rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table'");
            while(rs.next()) {
                dates.add(rs.getString(1));
                //System.out.println(rs.getString(1));
                //System.out.println(dates.size());
            }

        } catch (SQLException e) {
            System.out.println("So sorry: " + e.getMessage());
            e.printStackTrace();
        }
        getStocks(dates);
    }


    private static void getStocks(List<String>dates) {

        try{
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement stmt = conn.createStatement();
            ResultSet rs = null;

            for(String date : dates) {
                System.out.println("Date " + date);
                rs = stmt.executeQuery("SELECT * FROM " + "'" + date + "'" + " WHERE" + " symbol " + "IS NOT NULL");
                while (rs.next()) {
                    System.out.println(rs.getString("symbol") + " " + rs.getString("value"));
                    //System.out.println(rs.getString("value"));

                }
            }
            rs.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }



    }

}
