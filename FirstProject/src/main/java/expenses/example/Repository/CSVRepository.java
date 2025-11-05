package expenses.example.Repository;

import expenses.example.Expense;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CSVRepository implements IRepository {
    // Fields
    private String filename = "FirstProject\\expenses.csv";

    // Constructors
    public CSVRepository() {}

    public CSVRepository(String filename) {
        this.filename = filename;
    }

    // Methods
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        String line = "";
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(filename));
            buffer.readLine();

            while((line = buffer.readLine()) != null) {
                String[] tmp = line.split(",");

                int id = Integer.parseInt(tmp[0]);
                Date date = new Date(tmp[1]);
                double value = Double.parseDouble(tmp[2]);
                String merchant = tmp[3].strip();

                expenses.add(new Expense(id, date, value, merchant));
            }
        } catch(IOException e) {
            IO.println(e);
        }
        return expenses;
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            BufferedWriter writer = new BufferedWriter( new FileWriter(filename));

            writer.write("id, date, value, merchant");
            writer.newLine();

            for( Expense ex : expenses ) {
                writer.write(ex.toCSV());
                writer.newLine();
            }

            writer.flush();
            writer.close();
            System.out.println("File written successfully");

        } catch (Exception e){
            System.out.println("Error writing file.");
        }
    }
}
