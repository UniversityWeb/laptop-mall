package com.webteam.laptopmall.io.image.user;

import javax.servlet.http.Part;

public interface UserImgIO {
    String save(String realPath, String username, Part part);

    String loadJstlImgUrl(String realPath, String username);
}
