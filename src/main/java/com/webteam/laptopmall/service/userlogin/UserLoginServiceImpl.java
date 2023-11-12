package com.webteam.laptopmall.service.userlogin;

import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.UserLogin;
import com.webteam.laptopmall.exception.UserLoginNotFoundException;
import com.webteam.laptopmall.mapper.UserLoginMapper;
import com.webteam.laptopmall.mapper.UserMapper;
import com.webteam.laptopmall.repository.user.UserLoginRepos;
import com.webteam.laptopmall.repository.user.UserReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserLoginServiceImpl implements UserLoginService {
    private UserLoginRepos userRepos;
    private UserLoginMapper mapper;

    public UserLoginServiceImpl() {
        userRepos = new UserReposImpl();
        mapper = UserLoginMapper.INSTANCE;
    }

    @Override
    public UserLoginDTO update(UserLoginDTO userLoginDTO) {
        Long id = userLoginDTO.getUser().getId();
        if (getById(id) == null)
            throw new UserLoginNotFoundException("Count not find any users with id=" + id);
        UserLogin userLogin = mapper.toEntity(userLoginDTO);
        UserLogin updated = userRepos.update(userLogin);
        return mapper.toDTO(updated);
    }

    @Override
    public UserLoginDTO deleteById(Long id) {
        if (getById(id) == null)
            throw new UserLoginNotFoundException("Count not find any users with id=" + id);
        UserLogin deleted = userRepos.deleteById(id);
        return mapper.toDTO(deleted);
    }

    @Override
    public UserLoginDTO getById(Long id) {
        UserLogin user = userRepos.getById(id)
                .orElseThrow(() -> new UserLoginNotFoundException("Count not find any users with id=" + id));
        return mapper.toDTO(user);
    }

    @Override
    public List<UserLoginDTO> getAll() {
        List<UserLogin> users = userRepos.getAll();
        return users.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }
}
