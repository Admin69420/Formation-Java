package be.technofuturtic.demo.service;

import be.technofuturtic.demo.models.dto.PlatDTO;
import be.technofuturtic.demo.models.entities.Plat;

import java.util.List;

public interface PlatService {
    void create(Plat form);
    PlatDTO getOne(Long id);
    void update(Plat form, Long id);
    List<PlatDTO> getAll();
}
