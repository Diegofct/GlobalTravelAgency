package User.application;

import User.domain.entity.User;
import User.domain.service.UserService;

public class UserUseCase {
    private final UserService userService;

    public UserUseCase(UserService userService) {
        this.userService = userService;
    }

    public void createUser(User user) {
        userService.createUser(user);
    }

    public User findUser(String username, String password) {
        User user = userService.findUser(username, password);
        return user;
    }

    public void loginUser(){
        userService.loginUser();
    }
    
}