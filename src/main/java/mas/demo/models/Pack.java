package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mas.demo.enums.PackName;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Pack")
    private long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private PackName name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "timeInRoom")
    private Integer timeInRoom;

    @JsonIgnore
    private static Integer ownCakeCharge = 30;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pack")
    @JsonIgnore
    private List<BirthdayParty> birthdayParties;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setPack(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setPack(null);
    }

}
