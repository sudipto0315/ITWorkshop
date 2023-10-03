import java.util.Scanner;

class Account {
    static Scanner sc = new Scanner(System.in);
    int accountNumber;
    String accountType;
    String serviceBranchIFSC;
    float minimumBalance;
    float availableBalance;
    int customerID;
    String customerName;
    static int totalAccountCreated;

    Account() {
        accountNumber = 0;
        accountType = " ";
        serviceBranchIFSC = " ";
        minimumBalance = 0.0f;
        availableBalance = 0.0f;
        customerID = 0;
        customerName = " ";
        totalAccountCreated++;
    }

    public void setDetails(int an, String at, String sb, float mb, float ab, int cid, String cn) {
        accountNumber = an;
        accountType = at;
        serviceBranchIFSC = sb;
        minimumBalance = mb;
        availableBalance = ab;
        customerID = cid;
        customerName = cn;
    }

    public void getDetails(int an) {
        System.out.println("\nDetails: ");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account type: " + accountType);
        System.out.println("Service branch: " + serviceBranchIFSC);
        System.out.println("Minimum balance: " + minimumBalance);
        System.out.println("Available balance: " + availableBalance);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Customer name: " + customerName);
    }

    void updateDetails(int an) {
        int newAccountNumber;
        String newAccountType;
        String newServiceBranchIFSC;
        float newMinimumBalance;
        float newAvailableBalance;
        int newCustomerID;
        String newCustomerName;
        System.out.print("Enter the new account number: ");
        newAccountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new account type: ");
        newAccountType = sc.nextLine();
        System.out.print("Enter the new service branch: ");
        newServiceBranchIFSC = sc.nextLine();
        System.out.print("Enter the new minimum balance: ");
        newMinimumBalance = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter the new available balance: ");
        newAvailableBalance = sc.nextFloat();
        sc.nextLine();
        System.out.print("Enter the new customer ID: ");
        newCustomerID = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the new customer name: ");
        newCustomerName = sc.nextLine();
        setDetails(newAccountNumber, newAccountType, newServiceBranchIFSC, newMinimumBalance, newAvailableBalance, newCustomerID, newCustomerName);
    }

    public float[] getBalance(int an) {
        float balance[] = new float[2];
        balance[0] = minimumBalance;
        balance[1] = availableBalance;
        return balance;
    }

    void deposit(int an, float amt) {
        availableBalance += amt;
        System.out.println("Amount deposited: " + amt);
        System.out.println("New available balance: " + availableBalance);
    }

    void withdraw(int an, float amt) {
        availableBalance -= amt;
        System.out.println("Amount withdrawn: " + amt);
        System.out.println("New available balance: " + availableBalance);
    }

    static int totalAccounts() {
        return totalAccountCreated;
    }

    int getAccountNumber() {
        return accountNumber;
    }
}

public class q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of objects: ");
        int n = sc.nextInt();
        Account objects[] = new Account[n];
        int accnum, cID;
        String acctype, cname, sbIFSC;
        float minB, avB;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for "+ i +"->");
            objects[i] = new Account();
            System.out.print("Enter the account number: ");
            accnum = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter account type: ");
            acctype = sc.nextLine();
            System.out.print("Enter the service branch: ");
            sbIFSC = sc.nextLine();
            System.out.print("Enter the minimum balance: ");
            minB = sc.nextFloat();
            sc.nextLine();
            System.out.print("Enter the available balance: ");
            avB = sc.nextFloat();
            sc.nextLine();
            System.out.print("Enter customer ID: ");
            cID = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter the customer name: ");
            cname = sc.nextLine();
            objects[i].setDetails(accnum, acctype, sbIFSC, minB, avB, cID, cname);
            System.out.println();
        }
        int ch;
        char ans = 'y';
        while (ans == 'y' || ans == 'Y') {
            System.out.print("\n");
            System.out.println("1.Update details");
            System.out.println("2.Get details");
            System.out.println("3.Deposit");
            System.out.println("4.Withdraw");
            System.out.println("5.Total accounts created");
            System.out.println("6.EXIT");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter the required ID: ");
                    int id2 = sc.nextInt();
                    for (int i = 0; i < objects.length; i++) {
                        if (objects[i].accountNumber == id2) {
                            objects[i].updateDetails(id2);
                        }
                    }
                    System.out.println("Account Details Were Updated!");
                    break;

                case 2:
                    System.out.print("Enter the required ID: ");
                    int id1 = sc.nextInt();
                    for (int i = 0; i < objects.length; i++) {
                        if (objects[i].accountNumber == id1) {
                            objects[i].getDetails(id1);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the required ID: ");
                    int id4 = sc.nextInt();
                    System.out.println("Enter amount to be deposited: ");
                    float amt_d = sc.nextFloat();
                    for (int i = 0; i < n; i++) {
                        if (objects[i].accountNumber == id4) {
                            objects[i].deposit(id4, amt_d);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter the required ID: ");
                    int id5 = sc.nextInt();
                    System.out.println("Enter amount to be withdrawn: ");
                    float amt_w = sc.nextFloat();
                    for (int i = 0; i < n; i++) {
                        if (objects[i].accountNumber == id5) {
                            objects[i].withdraw(id5, amt_w);
                        }
                    }
                    break;

                case 5:
                    int totalAccounts = Account.totalAccounts();
                    System.out.println("Total number of accounts: " + totalAccounts);
                    break;

                case 6:
                    System.out.println("Exit from system");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            System.out.print("Do you want to continue? (y/n): ");
            ans = sc.next().charAt(0);
        }
    }
}
