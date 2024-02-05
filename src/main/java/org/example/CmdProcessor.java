package org.example;

import org.apache.commons.cli.*;

public class CmdProcessor {
    public static CommandLine parseCmd(Options options, String[] args) {
        CommandLineParser parser = new DefaultParser();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
