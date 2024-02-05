package org.example;

import org.apache.commons.cli.*;

public class HashcatApp {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static final int THREADS = 4;
    public static void main(String[] args) {

        Options options = new Options();

        options.addOption("a", "algorithm", true, "Algorithm for checksum (MD5, SHA1)");
        options.addOption("h", "hash", true, "Hex value of the checksum");
        options.addOption("l", "length", true, "Length of the string to find");

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            String algorithm = cmd.getOptionValue("a");
            String hash = cmd.getOptionValue("h");
            int length = Integer.parseInt(cmd.getOptionValue("l"));

            System.out.println(algorithm + " " + hash + " " + length);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
