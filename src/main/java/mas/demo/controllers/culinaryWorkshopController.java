package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.Client;
import mas.demo.models.CulinaryWorkshop;
import mas.demo.repository.ClientRepository;
import mas.demo.repository.CulinaryWorkshopRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/culinaryWorkshops")
@AllArgsConstructor
@CrossOrigin("*")
public class culinaryWorkshopController {

    private final CulinaryWorkshopRepository culinaryWorkshopRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<CulinaryWorkshop>> getCulinaryWorkshops() {
        return new ResponseEntity<>((List<CulinaryWorkshop>)culinaryWorkshopRepository.findAll(), HttpStatus.OK);
    }
}
