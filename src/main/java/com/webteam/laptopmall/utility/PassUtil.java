package com.webteam.laptopmall.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

public class PassUtil {
    private static final Logger log = Logger.getLogger(PassUtil.class.getName());

    public static boolean comparePass(String passHash, String plainPass) {
        String hashedInput = hashPass(plainPass);
        return hashedInput.equals(passHash);
    }

    public static String hashPass(String plainPass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(plainPass.getBytes());
            byte[] mdArray = md.digest();
            StringBuilder sb = new StringBuilder(mdArray.length * 2);
            for (byte b : mdArray) {
                int v = b & 0xff;
                if (v < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(v));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.severe(e.getMessage());
            return plainPass;
        }
    }
}
