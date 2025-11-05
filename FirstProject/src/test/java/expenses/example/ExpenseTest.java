package expenses.example;

import java.util.Date;

public class ExpenseTest {
    public static void main(String[] args) { testExpenseCreation(); }

    public static void testExpenseCreation() {
        // Arrange test conditions
        Expense expense = new Expense(1, new Date(), 100.00, "DummyMerchant");

        // ACT - what functionality are we trying to validate?
        int actualID = expense.getId();
        double actualValue = expense.getValue();

        // Assertion - Compare expected and actual
        if(actualID != 1)  IO.println("id failed");
        else if(actualValue != 100.00) IO.println("value failed");
        else IO.println("Expense created successfully");
    }
}
