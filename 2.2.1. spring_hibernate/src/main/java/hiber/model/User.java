package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_car")
   private Car car;

   public User() {}
   
   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              ", car=" + car +
              '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof User)) return false;

      final User user = (User) o;

      if(!user.getId().equals(getId())) return false;
      if(!user.getFirstName().equals(getFirstName())) return false;
      if(!user.getLastName().equals(getLastName())) return false;
      if(!user.getEmail().equals(getEmail())) return false;
      if(!user.getCar().equals(getCar())) return false;
      return true;
   }

   @Override
   public int hashCode() {
      int result;
      result = getId().hashCode();
      result = 29 * result + getFirstName().hashCode();
      result = result + getLastName().hashCode();
      result = result + getEmail().hashCode();
      result = result + getCar().hashCode();
      return result;
   }
}
