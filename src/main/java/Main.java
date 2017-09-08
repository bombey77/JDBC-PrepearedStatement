import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {

    private static String URL ="jdbc:mysql://localhost:3306/sqldb";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    private static final String INPUT = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";

    public static void main(String[] args) {
        Connection connection;

        PreparedStatement preparedStatement = null;

        try {
            Driver driver = new FabricMySQLDriver();

            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            preparedStatement = connection.prepareStatement(INPUT);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Title");
            preparedStatement.setString(3, "Description");
            preparedStatement.setDouble(4, 4.5);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("ic_accessibility_black_48dp.png"));

            preparedStatement.execute();

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
