import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double transaction) {
        if (findCustomer(name) != null) return false;

        Customer customer = new Customer(name);
        customer.addTransaction(transaction);
        customers.add(customer);

        return customers.contains(customer);
    }

    public boolean addCustomerTransaction(String name, double transaction) {
        Customer customer = findCustomer(name);
        if (customer == null) return false;

        customer.addTransaction(transaction);

        ArrayList<Double> transactions = customer.getTransactions();
        return transactions.get(transactions.size()-1) == transaction;
    }

    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }

        return null;
    }
}
