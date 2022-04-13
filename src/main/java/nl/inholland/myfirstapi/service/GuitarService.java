package nl.inholland.myfirstapi.service;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuitarService {

    private List<Guitar> guitars = new ArrayList<>();

    public GuitarService() {
        this.guitars.add(new Guitar(1, "Gibson", "Les Paul"));
        this.guitars.add(new Guitar(2, "Fender", "Vintera"));
    }

    public List<Guitar> getAll() {
        return this.guitars;
    }

    public Guitar getOne(long id) {
        return this.guitars.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    public Guitar makeOne(Guitar guitar) {
        guitar.setId(this.guitars.size() + 1);
        this.guitars.add(guitar);

        return this.getOne(guitar.getId());
    }

    public Guitar updateOne(Guitar guitar, long id) {
        guitar.setId(id);
        this.guitars.removeIf(g -> g.getId() == id);
        this.guitars.add(guitar);

        return this.getOne(guitar.getId());
    }

    public boolean deleteOne(long id) {
        try {
            this.guitars.removeIf(g -> g.getId() == id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
