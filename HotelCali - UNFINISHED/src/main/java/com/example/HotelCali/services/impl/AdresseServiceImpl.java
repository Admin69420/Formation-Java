package com.example.HotelCali.services.impl;

import com.example.HotelCali.models.dto.AdresseDTO;
import com.example.HotelCali.models.entities.Adresse;
import com.example.HotelCali.models.forms.AdresseForm;
import com.example.HotelCali.repository.AdresseRepository;
import com.example.HotelCali.services.AdresseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdresseServiceImpl implements AdresseService {
    private AdresseRepository adresseRepository;
    public AdresseServiceImpl(AdresseRepository adresseRepository){this.adresseRepository = adresseRepository;}

    @Override
    public void create(AdresseForm form) {
        Adresse adresse = new Adresse();

        adresse.setRue(form.getRue());
        adresse.setNumero(form.getNumero());
        adresse.setCodePostal(form.getCodePostal());
        adresse.setVille(form.getVille());
        adresse.setPays(form.getPays());

        adresseRepository.save(adresse);
    }

    @Override
    public AdresseDTO getOne(Long id) {
        return adresseRepository.findById(id)
                .map(entite -> AdresseDTO.toDTO(entite))
                .orElseThrow(()->new RuntimeException("Adresse pas trouvée."));
    }

    @Override
    public void update(AdresseForm form, Long id) {
        Adresse adresseToUpdate = adresseRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Adresse pas trouvée."));
        adresseToUpdate.setRue(form.getRue());
        adresseToUpdate.setNumero(form.getNumero());
        adresseToUpdate.setVille(form.getVille());
        adresseToUpdate.setCodePostal(form.getCodePostal());
        adresseToUpdate.setPays(form.getPays());

        adresseRepository.save(adresseToUpdate);
    }

    @Override
    public List<AdresseDTO> getAll() {
        return adresseRepository.findAll().stream()
                .map(u->AdresseDTO.toDTO(u))
                .collect(Collectors.toList());
    }
}
