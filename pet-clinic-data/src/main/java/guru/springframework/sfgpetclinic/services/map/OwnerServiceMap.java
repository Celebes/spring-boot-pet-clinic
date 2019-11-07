package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {
        object.getPets().forEach(pet -> {
            if (pet.getId() == null) {
                petService.save(pet);
            }
            if (pet.getPetType().getId() == null) {
                petTypeService.save(pet.getPetType());
            }
        });
        return super.save(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return map.values().stream()
                .filter(owner -> owner.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Owner findByLastNameWithPets(String lastName) {
        return findByLastName(lastName);
    }
}
