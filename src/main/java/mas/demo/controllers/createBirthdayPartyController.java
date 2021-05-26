package mas.demo.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.BirthdayPerson;
import mas.demo.models.Client;
import mas.demo.models.Pack;
import mas.demo.models.Room;
import mas.demo.repository.BirthdayPersonRepository;
import mas.demo.repository.ClientRepository;
import mas.demo.repository.PackRepository;
import mas.demo.repository.RoomRepository;
import mas.demo.services.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class createBirthdayPartyController {
    private final BirthdayPartyService birthdayPartyService;
    private final BirthdayPersonService birthdayPersonService;
    private final BirthdayPersonRepository birthdayPersonRepository;
    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final PackService packService;
    private final PackRepository packRepository;
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    //private Client loggedClient = clientRepository.findById(1L).orElse(null);

    @GetMapping("/")
    public String getHome(Model model) {
        return "index.html";
    }

}
