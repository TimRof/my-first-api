package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/guitars")
public class GuitarController extends Controller {

    private final GuitarService service;

    public GuitarController(GuitarService service) {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody
    List<Guitar> getAll() {
        return this.service.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<?> getOne(@PathVariable long id) {
        Optional<Guitar> guitar = this.service.getOne(id);
        if (guitar.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(guitar);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteOne(@PathVariable long id) {
        try {
            this.service.deleteOne(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<?> updateOne(@RequestBody Guitar guitar, @PathVariable long id) {
        Guitar _guitar = this.service.updateOne(guitar, id);
        if (_guitar != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(_guitar);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public @ResponseBody
    Guitar makeOne(@RequestBody Guitar guitar) {
        return this.service.makeOne(guitar);
    }
}
