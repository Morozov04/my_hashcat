package org.example;

import org.apache.commons.cli.Options;

public class OptionsBuilder {
    public static Options buildOptions() {
        Options options = new Options();

        options.addOption("a", "algorithm", true, "Алгоритм контрольной суммы (MD5, SHA1)");
        options.addOption("h", "hash", true, "Хэш");
        options.addOption("l", "length", true, "Длина строки, которую нужно найти");
        options.addOption("t", "threads", true, "Кол. потоков");

        return options;
    }
}
