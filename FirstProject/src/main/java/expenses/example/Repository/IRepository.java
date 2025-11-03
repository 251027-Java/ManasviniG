package expenses.example.Repository;

import expenses.example.Expense;
import java.util.List;

public interface IRepository {
    public void saveExpenses(List<Expense> expenses);
}
