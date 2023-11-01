package com.webteam.laptopmall.service.login;

public interface LoginService {
    boolean login(String username, String plainPass);

    String hashPass(String plainPass);
}
