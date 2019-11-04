package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vets")
public class VetController {

    private VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"", "/"})
    public String listVets(Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/vets";
    }

}
