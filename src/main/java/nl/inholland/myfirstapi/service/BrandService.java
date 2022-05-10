package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.exception.ResourceNotFoundException;
import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.dto.DTOEntity;
import nl.inholland.myfirstapi.model.dto.brand.BrandCreateDTO;
import nl.inholland.myfirstapi.model.dto.brand.BrandGetDTO;
import nl.inholland.myfirstapi.repository.BrandRepository;
import nl.inholland.myfirstapi.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {
    BrandRepository repository;

    public BrandService(BrandRepository repository) {
        this.repository = repository;
    }

    public List<Brand> getAll() {
        return this.repository.findAll();
    }

    public Brand getOne(long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Brand with id: " + id + " not found"));
    }

    public DTOEntity createOne(BrandCreateDTO brandCreateDTO) {
        Brand brand = (Brand) new DtoUtils().convertToEntity(new Brand(), brandCreateDTO);

        return new DtoUtils().convertToDto(this.repository.save(brand), new BrandGetDTO());
    }
}
