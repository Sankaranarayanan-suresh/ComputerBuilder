package com.computer.software.os.windows.bankapplication;

public class SBI extends BankImpl {
    final double minimumBalance = 1000;
    private static SBI databaseInstance = null;

    public static SBI getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new SBI();
        }
        return databaseInstance;
    }
    private SBI()
    {

    }

    @Override
    public double getMinimumBalance() {
        return minimumBalance;
    }
}
