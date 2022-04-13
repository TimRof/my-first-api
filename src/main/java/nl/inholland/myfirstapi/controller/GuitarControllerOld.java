package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GuitarControllerOld extends Controller {

    @Autowired
    private GuitarService service;

    @RequestMapping(value = "/guitars2", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> getAll2() {
        return ResponseEntity.status(HttpStatus.OK).body(this.service.getAll());
    }

    @RequestMapping(value = "/guitars2/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> getOne(@PathVariable long id) {
        Guitar guitar = this.service.getOne(id);
        if (guitar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(guitar);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/guitars2/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    ResponseEntity<?> deleteOne2(@PathVariable long id) {
        if (this.service.deleteOne(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/guitars2/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    ResponseEntity<?> updateOne2(@RequestBody String json, @PathVariable long id) {
        Guitar guitar = this.service.updateOne(this.jsonToObject(json, Guitar.class), id);

        if (guitar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(guitar);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/guitars2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> makeOne2(@RequestBody String json) {
        return ResponseEntity.status(200).body(this.service.makeOne(this.jsonToObject(json, Guitar.class)));
    }
}
