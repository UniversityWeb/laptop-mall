package com.webteam.laptopmall.user.service;

import com.webteam.laptopmall.user.UserDTO;
import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.user.UserNotFoundException;
import com.webteam.laptopmall.auth.PassUpdateForm;
import com.webteam.laptopmall.user.UserMapper;
import com.webteam.laptopmall.user.repos.UserRepos;
import com.webteam.laptopmall.user.repos.UserReposImpl;
import com.webteam.laptopmall.util.PassUtil;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private UserRepos userRepos;
    private UserMapper uMapper;

    public UserServiceImpl() {
        userRepos = new UserReposImpl();
        uMapper = UserMapper.INSTANCE;
    }

    @Override
    public boolean login(String username, String plainPass) {
        User User = userRepos.getUserByUsername(username);
        if (User == null) {
            return false;
        }
        return PassUtil.comparePass(User.getPassHash(), plainPass);
    }

    @Override
    public UserDTO register(UserDTO UserDTO) {
        User User = uMapper.toEntity(UserDTO);
        User savedUser = userRepos.save(User);
        return uMapper.toDTO(savedUser);
    }

    @Override
    public UserDTO deleteById(Long id) {
        if (getById(id) == null)
            throw new UserNotFoundException("Count not find any users with id=" + id);
        User deleted = userRepos.deleteById(id);
        return uMapper.toDTO(deleted);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepos.getById(id)
                .orElseThrow(() -> new UserNotFoundException("Count not find any users with id=" + id));
        return uMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepos.getAll();
        return users.stream()
                .map(uMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userRepos.getUserByUsername(username);
        return uMapper.toDTO(user);
    }

    @Override
    public List<String> getAllCustomerUsernames() {
        return userRepos.getAllCustomerUsernames();
    }

    @Override
    public int updateWithoutPassword(UserDTO userDTO) {
        User User = uMapper.toEntity(userDTO);
        return userRepos.updateWithoutPassword(User);
    }

    @Override
    public User.ERole getRoleByUsername(String username) {
        if (userRepos.getUserByUsername(username) == null) {
            throw new UserNotFoundException("Count not find any users with username=" + username);
        }
        return userRepos.getRoleByUsername(username);
    }

    @Override
    public boolean isValid(PassUpdateForm passUpdateForm) {
        return userRepos.isValid(passUpdateForm);
    }

    @Override
    public int updatePassOnly(Long userId, String newHashedPass) {
        return userRepos.updatePassOnly(userId, newHashedPass);
    }
}
