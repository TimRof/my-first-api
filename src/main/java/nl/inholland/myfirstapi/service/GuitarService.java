package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import nl.inholland.myfirstapi.repository.GuitarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuitarService {

    GuitarRepository guitarRepository;

    public GuitarService(GuitarRepository guitarRepository) {
        this.guitarRepository = guitarRepository;
        guitarRepository.save(new Guitar("Gibson", "Les Paul"));
        guitarRepository.save(new Guitar("Fender", "Vintera"));
    }

    public List<Guitar> getAll() {
        return this.guitarRepository.findAll();
    }

    public Optional<Guitar> getOne(long id) {
        return this.guitarRepository.findById(id);
    }

    public Guitar makeOne(Guitar guitar) {
        return this.guitarRepository.save(guitar);
    }

    public Guitar updateOne(Guitar guitar, long id) {
        Optional<Guitar> guitarObj = this.getOne(id);
        if (guitarObj.isPresent()) {
            Guitar _guitar = guitarObj.get();
            _guitar.setBrand(guitar.getBrand());
            _guitar.setModel(guitar.getModel());
            return this.guitarRepository.save(_guitar);
        }
        return null;
    }

    public void deleteOne(long id) {
        this.guitarRepository.deleteById(id);
    }
}
