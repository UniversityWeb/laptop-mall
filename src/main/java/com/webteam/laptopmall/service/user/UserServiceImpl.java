package com.webteam.laptopmall.service.user;

import com.webteam.laptopmall.dto.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.exception.UserNotFoundException;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.login.LoginRepos;
import com.webteam.laptopmall.repository.login.LoginReposImpl;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private LoginRepos loginRepos;
    private UserRepos userRepos;
    private UserMapper uMapper;

    public UserServiceImpl() {
        loginRepos = new LoginReposImpl();
        userRepos = new UserReposImpl();
        uMapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        Long id = userDTO.getId();
        if (getById(id) == null)
            throw new UserNotFoundException("Count not find any users with id=" + id);
        User User = uMapper.toEntity(userDTO);
        User updated = loginRepos.update(User);
        return uMapper.toDTO(updated);
    }

    @Override
    public UserDTO deleteById(Long id) {
        if (getById(id) == null)
            throw new UserNotFoundException("Count not find any users with id=" + id);
        User deleted = loginRepos.deleteById(id);
        return uMapper.toDTO(deleted);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = loginRepos.getById(id)
                .orElseThrow(() -> new UserNotFoundException("Count not find any users with id=" + id));
        return uMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = loginRepos.getAll();
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
}
