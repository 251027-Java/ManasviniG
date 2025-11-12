package org.example.Repository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.example.Expense;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoRepository implements IRepository {
    // Fields
    private final MongoCollection<Document> expensesCollection;

    // connection String allows us to access db, format it like below
    // "[language]://[username]:[password]@[host]/[database]?[options]
    private static final String connectionString =
            "mongodb://mongoadmin:secret@localhost:27017";

    // Constructor
    public MongoRepository() {
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase database = mongoClient.getDatabase("my_mongoexpensedb");
        this.expensesCollection = database.getCollection("expenses");
        IO.println("Mongo connected");
    }

    //Methods
    private Expense documentToExpense(Document doc) {
        return new Expense( doc.getInteger("_id"),
                            doc.getDate("date"),
                            doc.getDouble("price"),
                            doc.getString("merchant"));
    }

    private Document expenseToDocument(Expense expense) {
        return new Document("_id", expense.getId())
                .append("date", expense.getDate())
                .append("price", expense.getValue())
                .append("merchant", expense.getMerchant());
    }

    @Override
    public void createExpense(Expense expense) {
        Document expenseDoc = expenseToDocument(expense);
        expensesCollection.insertOne(expenseDoc);
    }

    @Override
    public Expense readExpense(int id) {
        Document doc = expensesCollection.find(Filters.eq("_id", id)).first();
        return (doc != null) ? documentToExpense(doc) : null;
    }

    @Override
    public void updateExpense(Expense expense) {
        Document updateDoc = expenseToDocument(expense);
        expensesCollection.updateOne(Filters.eq("_id", expense.getId()), updateDoc);
    }

    @Override
    public void deleteExpense(int id) {
        expensesCollection.deleteOne(Filters.eq("_id", id));
    }

    @Override
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();
        for (Document doc : expensesCollection.find()) {
            expenses.add(documentToExpense(doc));
        }
        return expenses;
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {
        // TODO
    }
}
