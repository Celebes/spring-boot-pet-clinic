package guru.springframework.sfgpetclinic.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
class CrashController {

    @GetMapping("/oups")
    public String triggerException() {
        log.error("Error, but it's ok since it was done on purpose lololol");
        throw new RuntimeException("Expected: controller used to showcase what happens when an exception is thrown");
    }

}
