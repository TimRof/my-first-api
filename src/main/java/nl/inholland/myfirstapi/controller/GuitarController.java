package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.exception.ResourceNotFoundException;
import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/guitars")
public class GuitarController extends Controller
{

    private final GuitarService service;

    public GuitarController(GuitarService service)
    {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody
    List<Guitar> getAll()
    {

        return this.service.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Guitar> getOne(@PathVariable long id)
    {
        Guitar guitar = this.service.getOne(id)
                .orElseThrow(() -> new ResourceNotFoundException("Guitar with id: " + id + " not found"));
        return new ResponseEntity<>(guitar, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Guitar> deleteOne(@PathVariable long id)
    {
        try
        {
            this.service.deleteOne(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Guitar> updateOne(@RequestBody Guitar guitar, @PathVariable long id)
    {
        Guitar newGuitar = this.service.updateOne(guitar, id);
        if (newGuitar == null)
        {
            throw new ResourceNotFoundException("Guitar with id: " + id + " not found");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newGuitar);
    }

    @PostMapping()
    public @ResponseBody
    Guitar makeOne(@RequestBody Guitar guitar)
    {
        return this.service.makeOne(guitar);
    }
}
