package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    Guitar getOne(@PathVariable long id) {
        return this.service.getOne(id);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteOne(@PathVariable long id) {
        if (this.service.deleteOne(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    Guitar updateOne(@RequestBody Guitar guitar, @PathVariable long id) {
        return this.service.updateOne(guitar, id);
    }

    @PostMapping()
    public @ResponseBody
    Guitar makeOne(@RequestBody Guitar guitar) {
        return this.service.makeOne(guitar);
    }
}
