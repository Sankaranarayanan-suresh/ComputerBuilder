package com.computer.software.os.windows.bankapplication;

import com.computer.software.os.windows.Windows.WindowsApps;

public interface IBank {
    void withdraw(Accounts account, double amount) throws Exception;
    double getMinimumBalance();
    boolean checkUserName(String userName);
    void addAccount(Accounts a);
    boolean checkCredentials(String userName,String password);
    Accounts findAccount(String userName);
}
