package com.computer.software.os.windows.bankapplication;

public class Accounts {
    String userName;
    final String passWord;
    double accountBalance;
    int bankName;
    final double minimumBal;
    public Accounts(String userName, String passWord, double amount,int bankName,double minimum) {
        this.userName = userName;
        this.passWord = passWord;
        this.accountBalance = amount;
        this.bankName = bankName;
        minimumBal = minimum;
    }
     void checkAccountBalance() {
         System.out.println(accountBalance);
     }
     void withdraw(double amount){
        IBank bank = BankApp.getBankName(bankName);
        try {
            bank.withdraw(this, amount);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
     void deposit(double amount) {
         this.accountBalance+=amount;
     }

     void transfer(double amount, Accounts a) throws Exception {
        try {
            if (!a.equals(null)) {
                if (this.userName.equals(a.userName) && (this.bankName == a.bankName)) {
                    System.out.println("Cannot transfer amount to the same account that initiated the transfer.");
                } else {
                    try {
                        withdraw(amount);
                        a.deposit(amount);
                    } catch (Exception e) {
                        throw new Exception("Amount is exceeding minimum balance. Try for lesser amounts.");
                    }
                }
            }
        }catch (NullPointerException e){
            throw new NullPointerException("No such user Exist.!!!!\nPlease try with correct uer name.");
        }


     }
//     void setInitialDeposit() {
//         System.out.println("Deposit a minimum of RS 1500 as initial deposit for your account");
//         Scanner sc = new Scanner(System.in);
//         int amt = sc.nextInt();
//         if(amt<1500) {
//             System.out.println("Incorrect amount.");
//             setInitialDeposit();
//         }
//         else {
//             deposit(amt);
//         }
//
//    }
}
