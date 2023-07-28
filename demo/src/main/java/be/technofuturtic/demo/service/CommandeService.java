package be.technofuturtic.demo.service;

import be.technofuturtic.demo.models.dto.CommandeDTO;
import be.technofuturtic.demo.models.entities.Commande;

import java.util.List;

public interface CommandeService {
    void create(Commande form);
    CommandeDTO getOne(Long id);
    void update(Commande form, Long id);
    List<CommandeDTO> getAll();
}
