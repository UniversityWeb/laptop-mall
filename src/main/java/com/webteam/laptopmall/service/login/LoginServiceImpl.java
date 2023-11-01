package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServiceImpl implements LoginService {

    private UserRepos userRepos;

    public LoginServiceImpl() {
        userRepos = new UserReposImpl();
    }

    @Override
    public boolean login(String username, String plainPass) {
        User user = userRepos.findByUsername(username);
        if (user == null) {
            return false;
        }
        return comparePass(user.getPassHash(), plainPass);
    }

    private boolean comparePass(String passHash, String plainPass) {
        String hashedInput = hashPass(plainPass);
        return hashedInput.equals(passHash);
    }

    public String hashPass(String plainPass) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update (plainPass.getBytes());
            byte[] mdArray = md.digest();
            StringBuilder sb = new StringBuilder(mdArray.length * 2);
            for (byte b: mdArray) {
                int v = b & 0xff;
                if (v < 16) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(v));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return plainPass;
        }
    }
}
