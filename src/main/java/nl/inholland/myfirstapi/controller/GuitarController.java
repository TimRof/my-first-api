package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.exception.ResourceNotFoundException;
import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.model.dto.DTOEntity;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarCreateDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarUpdateDTO;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/guitars")
public class GuitarController extends Controller {

    private static final String RESOURCE_NOT_FOUND_1 = "Guitar with id: ";
    private static final String RESOURCE_NOT_FOUND_2 = " not found";

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
    ResponseEntity<Guitar> getOne(@PathVariable long id) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<DTOEntity> createOne(@RequestBody GuitarCreateDTO guitarCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createOne(guitarCreateDTO));
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteOne(@PathVariable long id) {
        try {
            this.service.deleteOne(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND_1 + id + RESOURCE_NOT_FOUND_2);
        }
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> updateOne(@RequestBody GuitarUpdateDTO guitarUpdateDTO, @PathVariable long id) {
        if (!this.service.updateOne(guitarUpdateDTO, id)) {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND_1 + id + RESOURCE_NOT_FOUND_2);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
