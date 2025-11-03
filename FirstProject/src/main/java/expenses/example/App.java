package expenses.example;

import expenses.example.Repository.CSVRepository;
import expenses.example.Repository.IRepository;
import expenses.example.Repository.JSONRepository;
import expenses.example.Repository.TextRepository;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

// User Story:
// As a user, I want to track my expenses so that I can build/submit an expense report
// at the end of the week.
// As a user, I want to include the date, value, and merchant to include on my expense
// report.

public class App {
    public static void main(String[] args) {

        List<Expense> expenses = new ArrayList<Expense>();

        IO.println("Expense Tracker Starting...");
        IO.println("Creating test expense:");

        expenses.add(new Expense(11, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(12, new Date(), 100.01, "Costco"));
        expenses.add(new Expense(13, new Date(), 3000000, "Private Island"));
        IO.println(expenses);

        IO.println("Expense Tracker Closing...\n");
        IO.println("Writing Into Files...");

        // Write into text file
        IRepository repo = new TextRepository();
        repo.saveExpenses(expenses);

        // Write into csv file
        repo = new CSVRepository();
        repo.saveExpenses(expenses);

        // Write into json file
        repo = new JSONRepository();
        repo.saveExpenses(expenses);

        IO.println("File written successfully");
    }
}