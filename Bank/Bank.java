import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public boolean addBranch(String name) {
        if (findBranch(name) != null) return false;

        Branch branch = new Branch(name);
        branches.add(branch);

        return branches.contains(branch);
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) return false;

        branches.get(branches.indexOf(branch)).newCustomer(customerName, transaction);
        return true;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch == null) return false;

        branches.get(branches.indexOf(branch)).addCustomerTransaction(customerName, transaction);
        return true;
    }

    public void listCustomers(String branchName, boolean includeTransactions) {
        Branch branch = findBranch(branchName);

        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> customers = branch.getCustomers();
            for (int i = 0; i < customers.size(); i++) {
                Customer customer = customers.get(i);
                ArrayList<Double> transactions = customer.getTransactions();

                System.out.printf("Customer: %s[%d]\n", customer.getName(), (i+1));

                if (includeTransactions) {
                    System.out.println("Transactions");
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.printf("[%d] Amount %.2f\n", (j+1), transactions.get(j));
                    }
                }
            }
        }

    }

    private Branch findBranch(String name) {
        for (Branch b : branches) {
            if (b.getName().equals(name)) {
                return b;
            }
        }

        return null;
    }
}