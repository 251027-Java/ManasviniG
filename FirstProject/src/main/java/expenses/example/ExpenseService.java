package expenses.example;

import expenses.example.Repository.CSVRepository;
import expenses.example.Repository.IRepository;
import expenses.example.Repository.JSONRepository;
import expenses.example.Repository.TextRepository;

import java.util.Date;
import java.util.List;

public class ExpenseService {
    // Fields
    private IRepository repo;

    // Constructor
    public ExpenseService(IRepository repo) {
        this.repo = repo;
    }

    // Methods
    public boolean createExpense(int id, Date date, double value, String merchant) {
        if(repo.readExpense(id) == null) {
            repo.createExpense(new Expense(id, date, value, merchant));
            return true;
        }
        return false;
    }

    public Expense getExpense(int id) {
        if(repo.readExpense(id) != null) {
            return repo.readExpense(id);
        }
        else
            IO.println("Expense doesn't exist!");
        return null;
    }

    public boolean containsExpense(int id) {
        if(repo.readExpense(id) != null)
            return true;
        else
            return false;
    }

    public boolean updateExpense(Expense e) {
        if(repo.readExpense(e.getId()) != null) {
            repo.updateExpense(e);
            return true;
        }
        return false;
    }

    public Expense deleteExpense(int id) {
        Expense e = repo.readExpense(id);
        if(e != null) {
            repo.deleteExpense(id);
            return e;
        }
        return null;
    }

    public List<Expense> getAllExpenses() {
        return repo.loadExpenses();
    }

    public void addExpenseList(List<Expense> expenses) {
        if(!expenses.isEmpty()) {
            repo.saveExpenses(expenses);
        }
    }

    public void printAllExpenses() {
        IO.println(repo.loadExpenses());
    }

    public double sumExpenses() {
        List<Expense> expenses = repo.loadExpenses();
        double sum = 0;
        for(Expense expense : expenses) {
            sum += expense.getValue();
        }
        return sum;
    }
}
