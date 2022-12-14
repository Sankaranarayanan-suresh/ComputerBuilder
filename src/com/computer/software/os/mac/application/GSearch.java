package com.computer.software.os.mac.application;

import com.computer.software.os.ApplicationInterface;
import com.computer.software.os.mac.Mac;
import com.computer.software.os.os.OsApplicationInteractionInterface;

public class GSearch implements Mac.MacApps {
    private final String applicationName = "GSearch";
    private final String version = "1.0";

    @Override
    public String getName() {
        return applicationName;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public void run(OsApplicationInteractionInterface sys) {
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
