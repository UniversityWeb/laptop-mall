package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.UserLogin;
import com.webteam.laptopmall.exception.UserLoginNotFoundException;
import com.webteam.laptopmall.mapper.UserLoginMapper;
import com.webteam.laptopmall.repository.userlogin.UserLoginRepos;
import com.webteam.laptopmall.repository.userlogin.UserLoginReposImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServiceImpl implements LoginService {

    private UserLoginRepos uLoginRepos;
    private UserLoginMapper uLoginMapper;

    public LoginServiceImpl() {
        uLoginRepos = new UserLoginReposImpl();
        uLoginMapper = UserLoginMapper.INSTANCE;
    }

    @Override
    public boolean login(String username, String plainPass) {
        UserLogin userLogin = uLoginRepos.findByUsername(username);
        if (userLogin == null) {
            return false;
        }
        return comparePass(userLogin.getPassHash(), plainPass);
    }

    private boolean comparePass(String passHash, String plainPass) {
        String hashedInput = hashPass(plainPass);
        return hashedInput.equals(passHash);
    }

    public String hashPass(String plainPass) {
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
            e.printStackTrace();
            return plainPass;
        }
    }

    @Override
    public UserLoginDTO register(UserLoginDTO userLoginDTO) {
        UserLogin userLogin = uLoginMapper.toEntity(userLoginDTO);
        UserLogin savedUserLogin = uLoginRepos.save(userLogin);
        return uLoginMapper.toDTO(savedUserLogin);
    }

    @Override
    public UserLogin.ERole getRoleByUsername(String username) {
        if (uLoginRepos.findByUsername(username) == null) {
            throw new UserLoginNotFoundException("Count not find any users with username=" + username);
        }
        return uLoginRepos.getRoleByUsername(username);
    }
}