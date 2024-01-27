package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("Mazda", 123);
      user1.setCar(car1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("Toyota", 456);
      user2.setCar(car2);


      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("Car3", 789);
      user3.setCar(car3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car4 = new Car("Car4", 90);
      user4.setCar(car4);

      User user5 = new User("User5", "Lastname5", "user5@mail.ru");

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      userService.add(user5);

      List<User> users = userService.listUsers();
      for (User user : users) {
         if (user.getCar() != null) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model = " + user.getCar().getModel());
            System.out.println("Series = " + user.getCar().getSeries());
            System.out.println();
         } else {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("The user does not own the car");
            System.out.println();
         }
      }

      System.out.println(userService.getAllUsersWithCar("Toyota", 456));

      context.close();
   }
}

//jdbc:mysql://localhost:3306/spring_hiber?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC
