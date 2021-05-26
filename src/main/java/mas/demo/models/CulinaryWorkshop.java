package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import mas.demo.enums.CulinaryWorkshopType;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class CulinaryWorkshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_CulinaryWorkshop")
    private long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CulinaryWorkshopType type;

    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_GastronomyWorker")
    @JsonManagedReference
    private GastronomyWorker gastronomyWorker;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "culinaryWorkshop")
    private List<BirthdayParty> birthdayParties;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setCulinaryWorkshop(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setCulinaryWorkshop(null);
    }

}
