package com.webteam.laptopmall.service.user;

import com.webteam.laptopmall.dto.user.UserDTO;
import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.exception.UserNotFoundException;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.user.UserRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private UserRepos userRepos;
    private UserMapper mapper;

    public UserServiceImpl() {
        userRepos = new UserReposImpl();
        mapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = mapper.toEntity(userDTO);
        User saved = userRepos.save(user);
        return mapper.toDTO(saved);
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (getById(userDTO.getId()) == null)
            throw new UserNotFoundException("Count not find any users with id=" + userDTO.getId());
        User user = mapper.toEntity(userDTO);
        User updated = userRepos.update(user);
        return mapper.toDTO(updated);
    }

    @Override
    public UserDTO deleteById(Long id) {
        if (getById(id) == null)
            throw new UserNotFoundException("Count not find any users with id=" + id);
        User deleted = userRepos.deleteById(id);
        return mapper.toDTO(deleted);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepos.getById(id)
                .orElseThrow(() -> new UserNotFoundException("Count not find any users with id=" + id));
        return mapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepos.getAll();
        return users.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
