package nl.inholland.myfirstapi.configuration;

import nl.inholland.myfirstapi.model.Brand;
import nl.inholland.myfirstapi.model.dto.brand.BrandCreateDTO;
import nl.inholland.myfirstapi.model.dto.guitar.GuitarCreateDTO;
import nl.inholland.myfirstapi.service.BrandService;
import nl.inholland.myfirstapi.service.GuitarService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final GuitarService guitarService;
    private final BrandService brandService;

    public MyApplicationRunner(GuitarService guitarService, BrandService brandService) {
        this.guitarService = guitarService;
        this.brandService = brandService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // add brands
        brandService.createOne(new BrandCreateDTO("Gibson"));
        brandService.createOne(new BrandCreateDTO("Fender"));
        brandService.createOne(new BrandCreateDTO("Jackson"));

        Brand testBrand1 = this.brandService.getOne(1);
        Brand testBrand2 = this.brandService.getOne(2);
        Brand testBrand3 = this.brandService.getOne(3);

        // add guitars
        guitarService.createOne(new GuitarCreateDTO("Les Paul", testBrand1));
        guitarService.createOne(new GuitarCreateDTO("Sunburst", testBrand2));
        guitarService.createOne(new GuitarCreateDTO("Dinky", testBrand3));
        guitarService.createOne(new GuitarCreateDTO("Stratocaster", testBrand2));
    }
}
