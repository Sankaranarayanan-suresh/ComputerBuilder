package com.computer.software.os.windows.bankapplication;

import java.util.ArrayList;

abstract public class BankImpl implements IBank {
    //declaring arraylist as static because only doing like that we can use the variable static method
    ArrayList<Accounts> accounts = new ArrayList<>();
    @Override
    public boolean checkUserName(String userName) {
        //for(int i=0;i<accounts.size();i++){
        for (Accounts account:accounts) {
            if(account.userName.equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public void addAccount(Accounts a) {
        accounts.add(a);
    }
    @Override
    public boolean checkCredentials(String userName, String password) {
        Accounts accounts1;
        try {
            accounts1 = findAccount(userName);
            if(accounts1.passWord.equals(password)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            throw new NullPointerException("No such user exist");
        }

    }
    public void withdraw(Accounts accounts,double amount) throws Exception{
         if(accounts.accountBalance > amount){
                     if ((accounts.accountBalance-amount)<accounts.minimumBal) {
                         throw new Exception("Amount is exceeding minimum balance. Try for lesser amounts.");
                     }
                     else {
                         accounts.accountBalance-=amount;
                         System.out.printf("A total of RS %.2f is debited from your account\n", amount);
                     }
                 }
         else {
             throw new Exception("Insufficient balance");
         }
    }
    @Override
    public Accounts findAccount(String userName) {
       // for(int i=0;i<accounts.size();i++){
        for (Accounts account:accounts){
            if(account.userName.equals(userName)) {
                return account;
            }
        }
        return null;
    }
}
