package com.computer.software.application;

import com.computer.software.os.ApplicationInterface;

public class GSearch implements Application {
    private final String applicationName = "GSearch";
    private final String version = "1.0";
    private final ApplicationInterface sys;

    @Override
    public String getName() {
        return applicationName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    public GSearch(ApplicationInterface sys) {
        this.sys = sys;
    }

    @Override
    public void run() {
        sys.puts("WELCOME TO GSearch");
        while (true) {
            sys.puts("Search:");
            String word = sys.gets();
            if (word.equals("0")) {
                break;
            }
            if (sys.checkNetworkStatus()) {
                switch (word) {
                    case "class":
                        sys.puts("Low level");
                        break;
                    case "objects":
                        sys.puts("Medium level");
                        break;
                    case "oops":
                        sys.puts("High level");
                        break;
                    default:
                        sys.puts("No Search Results found!!!!\nPress 0 to exit.");
                }
            } else {
                sys.puts("No Network Connection.");
                break;
            }
        }
    }
}
