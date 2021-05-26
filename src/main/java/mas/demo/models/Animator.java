package mas.demo.models;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class Animator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Animator")
    private long id;

    @Transient
    public int getNumberOfAnimations() {
        return this.partyAnimationAnimators.size();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "animator")
    @Size(min=0, max=3)
    private List<PartyAnimationAnimator> partyAnimationAnimators;

    @OneToOne(mappedBy = "animator", orphanRemoval = true)
    private Employee employee;

    public void addPartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().add(partyAnimationAnimators);
        partyAnimationAnimators.setAnimator(this);
    }

    public void removePartyAnimationAnimators(PartyAnimationAnimator partyAnimationAnimators) {
        getPartyAnimationAnimators().remove(partyAnimationAnimators);
        partyAnimationAnimators.setAnimator(null);
    }


}
