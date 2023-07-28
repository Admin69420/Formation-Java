package be.technofuturtic.demo.repository;

import be.technofuturtic.demo.models.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatRepository extends JpaRepository<Plat, Long> {
    boolean existsByNom(String nom);
}