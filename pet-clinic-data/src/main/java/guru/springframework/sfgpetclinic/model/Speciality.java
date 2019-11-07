package guru.springframework.sfgpetclinic.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Speciality extends BaseEntity {

    private String description;

    public Speciality(String description) {
        this.description = description;
    }

}
