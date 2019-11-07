package guru.springframework.sfgpetclinic.model;

import javax.persistence.Entity;

@Entity
public class PetType extends BaseEntity {

    private String name;

    public PetType() {
    }

    public PetType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
