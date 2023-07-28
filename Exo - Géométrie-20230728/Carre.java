package be.bstorm.exo.oo.geometrie;

public class Carre extends Forme2D implements Affichable{
    private double cote;

    public Carre(double cote) {
        this.cote = cote;
    }

    @Override
    public double calculerAire() {
        return cote * cote;
    }

    @Override
    public double calculerPerimetre() {
        return 4 * cote;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Carré - Côté : " + cote);
        System.out.println("Aire : " + calculerAire());
        System.out.println("Périmètre : " + calculerPerimetre());
    }
}
