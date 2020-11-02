package hatulak.spring.exercises.lesson1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
}
