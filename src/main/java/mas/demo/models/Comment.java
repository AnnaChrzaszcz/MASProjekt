package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Comment")
    private long id;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_Employee")
    @JsonManagedReference
    private Employee employee;
}
