package nl.inholland.myfirstapi.controller;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.dto.DTOEntity;
import nl.inholland.myfirstapi.model.dto.brand.BrandCreateDTO;
import nl.inholland.myfirstapi.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/brands")
public class BrandController {

    private final BrandService service;

    public BrandController(BrandService service) {
        this.service = service;
    }

    @GetMapping
    public @ResponseBody
    List<Brand> getAll() {
        return this.service.getAll();
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    ResponseEntity<Brand> getOne(@PathVariable long id) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping()
    public @ResponseBody
    ResponseEntity<DTOEntity> createOne(@RequestBody BrandCreateDTO brandCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.createOne(brandCreateDTO));
    }
}
