package be.technofuturtic.demo.repository;

import be.technofuturtic.demo.models.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}