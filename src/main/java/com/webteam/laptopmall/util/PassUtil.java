package com.webteam.laptopmall.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PassUtil {

    private static final Logger log = LogManager.getLogger(PassUtil.class);

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
            log.error(e.getMessage());
            return plainPass;
        }
    }
}
