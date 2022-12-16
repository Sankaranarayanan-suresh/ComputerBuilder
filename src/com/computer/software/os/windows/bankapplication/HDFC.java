package com.computer.software.os.windows.bankapplication;

public class HDFC extends BankImpl {
    final double minimumBalance = 1500;
    private static HDFC databaseInstance = null;
    public static HDFC getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new HDFC();
        }
        return databaseInstance;
    }


    private HDFC() {
    }

    @Override
    public double getMinimumBalance() {
        return minimumBalance;
    }
}
