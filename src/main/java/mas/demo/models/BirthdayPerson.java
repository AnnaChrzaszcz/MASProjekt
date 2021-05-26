package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class BirthdayPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_BirthdayPerson")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "gender")
    private Boolean gender;

    @JsonIgnore
    private static Integer minAge;

    @Transient
    @JsonIgnore
    public int getAge() {
        return Period.between(getBirthdate(), LocalDate.now()).getYears();
    }

    //@Size(min=1)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "birthdayPerson")
    @JsonIgnore
    private List<BirthdayParty> birthdayParties;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setBirthdayPerson(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setBirthdayPerson(null);
    }

}
