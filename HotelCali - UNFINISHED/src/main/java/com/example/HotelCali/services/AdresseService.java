package com.example.HotelCali.services;

import com.example.HotelCali.models.dto.AdresseDTO;
import com.example.HotelCali.models.forms.AdresseForm;

import java.util.List;

public interface AdresseService {

    void create(AdresseForm form);
    AdresseDTO getOne(Long id);
    void update(AdresseForm form, Long id);
    List<AdresseDTO>getAll();

}
