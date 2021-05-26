package mas.demo.services;


import mas.demo.models.BirthdayParty;
import mas.demo.models.BirthdayPerson;
import mas.demo.repository.BirthdayPartyRepository;
import mas.demo.repository.BirthdayPersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BirthdayPersonService {
    private BirthdayPersonRepository birthdayPersonRepository;

    public Optional<BirthdayPerson> findBirthdayPersonById(long idBirthdayPerson) {
        return birthdayPersonRepository.findById(idBirthdayPerson);
    }
}
