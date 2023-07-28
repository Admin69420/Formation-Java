package be.technofuturtic.demo.service.demoService;



import be.technofuturtic.demo.models.forms.NameCreateForm;

import java.util.List;

public interface NameService{

    List<String> generateNames (int quantity, int lenght);
    void create(NameCreateForm form);

}
