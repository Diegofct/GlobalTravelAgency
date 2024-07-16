package User.domain.service;

import User.domain.entity.User;

public interface UserService {
    void createUser(User user);
    User findUser(String username, String password);
    void loginUser();
}
