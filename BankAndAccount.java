import java.util.ArrayList;
import java.util.List;

// Main class to demonstrate association
public class BankAndAccount {
    public static void main(String[] args) {
        // Creating banks
        Bank axisBank = new Bank("Axis Bank");
        Bank iciciBank = new Bank("ICICI Bank");

        // Creating customers
        Customer cust1 = new Customer("Harman Veer Singh");
        Customer cust2 = new Customer("Ravinder Kaur");

        // Opening accounts in different banks
        axisBank.createAccount(cust1, 7000);
        iciciBank.createAccount(cust1, 15000);
        axisBank.createAccount(cust2, 9000);

        // Viewing balance for each customer
        cust1.showBalance();
        cust2.showBalance();

        // Displaying customers of each bank
        axisBank.listCustomers();
        iciciBank.listCustomers();
    }
}

// Bank class
class Bank {
    private String bankName;
    private List<Customer> clientList;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.clientList = new ArrayList<>();
    }

    public void createAccount(Customer customer, double initialAmount) {
        customer.addBankAccount(new Account(this, initialAmount));
        if (!clientList.contains(customer)) {
            clientList.add(customer);
        }
        System.out.println("Account opened for " + customer.getClientName() + " at " + bankName + " with initial balance: " + initialAmount);
    }

    public String getBankName() {
        return bankName;
    }

    public void listCustomers() {
        System.out.println("\nCustomers of " + bankName + ":");
        for (Customer client : clientList) {
            System.out.println(client);
        }
    }
}

// Customer class
class Customer {
    private String clientName;
    private List<Account> accountList;

    public Customer(String clientName) {
        this.clientName = clientName;
        this.accountList = new ArrayList<>();
    }

    public void addBankAccount(Account account) {
        accountList.add(account);
    }

    public String getClientName() {
        return clientName;
    }

    public void showBalance() {
        System.out.println("\n" + clientName + "'s Accounts:");
        for (Account acc : accountList) {
            System.out.println("Bank: " + acc.getBank().getBankName() + ", Balance: " + acc.getBalance());
        }
    }

    @Override
    public String toString() {
        return clientName + " (Accounts: " + accountList.size() + ")";
    }
}

// Account class
class Account {
    private Bank associatedBank;
    private double accBalance;

    public Account(Bank associatedBank, double accBalance) {
        this.associatedBank = associatedBank;
        this.accBalance = accBalance;
    }

    public Bank getBank() {
        return associatedBank;
    }

    public double getBalance() {
        return accBalance;
    }
}
//output
//Account opened for Harman Veer Singh at Axis Bank with initial balance: 7000.0
//Account opened for Harman Veer Singh at ICICI Bank with initial balance: 15000.0
//Account opened for Ravinder Kaur at Axis Bank with initial balance: 9000.0
//
//Harman Veer Singh's Accounts:
//Bank: Axis Bank, Balance: 7000.0
//Bank: ICICI Bank, Balance: 15000.0
//
//Ravinder Kaur's Accounts:
//Bank: Axis Bank, Balance: 9000.0
//
//Customers of Axis Bank:
//Harman Veer Singh (Accounts: 2)
//Ravinder Kaur (Accounts: 1)
//
//Customers of ICICI Bank:
//Harman Veer Singh (Accounts: 2)