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
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Coordinator")
    private long id;

    @Transient
    public double getAverageMark() {
       return this.birthdayParties.stream().mapToInt(BirthdayParty::getCoordinatorMark)
                .average()
                .orElse(0);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coordinator")
    private List<BirthdayParty> birthdayParties;

    @OneToOne(mappedBy = "animator", orphanRemoval = true)
    private Employee employee;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setCoordinator(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setCoordinator(null);
    }
}
