package be.bstorm.exo.oo.etresVivants.terrestre;

import be.bstorm.exo.oo.etresVivants.EtreVivants;

public class Terrestre extends EtreVivants {
    private boolean marche;

    public boolean isMarche() {
        return marche;
    }

    protected Terrestre(boolean marche) {
        this.marche = marche;
    }

    public void seDeplacer(){
        System.out.println("Je me déplace");
    }
}
