package com.webteam.laptopmall.user.repos;

import com.webteam.laptopmall.user.User;
import com.webteam.laptopmall.auth.PassUpdateForm;
import com.webteam.laptopmall.user.UserQuery;
import com.webteam.laptopmall.infrastructure.repository.BaseReposImpl;
import com.webteam.laptopmall.util.PassUtil;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserReposImpl extends BaseReposImpl<User, Long> implements UserRepos {

    private static final Logger log = Logger.getLogger(UserReposImpl.class.getName());
    private UserQuery uQuery;

    public UserReposImpl() {
        uQuery = new UserQuery();
    }

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }

    @Override
    public User getUserByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetByUsername(em, username));
    }

    @Override
    public List<String> getAllCustomerUsernames() {
        return getResultList(em -> uQuery.buildGetAllCustomerUsernames(em));
    }

    @Override
    public int updateWithoutPassword(User user) {
        return executeUpdate(em -> uQuery.buildUpdateWithoutUsernameAndPassword(em, user));
    }

    @Override
    public User.ERole getRoleByUsername(String username) {
        return getSingleResult(em -> uQuery.buildGetRoleByUsername(em, username));
    }

    @Override
    public boolean isValid(PassUpdateForm passUpdateForm) {
        String oldPlainPass = passUpdateForm.getOldPlainPass();
        String newPlainPass = passUpdateForm.getNewPlainPass();
        String reTypePlainPass = passUpdateForm.getReTypePlainPass();
        if (!newPlainPass.equals(reTypePlainPass)) {
            return false;
        }
        Optional<User> userOpt = getById(passUpdateForm.getUserId());
        String oldHashedPass = "";
        if (userOpt.isPresent()) {
            oldHashedPass = userOpt.get().getPassHash();
        }
        return PassUtil.comparePass(oldHashedPass, oldPlainPass);
    }

    @Override
    public int updatePassOnly(Long userId, String newHashedPass) {
        return executeUpdate(em -> uQuery.buildUpdatePassOnly(em, userId, newHashedPass));
    }
}
