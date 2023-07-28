package be.technofuturtic.demo.service.impl;

import be.technofuturtic.demo.models.dto.PlatDTO;
import be.technofuturtic.demo.models.entities.Plat;
import be.technofuturtic.demo.repository.PlatRepository;
import be.technofuturtic.demo.service.PlatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatServiceImpl implements PlatService {

    private final PlatRepository platRepository;

    public PlatServiceImpl(PlatRepository platRepository) {
        this.platRepository = platRepository;
    }

    @Override
    public void create(Plat form) {

    }

    @Override
    public PlatDTO getOne(Long id) {
        return platRepository.findById(id)
                .map(plat -> PlatDTO.toDTO(plat))
                .orElseThrow(() -> new RuntimeException("Plat not found"));
    }

    @Override
    public void update(Plat form, Long id) {

    }

    @Override
    public List<PlatDTO> getAll() {
        return platRepository.findAll().stream()
                .map(plat -> PlatDTO.toDTO(plat))
                .collect(Collectors.toList());
    }
}
