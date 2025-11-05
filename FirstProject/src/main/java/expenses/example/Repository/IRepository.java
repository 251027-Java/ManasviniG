package expenses.example.Repository;

import expenses.example.Expense;
import java.util.List;
import java.util.stream.Collectors;

public interface IRepository {

    public default void createExpense(Expense expense) {
        List<Expense> expenses = loadExpenses();
        expenses.add(expense);
        saveExpenses(expenses);
    }

    public default Expense readExpense(int id) {
        return loadExpenses().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public default void updateExpense(Expense expense) {
        List<Expense> expenses = loadExpenses();
        List<Expense> updatedExpenses = expenses.stream()
                .map(e -> (e.getId() == expense.getId()) ? expense : e)
                .collect(Collectors.toList());
        saveExpenses(updatedExpenses);
    }

    public default void deleteExpense(int id) {
        List<Expense> expenses = loadExpenses();
        expenses.removeIf(e -> e.getId() == id);
        saveExpenses(expenses);
    }

    public List<Expense> loadExpenses(); // read from file
    public void saveExpenses(List<Expense> expenses); // write to file
}
