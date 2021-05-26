package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mas.demo.enums.RoomName;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Room")
    private long id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private RoomName name;

    @Column(name = "description")
    private String description;

    @Column(name = "seatsNumber")
    private Integer seatsNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    @JsonIgnore
    private List<BirthdayParty> birthdayParties;

    public void addBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().add(birthdayParty);
        birthdayParty.setRoom(this);
    }

    public void removeBirthdayParty(BirthdayParty birthdayParty) {
        getBirthdayParties().remove(birthdayParty);
        birthdayParty.setRoom(null);
    }



}
