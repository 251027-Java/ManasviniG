package expenses.example.Repository;

import expenses.example.Expense;

import java.util.List;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class TextRepository implements IRepository {
    // Fields
    private String filename = "expense.txt";

    // Constructors
    public TextRepository() {}

    // Methods
    public void saveExpenses(List<Expense> expenses) {
        try {
            FileWriter file = new FileWriter(filename);
            PrintWriter writer = new PrintWriter(file, true);

            writer.println("Id, Date, Value, Merchant");
            for (Expense expense : expenses) {
                writer.println(expense);
            }
            file.close();
            IO.println("Text file has been written in!");

        } catch (IOException e) {
            IO.println(e);
        }
    }
}
