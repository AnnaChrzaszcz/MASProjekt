package mas.demo.services;

import mas.demo.enums.BirthdayPartyState;
import mas.demo.models.BirthdayParty;
import mas.demo.repository.BirthdayPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class BirthdayPartyService {
    @Autowired
    private BirthdayPartyRepository birthdayPartyRepository;

    public boolean checkDate(LocalDate date) {
        return StreamSupport
                .stream(birthdayPartyRepository.findAll().spliterator(), false)
                .filter(party -> party.getDate().equals(date))
                .count() == 0;
    }

    public boolean checkChildrenNumber(long idBirthdayParty, int chNumber) {
        Optional<BirthdayParty> birthdayParty = birthdayPartyRepository.findById(idBirthdayParty);
        if(birthdayParty.isPresent()){
            int seatsRoom = birthdayParty.get().getRoom().getSeatsNumber();
            return seatsRoom >= chNumber && seatsRoom >= birthdayParty.get().getChildrenNumber();
        }
        return false; //TODO jakis exception wtedy?
    }

    public Optional<BirthdayParty> findBirthdayPartyById(long idBirthdayParty) {
        return birthdayPartyRepository.findById(idBirthdayParty);
    }

    public void cancel(long idBirthdayParty) {
        birthdayPartyRepository
                .findById(idBirthdayParty)
                .ifPresent(party -> party.setState(BirthdayPartyState.canceled));
    }

    public void plan(long idBirthdayParty) {
        birthdayPartyRepository
                .findById(idBirthdayParty)
                .ifPresent(party -> party.setState(BirthdayPartyState.planned));
    }

    public void start(long idBirthdayParty) {
        birthdayPartyRepository
                .findById(idBirthdayParty)
                .ifPresent(party -> party.setState(BirthdayPartyState.during));
    }

    public void pay(long idBirthdayParty) {
        birthdayPartyRepository
                .findById(idBirthdayParty)
                .ifPresent(party -> party.setState(BirthdayPartyState.paid));
    }

    public void end(long idBirthdayParty) {
        birthdayPartyRepository
                .findById(idBirthdayParty)
                .ifPresent(party -> party.setState(BirthdayPartyState.ended));
    }
}
