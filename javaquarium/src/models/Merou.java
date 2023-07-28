package models;

import enums.Sexe;
import interfaces.IHermaphrodite;
import interfaces.IPoisson;

public class Merou extends Carnivore implements IHermaphrodite {
    public Merou(String name) {
        super(name);
    }

    @Override
    public Sexe getSexe() {
        if (this.getAge() < 10) {
            return Sexe.MALE;
        }
        else {
            return Sexe.FEMELLE;
        }
    }
    @Override
    public IPoisson reproduce(IPoisson poisson) {
        if (poisson != this
                && poisson instanceof Merou
                && poisson.getSexe() != this.getSexe()) {

            return new Merou("Bébé");
        }
        else {
            System.out.println("Pas bébé");
            return null;
        }
    }

    @Override
    public void changementSexe() {
        if(getAge()==10 && getSexe()==Sexe.MALE){
            setSexe(Sexe.FEMELLE);
        } else if (getAge()==10 && getSexe()==Sexe.FEMELLE) {
            setSexe(Sexe.MALE);
        }
    }

    @Override
    public void passerTour() {
        super.passerTour();
        changementSexe();
    }
}
