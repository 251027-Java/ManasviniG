package expenses.example.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import expenses.example.Expense;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class JSONRepository implements IRepository {
    // Fields
    private String filename = "gsonExpenses.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Constructors
    public JSONRepository() {}

    // Methods
    public void saveExpenses(List<Expense> expenses) {
        try {
            FileWriter fw = new FileWriter(filename);
            gson.toJson(expenses, fw);
            fw.close();
            IO.println("JSON file has been written in!");

        } catch(IOException e) {
            IO.println(e);
        }
    }
}
