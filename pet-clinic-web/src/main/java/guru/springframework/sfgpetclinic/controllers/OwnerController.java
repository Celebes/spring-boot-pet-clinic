package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/"})
    public String listVets(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/owners";
    }

    @RequestMapping("/find")
    public String findOwners() {
        throw new RuntimeException("Not implemented yet!");
    }
}
