package org.example;

import org.example.dao.CrudDao;
import org.example.dao.PersonneDaoImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
		InitDB.initialisation();

        Personne p = new Personne();
        p.setPrenom("Yann");
        p.setNom("Lorthioir");

        CrudDao personneDAO = new PersonneDaoImpl();

        personneDAO.create(p);

//        RequetePreparee.update(7,p);

        List<Personne> liste = RequeteSimple.getAll();
        for (Personne personne : liste) {
            System.out.println(personne.getPrenom());
        }
    }
}