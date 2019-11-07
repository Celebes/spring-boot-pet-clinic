package guru.springframework.sfgpetclinic.services.jpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Profile("jpa")
@Transactional
public class SpecialityServiceJPA extends AbstractJpaService<Speciality, SpecialityRepository> implements SpecialityService {
    public SpecialityServiceJPA(SpecialityRepository repository) {
        super(repository);
    }
}
