package com.example.HotelCali.services;

import com.example.HotelCali.models.dto.CustomerDTO;
import com.example.HotelCali.models.forms.CustomerForm;

import java.util.List;

public interface CustomerService {
    void create(CustomerForm form);
    CustomerDTO getOne(Long id);
    void update(CustomerForm form, Long id);
    List<CustomerDTO> getAll();

}
