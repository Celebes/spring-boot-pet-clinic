package guru.springframework.sfgpetclinic.services;

import guru.springframework.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner> {
    Owner findByLastName(String lastName);
    Owner findByLastNameWithPets(String lastName);
}
