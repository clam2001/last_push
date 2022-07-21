package taxCalculator.resource;

import taxCalculator.domain.TaxPayer;

import java.sql.*;

public class TaxCalculatorResource {

    //read
    public static void read(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();

        //displaying some information

        try {
            String query = "select * from tax_payer";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //insert
    public static void insert(){
        Connection connection = null;
        Statement statement = null;

        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();

        try{
            String query = "insert into tax_payer(tax_payer_id, name, surname, age, salary, bonuses, interest_received, dividends, total_capital_gain, retirement_funding, travel_allowance)" +
                    "values (123456, 'Connel', 'Manhica', 25, 600000.00, 25000.00, 45312.00, 15381.00, 800000.00, 162000.00, 90000.00);";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Success");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateTaxPayer(TaxPayer taxPayer, String updateKey, String updateKeyValue){
        Connection connection = null;
        Statement statement = null;

        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();

        try{
            String query;
            if (updateKey.equals("name") || updateKey.equals("surname")){
                query = "update tax_payer set " + updateKey + " = '" + updateKeyValue + "' where tax_payer_id = " + taxPayer.getNumber();
            }
            else{
                query = "update tax_payer set " + updateKey + " = " + updateKeyValue + " where tax_payer_id = " + taxPayer.getNumber();
            }

            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println(updateKey + " is updated with value '" + updateKeyValue + "'" );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean isInDatabase(int taxPayerNo){
        //sql code to check if the taxpayer exists in the database
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
        String resultSetString = "";
        //displaying some information

        try {
            String query = "select * from tax_payer where tax_payer_id = " + taxPayerNo;
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                resultSetString = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (resultSetString.equals("")){
            return false;
        }
        //return true or false
        return true;
    }

    public TaxPayer retrieveTaxPayer(int taxPayerNo){
        //sql to get taxpayer details from the database
        //return TaxPayerObject

        return new TaxPayer(1234567,"Gearge", "Muta", 34 );
    }
}
