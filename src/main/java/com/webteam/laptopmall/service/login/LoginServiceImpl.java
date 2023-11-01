package com.webteam.laptopmall.service.login;

import com.webteam.laptopmall.customenum.EUserRole;
import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.User;
import com.webteam.laptopmall.exception.UserNotFoundException;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginServiceImpl implements LoginService {

    private UserRepos userRepos;
    private UserMapper mapper;

    public LoginServiceImpl() {
        userRepos = new UserReposImpl();
        mapper = UserMapper.INSTANCE;
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
    public UserDTO register(UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User saved = userRepos.save(user);
        return mapper.toDTO(saved);
    }

    @Override
    public EUserRole getRoleByUsername(String username) {
        if (userRepos.findByUsername(username) == null) {
            throw new UserNotFoundException("Count not find any users with username=" + username);
        }
        return userRepos.getRoleByUsername(username);
    }
}