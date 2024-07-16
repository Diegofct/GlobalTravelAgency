package User.infrastructure.in;

import java.util.Scanner;

import User.application.CreateUserUseCase;
import User.domain.entity.User;

public class UserController {
    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Digite el id del usuario: ");
            Long idUser = scanner.nextLong();
            scanner.nextLine();

            System.out.println("Digite el nombre de usuario: ");
            String username = scanner.nextLine();

            System.out.println("Digite el email: ");
            String email = scanner.nextLine();

            System.out.println("Digite una contraseña para el usuario: ");
            String password = scanner.nextLine();

            System.out.println("Digite el id del Rol que llevará el usuario");
            System.out.println("1.SuperAdmin");
            System.out.println("2.AdminSistema");
            System.out.println("3.Agente de ventas");
            System.out.println("4.Tecnico Mantenimiento");
            int idRole = scanner.nextInt();

            User user = new User();
            user.setIdUser(idUser);
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setIdRole(idRole);


            createUserUseCase.execute(user);
        }

        System.out.println("Usuario creado con exito!");
    }
}
