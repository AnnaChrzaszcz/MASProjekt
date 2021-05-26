package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mas.demo.enums.EmployeeState;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Employee")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "contractNumber")
    private String contractNumber;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private EmployeeState state;

    @Column(name = "availability")
    private int availability;

    @Column(name = "salary")
    @JsonIgnore
    private static int salary = 17;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
    private List<Comment> comments;

    @Column(name = "isActive")
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "idAnimator")
    private Animator animator;

    @OneToOne
    @JoinColumn(name = "idCoordinator")
    private Coordinator coordinator;

    @OneToOne
    @JoinColumn(name = "idGastronomyWorker")
    private GastronomyWorker gastronomyWorker;

    public void addComment(Comment comment) {
        getComments().add(comment);
        comment.setEmployee(this);
    }

    public void removeComment(Comment comment) {
        getComments().remove(comment);
        comment.setEmployee(null);
    }
}
