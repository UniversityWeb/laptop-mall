package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.exception.UserNotFoundException;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.login.LoginRepos;
import com.webteam.laptopmall.repository.login.LoginReposImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServiceImpl implements LoginService {

    private LoginRepos uLoginRepos;
    private UserMapper uLoginMapper;

    public LoginServiceImpl() {
        uLoginRepos = new LoginReposImpl();
        uLoginMapper = UserMapper.INSTANCE;
    }

    @Override
    public boolean login(String username, String plainPass) {
        User User = uLoginRepos.findByUsername(username);
        if (User == null) {
            return false;
        }
        return comparePass(User.getPassHash(), plainPass);
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
    public UserDTO register(UserDTO UserDTO) {
        User User = uLoginMapper.toEntity(UserDTO);
        User savedUser = uLoginRepos.save(User);
        return uLoginMapper.toDTO(savedUser);
    }

    @Override
    public User.ERole getRoleByUsername(String username) {
        if (uLoginRepos.findByUsername(username) == null) {
            throw new UserNotFoundException("Count not find any users with username=" + username);
        }
        return uLoginRepos.getRoleByUsername(username);
    }
}