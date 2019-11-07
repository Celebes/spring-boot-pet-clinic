package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (petTypeService.findAll().size() > 0) {
            // noobowa logika zeby nie ladowac danych gdy juz jakies sa, np. z bazy danych
            return;
        }
        PetType cat = petTypeService.save(new PetType("Dog"));
        PetType dog = petTypeService.save(new PetType("Cat"));

        Speciality radiology = specialityService.save(new Speciality("Radiology"));
        Speciality surgery = specialityService.save(new Speciality("Surgery"));
        Speciality dentistry = specialityService.save(new Speciality("Dentistry"));

        Owner michael = new Owner("Michael", "Weston", "", "", "");
        Pet michaelsPet = new Pet();
        michaelsPet.setPetType(dog);
        michaelsPet.setOwner(michael);
        michaelsPet.setBirthDate(LocalDate.now());
        michaelsPet.setName("Sparky");
        michael.getPets().add(michaelsPet);
        ownerService.save(michael);

        Owner fiona = new Owner("Fiona", "Shrekowa", "", "", "");
        Pet fionasPet = new Pet();
        fionasPet.setPetType(cat);
        fionasPet.setOwner(fiona);
        fionasPet.setBirthDate(LocalDate.now());
        fionasPet.setName("Minnie");
        fiona.getPets().add(fionasPet);
        ownerService.save(fiona);

        Vet vet1 = new Vet("Sam", "Axe");
        vet1.getSpecialities().add(surgery);
        vetService.save(vet1);

        Vet vet2 = new Vet("Jesse", "James");
        vet2.getSpecialities().add(dentistry);
        vet2.getSpecialities().add(radiology);
        vetService.save(vet2);
    }
}
