package com.webteam.laptopmall.repository.user;

import com.webteam.laptopmall.entity.user.User;
import com.webteam.laptopmall.form.PassUpdateForm;
import com.webteam.laptopmall.query.UserQuery;
import com.webteam.laptopmall.repository.base.BaseReposImpl;
import com.webteam.laptopmall.utility.PassUtil;

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
    public boolean isValid(Long userId, PassUpdateForm passUpdateForm) {
        String oldPlainPass = passUpdateForm.getOldPlainPass();
        String newPlainPass = passUpdateForm.getNewPlainPass();
        String reTypePlainPass = passUpdateForm.getReTypePlainPass();
        if (!newPlainPass.equals(reTypePlainPass)) {
            return false;
        }
        Optional<User> userOpt = getById(userId);
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
