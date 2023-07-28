package be.technofuturtic.demo.models.dto;

import be.technofuturtic.demo.models.entities.Commande;
import be.technofuturtic.demo.models.entities.Plat;
import be.technofuturtic.demo.models.entities.User;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class CommandeDTO {
    private Long id;
    private List<PlatDTO> plats;
    private UserDTO user;

    public static CommandeDTO toDTO(Commande entity){
        if(entity == null)
            throw new RuntimeException();

        return CommandeDTO.builder()
                .id(entity.getId())
                .plats(entity.getPlats().stream()
                        .map(plat -> PlatDTO.toDTO(plat))
                        .toList())
                .user(UserDTO.toDTO(entity.getUser()))
                .build();

    }
}
