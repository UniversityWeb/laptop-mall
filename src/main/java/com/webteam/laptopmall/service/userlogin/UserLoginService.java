package com.webteam.laptopmall.service.userlogin;

import com.webteam.laptopmall.dto.user.UserLoginDTO;

import java.util.List;

public interface UserLoginService {
    UserLoginDTO update(UserLoginDTO userLoginDTO);
    UserLoginDTO deleteById(Long id);
    UserLoginDTO getById(Long id);
    List<UserLoginDTO> getAll();
}
