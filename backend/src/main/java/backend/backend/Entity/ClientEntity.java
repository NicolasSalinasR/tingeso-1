package backend.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ClientEntity {
    // This class represents the user. The user is the person who will use the application, can request credits, and has a savings account


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // id of the user.
    private Long id;
    private String rut;
    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private int salary;


    public ClientEntity(String rut, String username, String password, String email, String firstname, String lastname, int age,int salary) {
        this.rut = rut;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstname;
        this.lastName = lastname;
        this.age = age;
        this.salary = salary;
    }
}
