package bg.introproject.cats;

import bg.introproject.cats.model.dto.CreateOwnerDTO;
import bg.introproject.cats.service.OwnerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatDemo implements CommandLineRunner {

    private OwnerService ownerService;

    public CatDemo(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Override
    public void run(String... args) throws Exception {

        ownerService.createOwner(new CreateOwnerDTO().setOwnerName("Pesho").
                setCatNames(List.of("Chinchila", "Pesho")));

    }
}
