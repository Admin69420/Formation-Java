package com.example.HotelCali.controller;

import com.example.HotelCali.services.AdresseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/address")
public class AdresseController {
 private final AdresseService adresseService;

 public AdresseController(AdresseService adresseService) {this.adresseService = adresseService;}
    @GetMapping("/adresse")
    public String displayAll(Model model){

    }
}
