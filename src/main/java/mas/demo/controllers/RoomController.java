package mas.demo.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mas.demo.models.Pack;
import mas.demo.models.Room;
import mas.demo.repository.PackRepository;
import mas.demo.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/rooms")
@AllArgsConstructor
@CrossOrigin("*")
public class RoomController {

    private final RoomRepository roomRepository;

    @GetMapping(value = "")
    public ResponseEntity<List<Room>> getRooms() {
        return new ResponseEntity<>((List<Room>)roomRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Room> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(roomRepository.findById(id).orElse(null), HttpStatus.OK);
    }
}
