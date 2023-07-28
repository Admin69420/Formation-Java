package be.bstorm.exo.oo.etresVivants.terrestre;

import be.bstorm.exo.oo.etresVivants.Ovipare;

public class Serpent extends Terrestre implements Ovipare {
    public Serpent(){
        super(false);
    }

    @Override
    public void pondDesOeufs(int nbOeufs) {
        System.out.println("Voici "+nbOeufs+" oeufs");
    }
}
