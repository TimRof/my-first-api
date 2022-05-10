package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.exception.ResourceNotFoundException;
import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.model.dto.DTOEntity;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarCreateDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarGetDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarUpdateDTO;
import nl.inholland.myfirstapi.repository.GuitarRepository;
import nl.inholland.myfirstapi.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarService {

    GuitarRepository repository;

    final BrandService brandService;

    public GuitarService(GuitarRepository guitarRepository, BrandService brandService) {
        this.repository = guitarRepository;
        this.brandService = brandService;
    }

    public List<Guitar> getAll() {
        return this.repository.findAll();
    }

    public Guitar getOne(long id) {
        return this.repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Guitar with id: " + id + " not found"));
    }

    public DTOEntity createOne(GuitarCreateDTO guitarCreateDTO) {
        Guitar guitar = (Guitar) new DtoUtils().convertToEntity(new Guitar(), guitarCreateDTO);

        return new DtoUtils().convertToDto(this.repository.save(guitar), new GuitarGetDTO());
    }

    public boolean updateOne(GuitarUpdateDTO guitarUpdateDTO, long id) {
        Guitar guitar = this.getOne(id);

        guitar.setBrand(brandService.getOne(guitarUpdateDTO.getBrand().getId()));
        guitar.setModel(guitarUpdateDTO.getModel());

        this.repository.save(guitar);

        return true;
    }

    public void deleteOne(long id) {
        this.repository.deleteById(id);
    }
}
