package expenses.example.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import expenses.example.Expense;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;

public class JSONRepository implements IRepository {
    // Fields
    private String filename = "C:\\Users\\manas\\Programs\\Revature\\ManasviniG\\FirstProject\\gsonExpenses.json";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Constructors
    public JSONRepository() {}

    public JSONRepository(String filename) {
        this.filename = filename;
    }

    // Methods
    public List<Expense> loadExpenses() {
        String line = "";
        try {
            JsonReader reader = new JsonReader(new FileReader(filename));
            Type expensesType = new TypeToken<List<Expense>>(){}.getType();

            List<Expense> expenses = gson.fromJson(reader, expensesType);
            return (expenses != null) ? expenses : new ArrayList<>();

        } catch(IOException e) {
            IO.println(e);
            return new ArrayList<>();
        }
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            FileWriter fw = new FileWriter(filename);
            gson.toJson(expenses, fw);
            fw.close();
        } catch(IOException e) {
            IO.println(e);
        }
    }
}
