package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import mas.demo.enums.BirthdayPartyState;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class BirthdayParty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_BirthdayParty")
    private long id;

    @Column(name = "date")
    private LocalDate date;


    @Min(4)
    @Max(20)
    @Column(name = "children_number")
    //@Range(min = 4, max = 20)
    private int childrenNumber;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private BirthdayPartyState state;

    @Min(1)
    @Max(5)
    @Column(name = "parentsMark")
    private Integer parentsMark;

    @Min(1)
    @Max(5)
    @Column(name = "coordinatorMark")
    private Integer coordinatorMark;

    @ManyToOne
    @JoinColumn(name = "id_Room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "id_Pack")
    private Pack pack;

    @ManyToOne
    @JoinColumn(name = "id_Client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_BirthdayPerson")
    private BirthdayPerson birthdayPerson;

    @ManyToOne
    @JoinColumn(name = "id_Coordinator")
    @JsonIgnore
    private Coordinator coordinator;

    @ManyToOne
    @JoinColumn(name = "id_CulinaryWorkshop")
    @Nullable //?????
    @JsonIgnore
    private CulinaryWorkshop culinaryWorkshop;

    @Size(max=2)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "birthdayParty")
    @JsonIgnore
    private List<PartyAnimationAnimator> partyAnimationAnimators;

    /*@Transient
    @JsonIgnore
    private Map<String, Client> clientsQualif = new TreeMap<>();*/

    public void addPartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().add(partyAnimationAnimators);
        partyAnimationAnimators.setBirthdayParty(this);
    }

    public void removePartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().remove(partyAnimationAnimators);
        partyAnimationAnimators.setBirthdayParty(null);
    }

    /*public void addClientQualif(Client newClient) {
        // sprawdzamy czy nie mamy juz takiego info
        if(!clientsQualif.containsKey(newClient.getClientNumber())) {
            clientsQualif.put(newClient.getClientNumber(), newClient);

            //polaczenie zwrotne
            newClient.addBirthdayParty(this);
        }
    }

    public Client findClientQualif(String clientNumber) {
        // Check if we have the info
        if(!clientsQualif.containsKey(clientNumber)) {
            return null;
        }
        return clientsQualif.get(clientNumber);
    }*/



}
