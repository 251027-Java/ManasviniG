package expenses.example;

import expenses.example.Repository.JSONRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseService(new JSONRepository());
        List<Expense> expenses = new ArrayList<>();
        expenses.add(new Expense(9, new Date(), 99.95, "Walmart"));
        expenses.add(new Expense(12, new Date(), 100.01, "Costco"));
        expenses.add(new Expense(13, new Date(), 3000000, "Private Island"));

        service.addExpenseList(expenses);
        IO.println(service.sumExpenses());
        IO.println(service.containsExpense(1));
    }
}
