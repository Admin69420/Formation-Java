package be.technofuturtic.demo.service.impl;

import be.technofuturtic.demo.models.dto.CommandeDTO;
import be.technofuturtic.demo.models.entities.Commande;
import be.technofuturtic.demo.repository.CommandeRepository;
import be.technofuturtic.demo.service.CommandeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandeServiceImpl implements CommandeService {

    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    @Override
    public void create(Commande form) {

    }

    @Override
    public CommandeDTO getOne(Long id) {
        return commandeRepository.findById(id)
                .map(commande -> CommandeDTO.toDTO(commande))
                .orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    @Override
    public void update(Commande form, Long id) {

    }

    @Override
    public List<CommandeDTO> getAll() {
        return commandeRepository.findAll().stream()
                .map(commande -> CommandeDTO.toDTO(commande))
                .collect(Collectors.toList());
    }
}
