package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.Client;
import mas.demo.models.Pack;
import mas.demo.repository.ClientRepository;
import mas.demo.repository.PackRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class clientController {
    private final ClientRepository clientRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Client>> getClients() {
        return new ResponseEntity<>((List<Client>)clientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Client> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clientRepository.findById(id).orElse(null), HttpStatus.OK);
    }
}
