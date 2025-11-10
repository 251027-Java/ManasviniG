package org.example.Repository;

import org.example.Expense;

import java.sql.*;
import java.util.List;

public class H2Repository implements IRepository {
    // Fields
    private static final String H2_URL = "jdbc:h2:mem:expenses;DB_CLOSE_DELAY=-1";
    private Connection connection;

    // Constructor
    public H2Repository() {
        //Create database
        try {
            connection = DriverManager.getConnection(H2_URL);
            try (Statement st = connection.createStatement()) {
                String sql =
                        "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                        "CREATE TABLE IF NOT EXISTS ExpenseReport.expenses (" +
                            "id INT PRIMARY KEY," +
                            "date TIMESTAMP NOT NULL," +
                            "price FLOAT CHECK (price > 0)," +
                            "merchant VARCHAR(60) NOT NULL" +
                        ");";
                st.execute(sql);

                IO.println("Successful creation of H2 DB");
            }
        } catch(SQLException e) {
            IO.println(e);
        }
    }

    //Methods
    @Override
    public void createExpense(Expense expense) {
        String sql = "INSERT INTO ExpenseReport.expenses (id, date, price, merchant) " +
                "VALUES ( ?, ?, ?, ?);";

        try(PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, expense.getId());
            st.setTimestamp(2, new Timestamp(expense.getDate().getTime()));
            st.setFloat(3, (float)expense.getValue());
            st.setString(4, expense.getMerchant());

            st.executeUpdate();
            IO.println("Expense Created");
        } catch(SQLException e) {
            IO.println(e);
        }
    }

    @Override
    public Expense readExpense(int id) {
        String sql = "SELECT * FROM ExpenseReport.expenses WHERE id = ?;";
        try(PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                int resultID = rs.getInt("id");
                java.util.Date resultDate = new java.util.Date(rs.getTimestamp("date").getTime());
                float resultValue = rs.getFloat("price");
                String resultMerchant = rs.getString("merchant");

                return new Expense(resultID, resultDate, resultValue, resultMerchant);
            }
        } catch(SQLException e) {
            IO.println(e);
        }
        return null;
    }

    @Override
    public void updateExpense(Expense expense) {
        // TODO
    }

    @Override
    public void deleteExpense(int id) {
        // TODO
    }

    @Override
    public List<Expense> loadExpenses() {
        return List.of();
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {
        // TODO
    }
}
