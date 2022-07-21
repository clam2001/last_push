package taxCalculator.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection getConnection(){

        Connection connection = null;


        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/taxcalculator", "postgres", "admin");

            if (connection != null){
                System.out.println("Database Connection Ok");
            }else {
                System.out.println("Database Connection Failed");
            }
        } catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }
}
