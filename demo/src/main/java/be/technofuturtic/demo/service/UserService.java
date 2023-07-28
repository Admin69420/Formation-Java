package be.technofuturtic.demo.service;

import be.technofuturtic.demo.models.dto.UserDTO;
import be.technofuturtic.demo.models.entities.User;
import be.technofuturtic.demo.models.forms.CreateUserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void create(CreateUserForm form);
    UserDTO getOne(Long id);
    void update(User form,Long id);
    List<UserDTO>getAll();


}
