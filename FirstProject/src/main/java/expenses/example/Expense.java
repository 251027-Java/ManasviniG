package expenses.example;

import java.util.Date;

public class Expense {

    // Fields
    private int id;
    private Date date;
    private double value;
    private String merchant;

    // Constructor
    public Expense(int id, Date date, double value, String merchant) {
        this.id = id;
        this.date = date;
        this.value = value;
        this.merchant = merchant;
    }

    // Methods
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public Date getDate() { return this.date; }
    public void setDate(Date date) { this.date = date; }

    public double getValue() { return this.value; }
    public void setValue(double value) { this.value = value; }

    public String getMerchant() { return this.merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }

    @Override
    public String toString() {
        return "Expense [id=" + this.id + ", date=" + this.date + ", value=" + this.value + ", merchant=" + this.merchant + "]";
    }

    @Override
    public boolean equals(Object o) {
        Expense e = (Expense) o;
        if(this.id == e.getId() && this.date.equals(e.getDate()) && this.value == e.getValue() && this.merchant.equals(e.getMerchant())) {
            return true;
        } else {
            return false;
        }
    }

    public String toCSV() {
        return this.id + ", " + this.date + ", " + this.value + ", " + this.merchant;
    }

    public String toJSON(){
        return "{\"id\":" + this.id + ", \"date\":\"" + this.date + "\", \"value\":" + this.value + ", \"merchant\":\"" + this.merchant + "\"}";
    }
}
