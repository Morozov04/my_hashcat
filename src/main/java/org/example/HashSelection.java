package org.example;

import org.apache.commons.codec.digest.DigestUtils;

public class HashSelection {
    private final DigestUtils digestUtils;

    public HashSelection(String hashName) {
        switch (hashName) {
            case "MD5" -> digestUtils = new DigestUtils("MD5");
            case "SHA1" -> digestUtils = new DigestUtils("SHA1");
            default -> throw new IllegalArgumentException("Unsupported hash method: " + hashName);
        }
    }

    public String calculateHash(String input) {
        return digestUtils.digestAsHex(input);
    }
}

