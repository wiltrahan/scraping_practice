import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static void main(String[] args) {
//
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
//            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS portfolio " +
//                    "(symbol TEXT, value DOUBLE, change TEXT, shares INTEGER)");
//            statement.execute("INSERT INTO portfolio (symbol, value, change, shares)" +
//                    "VALUES('GE', 14.94, '+3.39%', 500)");
//
//            statement.close();
//            conn.close();
//
//        } catch(SQLException e) {
//            System.out.println("Something went wrong " + e.getMessage());
//        }
//
        DB db = new DB();
        if(!db.open()) {
            System.out.println("Can't open DB");
            return;
        }
        db.createDB();
        db.close();
    }

    public static final String DB_NAME = "portfolio.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/" + DB_NAME;

    public static final String TABLE_STOCKS = "stocks";
    public static final String COLUMN_STOCK_SYMBOL = "symbol";
    public static final String COLUMN_STOCK_VALUE = "value";
    public static final String COLUMN_STOCK_DAYAMTCHG = "dayAmtChg";
    public static final String COLUMN_STOCK_DAYPCTCHG = "dayPctChg";
    public static final String COLUMN_STOCK_TOTALSHRS = "totalShrs";

    public static final String TABLE_TOTALS = "totals";
    public static final String COLUMN_TOTAL_PORTFOLIO = "portfolioTotal";
    public static final String COLUMN_TOTAL_DAYGAIN = "portfolioDayGain";
    public static final String COLUMN_TOTAL_GAINTOTAL = "portfolioGainTotal";

    private Connection conn;

    private void createDB() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_STOCKS +
                                " (" + COLUMN_STOCK_SYMBOL + " text, " +
                                       COLUMN_STOCK_VALUE + " text, " +
                                       COLUMN_STOCK_DAYAMTCHG + " text, " +
                                       COLUMN_STOCK_DAYPCTCHG + " text, " +
                                       COLUMN_STOCK_TOTALSHRS + " text" +
                                ")");
            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_TOTALS +
                                " (" + COLUMN_TOTAL_PORTFOLIO + " text, " +
                                       COLUMN_TOTAL_DAYGAIN + " text, " +
                                       COLUMN_TOTAL_GAINTOTAL + " text" +
                                ")");

        } catch (SQLException e) {
            System.out.println("Couldn't create DB: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
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
}