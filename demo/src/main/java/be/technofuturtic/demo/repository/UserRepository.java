package be.technofuturtic.demo.repository;

import be.technofuturtic.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}