package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mas.demo.enums.GastronomyWorkerPosition;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class GastronomyWorker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_GastronomyWorker")
    private long id;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private GastronomyWorkerPosition position;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastronomyWorker")
    private List<CulinaryWorkshop> culinaryWorkshops;

    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastronomyWorker")
    private List<WorkerTraining> workerTrainings;

    @OneToOne(mappedBy = "animator")
    private Employee employee;

    public void addCulinaryWorkshops(CulinaryWorkshop culinaryWorkshop) {
        getCulinaryWorkshops().add(culinaryWorkshop);
        culinaryWorkshop.setGastronomyWorker(this);
    }

    public void removeCulinaryWorkshops(CulinaryWorkshop culinaryWorkshop) {
        getCulinaryWorkshops().remove(culinaryWorkshop);
        culinaryWorkshop.setGastronomyWorker(null);
    }

        public void addWorkerTraining(WorkerTraining workerTraining) {
            getWorkerTrainings().add(workerTraining);
            workerTraining.setGastronomyWorker(this);
        }

        public void removeWorkerTraining(WorkerTraining workerTraining) {
            getWorkerTrainings().remove(workerTraining);
            workerTraining.setGastronomyWorker(null);
        }
}


