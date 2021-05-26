package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.BirthdayParty;
import mas.demo.models.BirthdayPerson;
import mas.demo.repository.BirthdayPartyRepository;
import mas.demo.repository.BirthdayPersonRepository;
import mas.demo.services.BirthdayPartyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/birthdayParties")
@AllArgsConstructor
@CrossOrigin("*")
public class BirthdayPartyController {
    private final BirthdayPartyRepository birthdayPartyRepository;
    private final BirthdayPartyService birthdayPartyService;

    @GetMapping(value = "")
    public ResponseEntity<List<BirthdayParty>> getBirthdayParties() {
        return new ResponseEntity<>((List<BirthdayParty>)birthdayPartyRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BirthdayParty> insert(@RequestBody BirthdayParty birthdayParty) {
        return new ResponseEntity<>(birthdayPartyRepository.save(birthdayParty), HttpStatus.CREATED);
    }

   /* @PostMapping(value = "/date")
    public boolean checkDate(LocalDate date){
        return birthdayPartyService.checkDate(date);
    }

    @GetMapping(value = "/byDate")
    public List<BirthdayParty> allByDate(LocalDate date){
        return new ResponseEntity<>(birthdayPartyRepository.getAllByDate(date), HttpStatus.CREATED);

    }*/
}
