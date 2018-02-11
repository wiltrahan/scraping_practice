import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/twilorip/Desktop/scraping_practice/WebDriver_basics/portfolio.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS portfolio " +
                                    "(symbol TEXT, value DOUBLE, change TEXT, shares INTEGER)");
            statement.execute("INSERT INTO portfolio (symbol, value, change, shares)" +
                                    "VALUES('GE', 14.94, '+3.39%', 500)");

            statement.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong " + e.getMessage());
        }

    }
}
