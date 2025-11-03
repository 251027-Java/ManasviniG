package expenses.example.Repository;

import expenses.example.Expense;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CSVRepository implements IRepository {
    // Fields
    private String filename = "expenses.csv";

    // Constructors
    public CSVRepository() {}

    // Methods
    public void saveExpenses(List<Expense> expenses) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));

            writer.write("[");
            writer.newLine();

            for (int i = 0; i < expenses.size() - 1; i++) {
                writer.write("\t" + expenses.get(i).toJSON() + ",");
                writer.newLine();
            }
            writer.write("\t" + expenses.getLast().toJSON());
            writer.newLine();

            writer.write("]");
            writer.flush();
            writer.close();

            IO.println("CSV file has been written in!");

        } catch (IOException e) {
            IO.println(e);
        }
    }
}
