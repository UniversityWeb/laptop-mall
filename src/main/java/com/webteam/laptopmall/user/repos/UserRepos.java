package com.webteam.laptopmall.user.repos;

import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.auth.PassUpdateForm;
import com.webteam.laptopmall.infrastructure.repository.BaseRepos;

import java.util.List;

public interface UserRepos extends BaseRepos<User, Long> {
    User getUserByUsername(String username);
    List<String> getAllCustomerUsernames();
    int updateWithoutPassword(User user);
    User.ERole getRoleByUsername(String username);
    boolean isValid(PassUpdateForm passUpdateForm);
    int updatePassOnly(Long userId, String newHashedPass);
    List<User> getUsersByRole(User.ERole role);
}
