package com.webteam.laptopmall.service.userlogin;

import com.webteam.laptopmall.dto.user.UserLoginDTO;
import com.webteam.laptopmall.entity.user.UserLogin;
import com.webteam.laptopmall.exception.UserLoginNotFoundException;
import com.webteam.laptopmall.mapper.UserLoginMapper;
import com.webteam.laptopmall.repository.userlogin.UserLoginRepos;
import com.webteam.laptopmall.repository.userlogin.UserLoginReposImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserLoginServiceImpl implements UserLoginService {
    private UserLoginRepos uLoginRepos;
    private UserLoginMapper uLoginMapper;

    public UserLoginServiceImpl() {
        uLoginRepos = new UserLoginReposImpl();
        uLoginMapper = UserLoginMapper.INSTANCE;
    }

    @Override
    public UserLoginDTO update(UserLoginDTO userLoginDTO) {
        Long id = userLoginDTO.getUser().getId();
        if (getById(id) == null)
            throw new UserLoginNotFoundException("Count not find any users with id=" + id);
        UserLogin userLogin = uLoginMapper.toEntity(userLoginDTO);
        UserLogin updated = uLoginRepos.update(userLogin);
        return uLoginMapper.toDTO(updated);
    }

    @Override
    public UserLoginDTO deleteById(Long id) {
        if (getById(id) == null)
            throw new UserLoginNotFoundException("Count not find any users with id=" + id);
        UserLogin deleted = uLoginRepos.deleteById(id);
        return uLoginMapper.toDTO(deleted);
    }

    @Override
    public UserLoginDTO getById(Long id) {
        UserLogin user = uLoginRepos.getById(id)
                .orElseThrow(() -> new UserLoginNotFoundException("Count not find any users with id=" + id));
        return uLoginMapper.toDTO(user);
    }

    @Override
    public List<UserLoginDTO> getAll() {
        List<UserLogin> users = uLoginRepos.getAll();
        return users.stream()
                .map(uLoginMapper::toDTO)
                .collect(Collectors.toList());
    }
}
