package hatulak.spring.exercises.lesson1.model;

import hatulak.spring.exercises.lesson1.repository.NoSuchUserException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "group_table")
public class Group {
    @Column(name = "group_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "userGroup", fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


