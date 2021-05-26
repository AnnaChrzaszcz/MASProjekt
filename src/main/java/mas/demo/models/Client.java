package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Client")
    private long id;

    @Column(name = "clientNumber")
    private String clientNumber;

    @Column(name = "isVip")
    private Boolean isVip;

    @Column(name = "discount")
    private Double discount;

    @Transient
    public int howManyBirthdays() {
        return this.birthdayParties.size();
    }

    @Size(min=1)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    @JsonIgnore
    private List<BirthdayParty> birthdayParties;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setClient(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setClient(null);
    }

}
