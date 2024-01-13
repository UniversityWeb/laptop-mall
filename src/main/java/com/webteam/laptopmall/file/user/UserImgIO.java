package com.webteam.laptopmall.file.user;

import com.webteam.laptopmall.user.UserDTO;

import javax.servlet.http.Part;

public interface UserImgIO {
    String save(String realPath, String username, Part part);
    UserDTO loadJstlImgUrl(String realPath, UserDTO userDTO);
    String loadJstlImgUrl(String realPath, String username);
}
