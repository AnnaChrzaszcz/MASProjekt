package mas.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Training")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "training")
    private List<WorkerTraining> workerTrainings;

    public void addWorkerTraining(WorkerTraining workerTraining) {
        getWorkerTrainings().add(workerTraining);
        workerTraining.setTraining(this);
    }

    public void removeWorkerTraining(WorkerTraining workerTraining) {
        getWorkerTrainings().remove(workerTraining);
        workerTraining.setTraining(null);
    }

}
