package mas.demo.models;

import com.sun.istack.NotNull;
import lombok.*;
import mas.demo.enums.AnimationType;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Animation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Animation")
    private long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AnimationType type;


    @Column(name = "price")
    private int price;

    @Column(name = "description")
    private String description;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animation")
    private List<PartyAnimationAnimator> partyAnimationAnimators;


    public void addPartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().add(partyAnimationAnimators);
        partyAnimationAnimators.setAnimation(this);
    }

    public void removePartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().remove(partyAnimationAnimators);
        partyAnimationAnimators.setAnimation(null);
    }





}
