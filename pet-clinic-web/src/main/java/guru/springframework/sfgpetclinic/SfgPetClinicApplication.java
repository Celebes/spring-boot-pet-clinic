package guru.springframework.sfgpetclinic;

import guru.springframework.sfgpetclinic.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SfgPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(SfgPetClinicApplication.class, args);
        Person p = new Person();
        p.setFirstName("Kazik");
        System.out.println(p.getFirstName());
    }

}
