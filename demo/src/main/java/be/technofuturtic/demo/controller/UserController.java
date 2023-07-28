package be.technofuturtic.demo.controller;

import be.technofuturtic.demo.models.dto.UserDTO;
import be.technofuturtic.demo.models.forms.CreateUserForm;
import be.technofuturtic.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allUser")
    public String displayAll(Model model){
        List<UserDTO> liste = userService.getAll();
        model.addAttribute("list", liste);
        return "user/display-all";
    }

    @GetMapping("/user/{id:[0-9]+}")
    public String displayOne(Model model, @PathVariable long id){
        UserDTO choosenOne = userService.getOne(id);
        model.addAttribute("user", choosenOne);
        return "user/display-one";
    }

    @GetMapping("/createUser")
    public String createUser(Model model){
        model.addAttribute("formulaire",new CreateUserForm());
        return "user/create-form";
    }

    @PostMapping("/createUser")
    public String processCreateUser(CreateUserForm form){
        userService.create(form);
        return "redirect:/allUser";
    }
}
