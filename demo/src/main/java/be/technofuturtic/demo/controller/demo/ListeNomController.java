package be.technofuturtic.demo.controller.demo;

import be.technofuturtic.demo.models.forms.NameCreateForm;
import be.technofuturtic.demo.service.demoService.NameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class ListeNomController {

    private NameService nameService;

    public ListeNomController(NameService nameService){
        this.nameService = nameService;
    }


    @GetMapping("/listeNom")
    public String generateNames(Model model, @RequestParam(value = "qtt", required = false, defaultValue = "5")int quantity,@RequestParam(value = "length", required = false, defaultValue = "5")int lenght){

        List<String> names = nameService.generateNames(quantity,lenght);
        model.addAttribute("names", names);
        return"/listeNom";

    }

    @GetMapping("/generateurDeMots")
    public String displayGenerateNamesForm(Model model){
        model.addAttribute( "form", new NameCreateForm());
        return "createListe";
    }


}
