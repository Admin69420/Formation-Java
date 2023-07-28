package be.bstorm.exo.oo.etresVivants.marin;

import be.bstorm.exo.oo.etresVivants.Ovipare;

public class Poisson extends Marin implements Ovipare {
    public Poisson(int nbNageoire) {
        super(nbNageoire);
    }

    @Override
    public void pondDesOeufs(int nbOeufs) {
        System.out.println("Voici "+nbOeufs+" oeufs");
    }
}
