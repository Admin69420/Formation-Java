package be.technofuturtic.demo.service.impl;

import be.technofuturtic.demo.models.dto.UserDTO;
import be.technofuturtic.demo.models.entities.User;
import be.technofuturtic.demo.models.forms.CreateUserForm;
import be.technofuturtic.demo.repository.UserRepository;
import be.technofuturtic.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(CreateUserForm form) {
        User entity = new User(form.getNom(), form.getPrenom(), form.getDateDeNaissance());
        userRepository.save(entity);
    }

    @Override
    public UserDTO getOne(Long id) {
        return userRepository.findById(id)
                .map(entite -> UserDTO.toDTO(entite))
                .orElseThrow(() -> new RuntimeException("User not found"));
                //.get();
    }

    @Override
    public void update(User form, Long id) {

    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream()
                .map(u->UserDTO.toDTO(u))
                .collect(Collectors.toList());
    }
}
