package com.tavelagency;

import User.application.CreateUserUseCase;
import User.domain.service.UserService;
import User.infrastructure.in.UserController;
import User.infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {
        
        UserService userService = new UserRepository();
        CreateUserUseCase createUserUseCase = new CreateUserUseCase(userService);
        UserController consoleAdapter = new UserController(createUserUseCase);

        consoleAdapter.start();
    }
}