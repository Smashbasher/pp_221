package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Stephen", "Curry", "stephencurry@gmail.com"));
        userService.add(new User("Lebron", "James", "lebronjames@gmail.com"));
        userService.add(new User("Shaq", "O'Neil", "theshaq@gmail.com"));
        userService.add(new User("Jason", "Williams", "jasonwilliams@gmail.com"));

        List<User> users = userService.getListUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.getCar() != null) {
                System.out.println("Car = " + user.getCar() + " " + user.getCar());
            }
            System.out.println();
        }
        System.out.println(userService.getUserByCar("Lamborghini", 103));

        context.close();
    }
}
