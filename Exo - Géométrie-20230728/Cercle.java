package be.bstorm.exo.oo.geometrie;

public class Cercle extends Forme2D implements Affichable{
    private double rayon;

    public Cercle(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerAire() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public double calculerPerimetre() {
        return 2 * Math.PI * rayon;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Cercle - Rayon : " + rayon);
        System.out.println("Aire : " + calculerAire());
        System.out.println("Périmètre : " + calculerPerimetre());
    }
}

