package com.example.HotelCali.models.dto;

import com.example.HotelCali.models.entities.Chambre;
import com.example.HotelCali.models.entities.Customer;
import com.example.HotelCali.models.entities.Reservation;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Set<ChambreDTO> chambres;

    public static ReservationDTO toDTO(Reservation reservation) {
        if(reservation == null)
            throw new RuntimeException();

        return ReservationDTO.builder()
                .id(reservation.getId())
                .dateDebut(reservation.getDateDebut())
                .dateFin(reservation.getDateFin())
                .chambres(reservation.getChambres().stream().map(ChambreDTO::toDTO).collect(Collectors.toSet()))
                .build();

    }
}
