package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GuitarController extends Controller {

    private final GuitarService service;

    public GuitarController(GuitarService service) {
        this.service = service;
    }

    @GetMapping(value = "/api/guitars")
    public @ResponseBody
    List<Guitar> getAll() {
        return this.service.getAll();
    }

    @GetMapping(value = "/api/guitars/{id}")
    public @ResponseBody
    Guitar getOne(@PathVariable long id) {
        return this.service.getOne(id);
    }

    @DeleteMapping(value = "/api/guitars/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteOne(@PathVariable long id) {
        if (this.service.deleteOne(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/api/guitars/{id}")
    public @ResponseBody
    Guitar updateOne(@RequestBody String json, @PathVariable long id) {
        return this.service.updateOne(this.jsonToObject(json, Guitar.class), id);
    }

    @PostMapping(value = "/api/guitars")
    public @ResponseBody
    Guitar makeOne(@RequestBody String json) {
        return this.service.makeOne(this.jsonToObject(json, Guitar.class));
    }
}
