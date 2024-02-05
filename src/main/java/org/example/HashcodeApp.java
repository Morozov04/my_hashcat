package org.example;

import org.apache.commons.cli.*;

public class HashcodeApp {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static int threadCount = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) {

        Options options = OptionsBuilder.buildOptions();

        CommandLine cmd = CmdProcessor.parseCmd(options, args);

        String algorithm = cmd.getOptionValue("a");
        String password_hash = cmd.getOptionValue("h");
        int password_length = Integer.parseInt(cmd.getOptionValue("l"));
        if (cmd.hasOption("t")) {threadCount = Integer.parseInt(cmd.getOptionValue("t"));}

        long currentTimeMillis = System.currentTimeMillis();

        for (int i = 0; i < threadCount; i++) {
            Thread t = new Thread(new HashcodeThread(algorithm, currentTimeMillis, ALPHABET, password_length, password_hash, i, threadCount));
            t.start();
        }
    }
}
