package be.bstorm.exo.oo.etresVivants.terrestre;

import be.bstorm.exo.oo.etresVivants.Mammifere;

public class Chien extends Terrestre implements Mammifere {
    private String nom;

    public Chien(String nom) {
        super(true);
        this.nom = nom;
    }

    public void abboyer(){
        System.out.println("Miaouw");
    }

    @Override
    public void accoucher() {
        System.out.println("Un bébé est venu au monde, wouf!");
    }
}
