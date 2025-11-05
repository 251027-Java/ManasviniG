package expenses.example.Repository;

import expenses.example.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TextRepository implements IRepository {
    // Fields
    private String filename = "FirstProject\\expense.txt";

    // Constructors
    public TextRepository() {}

    public TextRepository(String filename) {
        this.filename = filename;
    }

    // Methods
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String lines = "";
        try {
            FileReader reader = new FileReader(filename);
            lines = reader.readAllAsString();

            for (String line : lines.split("],")) {
                line = line.replace("]]", "");
                String[] element = line.split(", |=");

                int id = Integer.parseInt(element[1]);
                Date date = new Date(element[3]);
                double value = Double.parseDouble(element[5]);
                String merchant = element[7];

                expenses.add(new Expense(id, date, value, merchant));
            }

        } catch(IOException e) {
            IO.println(e);
        }
        return expenses;
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            FileWriter file = new FileWriter(filename, false);
            PrintWriter writer = new PrintWriter(file, true);

            writer.print("[");
            for (int i = 0; i < expenses.size() - 1; i++) {
                writer.print(expenses.get(i) + ",");
            }
            writer.print(expenses.getLast() + "]");

            file.close();
        } catch (Exception e){
            System.out.println("Error writing file.");
        }
    }
}
