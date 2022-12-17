package com.computer.software.os.windows.bankapplication;
import com.computer.software.os.os.ApplicationInterface;
import com.computer.software.os.mac.application.Application;

import java.util.Scanner;
public class BankApp implements Application {

    @Override
    public String getName() {
        return "Banking Application";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public void run(ApplicationInterface sys) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t.*.*.*.*.*.*.*.Welcome to net-banking application*.*.*.*.*.*.*.*.");
            System.out.println("1.HDFC\n2.SBI\n3.ICICI\n4.EXIT");
            System.out.println("Select the bank you want to work with");
            int bankName = getInteger();
            //creating a bank object
            IBank bank;
            if (getBankName(bankName)==null){
                System.out.println("....THANK YOU....");
                break;
            }else {
                bank = getBankName(bankName);}


            //signup flow.....
            System.out.println("1.Sign up\n2.Sign in\n3.Go to main menu.");
            int x = getInteger();
            if (x == 3) {
                continue;
            }
            else if (x == 1) {
                System.out.print("Enter your username.\nUsername:");
                String userName = sc.next();
                //crosscheck that no user is already present with the same username.
                while (bank.checkUserName(userName)) {
                    System.out.println("This username already exist. \nRetry!!!!");
                    System.out.print("Enter your username\nUsername:.");
                    userName = sc.next();
                }
                System.out.print("Enter your password.\nPassword:");
                String password = sc.next();
                System.out.printf("Deposit a minimum of RS %.2f as initial deposit for creating your account:\n", bank.getMinimumBalance());

                while (true) {
                    double minimumBalance = getDouble();
                    if(minimumBalance>= bank.getMinimumBalance()){
                        //add account  to the respective bank account.
                        Accounts accounts = new Accounts(userName, password,minimumBalance,bankName, bank.getMinimumBalance());
                        bank.addAccount(accounts);
                        accountsFunctions(userName, bank);
                        break;
                    }
                    else {
                        System.out.println("Minimum amount required!!!!!!!!!");
                    }
                }
            } else if (x == 2) {
                System.out.print("Enter your username.\nUsername:");
                String userName = sc.next();
                if (!bank.checkUserName(userName)) {
                    System.out.println("No such user exist!!!.");
                } else {
                    System.out.print("Enter your password.\nPassword:");
                    String password = sc.next();
                    if (bank.checkCredentials(userName, password)) {
                        accountsFunctions(userName, bank);
                    }
                    else {
                        System.out.println("Incorrect password!!!.\n");
                    }
                }
            }
            else {
                System.out.println("Please enter correct option.");
            }
        }
    }
    public static void accountsFunctions(String userName, IBank bankSkeleton) {
        Scanner sc = new Scanner(System.in);
        while(true){
                Accounts userAccount = bankSkeleton.findAccount(userName);
                System.out.println("Please select a function you want to do with your account\n" +
                        "1.Withdraw\n" +
                        "2.Deposit\n" +
                        "3.Transfer\n" +
                        "4.Check Balance\n" +
                        "5.Sign out");
                int function = getInteger();
                if (function == 1) {
                    //WITHDRAW FUNCTION
                    System.out.print("Enter the amount you want to withdraw from your account.\nRS ");
                    double amount = getDouble();
                    try {
                        userAccount.withdraw(amount);
                        System.out.printf("Your account balance is: RS %.2f%n", userAccount.accountBalance);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (function == 2) {
                    //DEPOSIT FUNCTION
                    System.out.print("Enter the amount you want to deposit from your account.\nRS ");
                    double amount = getDouble();
                    userAccount.deposit(amount);
                    System.out.printf("A total of RS %.2f is credited to your account\n",amount);
                    System.out.printf("Your account balance is: RS %.2f%n",userAccount.accountBalance);
                } else if (function == 3) {
                    //TRANSFER FUNCTION
                    System.out.print("Enter the amount you want to transfer from your account.\nRS ");
                    double amount = getDouble();

                    System.out.println("1.HDFC\n2.SBI\n3.ICICI\n4.Exit");
                    System.out.println("Select the bank name:");
                    int bankName = getInteger();

                    System.out.print("Please enter correct username to whom you want to transfer.\nUsername:");
                    String receiver = sc.next();

                    IBank receiverBankSkeleton = getBankName(bankName);
                    Accounts receiverAccount = receiverBankSkeleton.findAccount(receiver);
                    try {
                        userAccount.transfer(amount, receiverAccount);
                        System.out.printf("A total of RS %.2f is transferred from your account to %s's account.\n",amount,receiver);
                        System.out.printf("Your account balance is: RS %5.2f%n", userAccount.accountBalance);
                   }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                } else if (function == 4) {
                    userAccount.checkAccountBalance();
                } else if (function == 5) {
                    break;
                } else {
                    System.out.println("Please enter correct option!!!.");
                }
            }
    }

    public static int getInteger(){
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }
        catch (Exception e){
            System.out.println("Enter correct option!!!.");
            return getInteger();
        }
    }
    public static double getDouble(){
        Scanner sc = new Scanner(System.in);
        double x ;
        try {
            x = sc.nextDouble();
            if(x<=0){
                throw new Exception();
            }
            return x;
        }
        catch (Exception e){
            System.out.println("Enter correct Amount!!!.");
            return getDouble();
        }
    }
    public static IBank getBankName(int bankName) {
        while (true) {
            switch (bankName) {
                case 1:
                    return HDFC.getInstance();
                case 2:
                    return SBI.getInstance();
                case 3:
                    return ICICI.getInstance();
                case 4:
                    return null;
                default:
                    System.out.println("No such bank exist.\nPlease enter correct bank name!!!.");
                    bankName = getInteger();
            }
        }
    }
}
