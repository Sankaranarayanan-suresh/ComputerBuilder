package com.computer.software.application;

import com.computer.software.os.ApplicationInterface;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator implements Application {
    private final String applicationName = "Calculator";
    private final String version = "1.0";
    private final ApplicationInterface sys;

    public Calculator(ApplicationInterface sys) {
        this.sys = sys;
    }

    @Override
    public String getName() {
        return applicationName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    private Object calculate(String input) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
        return engine.eval(input);
    }

    @Override
    public void run() {
        while (true) {
            sys.puts("Enter an equation or press 0 to exit the application");
            String equ = sys.gets();
            if (equ.equals("0")) {
                break;
            }
            try {
                Object res = calculate(equ);
                sys.puts(res);
            } catch (ScriptException e) {
                sys.puts("Enter a valid equation.");
            }
        }
    }
}
