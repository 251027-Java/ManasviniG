package org.example.Service;

import org.example.Repository.IRepository;
import org.example.Repository.JSONRepository;
import org.example.Expense;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTest {

    @Mock
    IRepository repo = new JSONRepository();

    @InjectMocks
    ExpenseService expenseService = new ExpenseService(repo);

    @Test
    void testCreateExpense() {
        Expense test = new Expense(1, new Date(), 50, "Dummy");
        assertInstanceOf(Expense.class, expenseService.createNewExpense(1, new Date(), 50.00,
                "Dummy"));
    }

    @Test
    void testGetExpense() {
        Expense test = new Expense(2, new Date(), 100.00, "Dummy");

        when(repo.readExpense(test.getId())).thenReturn(test);

        expenseService.createExpense(test.getId(), test.getDate(), test.getValue(),
                test.getMerchant());
        Expense result = expenseService.getExpense(2);
        assertEquals(test.getValue(), expenseService.getExpense(2).getValue());
    }

    @Test
    void testContainsExpense() {
        Expense test = new Expense(3, new Date(), 100.00, "Dummy");
        expenseService.createExpense(test.getId(), test.getDate(), test.getValue(),
                test.getMerchant());
        assertTrue(expenseService.containsExpense(test.getId()));
        assertFalse(expenseService.containsExpense(56));
    }

    @Test
    void testUpdateExpense() {
        Expense test = new Expense(4, new Date(), 100.00, "Dummy");
        expenseService.createExpense(test.getId(), test.getDate(), test.getValue(),
                test.getMerchant());
        test.setValue(60);
        assertTrue(expenseService.updateExpense(test));
        assertEquals(60, expenseService.getExpense(test.getId()).getValue());
    }

    @Test
    void testDeleteExpense() {
        Expense test = new Expense(5, new Date(), 50, "Dummy");
        expenseService.createExpense(test.getId(), test.getDate(), test.getValue(),
                test.getMerchant());
        assertEquals(test.getValue(), expenseService.deleteExpense(test.getId()).getValue());
    }

    @Test
    void testGetAllExpenses() {
        assertFalse(expenseService.getAllExpenses().isEmpty());
    }

    @Test
    void testAddExpenseList() {
        List<Expense> testList = new ArrayList<>();
        Expense test1 = new Expense(6, new Date(), 99, "Dummy");
        Expense test2 = new Expense(7, new Date(), 59, "Dummy");
        testList.add(test1);
        testList.add(test2);

        expenseService.addExpenseList(testList);
        assertEquals(test1.getValue(), expenseService.getExpense(test1.getId()).getValue());
    }

    @Test
    void testSumExpenses() {
        List<Expense> testList = new ArrayList<>();
        Expense test1 = new Expense(6, new Date(), 99, "Dummy");
        Expense test2 = new Expense(7, new Date(), 59, "Dummy");
        testList.add(test1);
        testList.add(test2);

        expenseService.addExpenseList(testList);
        assertEquals(158.0, expenseService.sumExpenses());
    }
}
