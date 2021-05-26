package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.BirthdayPerson;
import mas.demo.repository.BirthdayPersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/birthdayPersons")
@AllArgsConstructor
@CrossOrigin("*")
public class BirthdayPersonController {

    private final BirthdayPersonRepository birthdayPersonRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<BirthdayPerson>> getBirthdayPersons() {
        return new ResponseEntity<>((List<BirthdayPerson>)birthdayPersonRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<BirthdayPerson> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(birthdayPersonRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<BirthdayPerson> insert(@RequestBody BirthdayPerson birthdayPerson) {
        return new ResponseEntity<>(birthdayPersonRepository.save(birthdayPerson), HttpStatus.CREATED);
    }
}
