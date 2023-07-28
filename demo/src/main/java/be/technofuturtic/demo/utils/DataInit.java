package be.technofuturtic.demo.utils;

import be.technofuturtic.demo.models.entities.Commande;
import be.technofuturtic.demo.models.entities.Ingredient;
import be.technofuturtic.demo.models.entities.Plat;
import be.technofuturtic.demo.models.entities.User;
import be.technofuturtic.demo.repository.CommandeRepository;
import be.technofuturtic.demo.repository.IngredientRepository;
import be.technofuturtic.demo.repository.PlatRepository;
import be.technofuturtic.demo.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DataInit implements InitializingBean {

    private final UserRepository userRepository;
    private final CommandeRepository commandeRepository;
    private final PlatRepository platRepository;
    private final IngredientRepository ingredientRepository;


    public DataInit(UserRepository userRepository, CommandeRepository commandeRepository, PlatRepository platRepository, IngredientRepository ingredientRepository) {
        this.userRepository = userRepository;
        this.commandeRepository = commandeRepository;
        this.platRepository = platRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {


        //User
        User user = new User("Lorthioir","Yann", LocalDate.of(1991,03,13));
        userRepository.save(user);

        User user1 = new User("Dupont","Julien", LocalDate.of(1992,10,13));
        userRepository.save(user1);

        User user2 = new User("Valjean","Jean",LocalDate.of(1819,01,01));
        userRepository.save(user2);

        //Ingredient
        Ingredient ingredient = new Ingredient();
        ingredient.setNom("Frites");
        ingredientRepository.save(ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setNom("Poulet");
        ingredientRepository.save(ingredient1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setNom("Fricadelle");
        ingredientRepository.save(ingredient2);

        Ingredient ingredient3 = new Ingredient();
        ingredient3.setNom("Spaghetti");
        ingredientRepository.save(ingredient3);

        Ingredient ingredient4 = new Ingredient();
        ingredient4.setNom("Bolognaise");
        ingredientRepository.save(ingredient4);

        //Plat
        Plat plat = new Plat();
        plat.setNom("Poulet frites");

        Set<Ingredient> listeIngredients = new HashSet<>();
        listeIngredients.add(ingredient);
        listeIngredients.add(ingredient1);
        plat.setIngredients(listeIngredients);

        platRepository.save(plat);

        Plat plat2 = new Plat();
        plat2.setNom("Frites fricadelle");

        Set<Ingredient> listeIngredients2 = new HashSet<>();
        listeIngredients2.add(ingredient);
        listeIngredients2.add(ingredient2);
        plat2.setIngredients(listeIngredients2);

        platRepository.save(plat2);

        Plat plat3 = new Plat();
        plat3.setNom("Spaghettis bolognaise");

        Set<Ingredient> listeIngredients3 = new HashSet<>();
        listeIngredients3.add(ingredient3);
        listeIngredients3.add(ingredient4);
        plat3.setIngredients(listeIngredients3);

        platRepository.save(plat3);

        //Commande

        Commande commande = new Commande();
        commande.setUser(user);
        List<Plat> listePlats = new ArrayList<>();
        listePlats.add(plat);
        commande.setPlats(listePlats);

        commandeRepository.save(commande);

        Commande commande2 = new Commande();
        commande2.setUser(user1);
        List<Plat> listePlats2 = new ArrayList<>();
        listePlats2.add(plat);
        listePlats2.add(plat3);
        commande2.setPlats(listePlats2);

        commandeRepository.save(commande2);


        Commande commande3 = new Commande();
        commande3.setUser(user);
        List<Plat> listePlats3 = new ArrayList<>();
        listePlats3.add(plat2);
        listePlats3.add(plat3);
        commande2.setPlats(listePlats3);

        commandeRepository.save(commande3);

    }
}
