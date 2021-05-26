package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
public class WorkerTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_WorkerTraining")
    private long id;

    @Column(name = "mark")
    private Integer mark;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_GastronomyWorker")
    @NotNull
    private GastronomyWorker gastronomyWorker;

    @ManyToOne
    @JoinColumn(name = "id_Training")
    @NotNull
    private Training training;
}
