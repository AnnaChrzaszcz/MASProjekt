package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.BirthdayPerson;
import mas.demo.models.Pack;
import mas.demo.repository.BirthdayPersonRepository;
import mas.demo.repository.PackRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/packs")
@AllArgsConstructor
@CrossOrigin("*")
public class PackController {

    private final PackRepository packRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Pack>> getPacks() {
        return new ResponseEntity<>((List<Pack>)packRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pack> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(packRepository.findById(id).orElse(null), HttpStatus.OK);
    }
}
