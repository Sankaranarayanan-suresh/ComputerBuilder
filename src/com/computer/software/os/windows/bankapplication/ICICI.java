package com.computer.software.os.windows.bankapplication;

public class ICICI extends BankImpl {
    final double minimumBalance = 2000;
    private static ICICI databaseInstance = null;
    public static ICICI getInstance() {
        if (databaseInstance == null) {
            databaseInstance = new ICICI();
        }
        return databaseInstance;
    }
    private ICICI()
    {

    }

    @Override
    public double getMinimumBalance() {
        return minimumBalance;
    }
}
