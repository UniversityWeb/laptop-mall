package com.webteam.laptopmall.io.image.user;

import com.webteam.laptopmall.dto.UserDTO;

import javax.servlet.http.Part;

public interface UserImgIO {
    String save(String realPath, String username, Part part);
    UserDTO loadJstlImgUrl(String realPath, UserDTO userDTO);
    String loadJstlImgUrl(String realPath, String username);
}
