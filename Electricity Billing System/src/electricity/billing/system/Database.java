package electricity.billing.system;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    Connection connection;
    Statement statement;

    Database() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bil_system", "root", "Vysu@10_11");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

