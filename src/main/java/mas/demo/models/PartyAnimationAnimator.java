package mas.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Getter
@Setter
public class PartyAnimationAnimator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_PartyAnimationAnimator")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_BirthdayParty")
    @JsonManagedReference
    private BirthdayParty birthdayParty;

    @ManyToOne
    @JoinColumn(name = "id_Animation")
    @JsonManagedReference
    private Animation animation;

    @ManyToOne
    @JoinColumn(name = "id_Animator")
    @JsonManagedReference
    private Animator animator;
}
