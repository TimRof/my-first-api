package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.model.dto.DTOEntity;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarCreateDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarGetDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarUpdateDTO;
import nl.inholland.myfirstapi.repository.GuitarRepository;
import nl.inholland.myfirstapi.utils.DtoUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuitarService
{

    GuitarRepository guitarRepository;

    public GuitarService(GuitarRepository guitarRepository)
    {
        this.guitarRepository = guitarRepository;
        guitarRepository.save(new Guitar("Gibson", "Les Paul"));
        guitarRepository.save(new Guitar("Fender", "Vintera"));
    }

    public List<Guitar> getAll()
    {
        return this.guitarRepository.findAll();
    }

    public Optional<Guitar> getOne(long id)
    {
        return this.guitarRepository.findById(id);
    }

    public DTOEntity createOne(GuitarCreateDTO guitarCreateDTO)
    {
        Guitar guitar = (Guitar) new DtoUtils().convertToEntity(new Guitar(), guitarCreateDTO);

        return new DtoUtils().convertToDto(this.guitarRepository.save(guitar), new GuitarGetDTO());
    }

    public DTOEntity updateOne(GuitarUpdateDTO guitarUpdateDTO, long id)
    {
        Optional<Guitar> dbGuitar = this.getOne(id);
        if (dbGuitar.isEmpty())
        {
            return null;
        }

        Guitar updateGuitar = (Guitar) new DtoUtils().convertToEntity(new Guitar(), guitarUpdateDTO);
        Guitar guitar = dbGuitar.get();
        guitar.setBrand(updateGuitar.getBrand());
        guitar.setModel(updateGuitar.getModel());

        return new DtoUtils().convertToDto(this.guitarRepository.save(guitar), new GuitarGetDTO());
    }

    public void deleteOne(long id)
    {
        this.guitarRepository.deleteById(id);
    }
}
