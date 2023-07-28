package be.bstorm.exo.oo.geometrie;

public class Triangle extends Forme2D implements Affichable{
    private double cote1;
    private double cote2;
    private double cote3;

    public Triangle(double cote1, double cote2, double cote3) {
        this.cote1 = cote1;
        this.cote2 = cote2;
        this.cote3 = cote3;
    }

    @Override
    public double calculerAire() {
        double p = (cote1 + cote2 + cote3) / 2;
        return Math.sqrt(p * (p - cote1) * (p - cote2) * (p - cote3));
    }

    @Override
    public double calculerPerimetre() {
        return cote1 + cote2 + cote3;
    }

    @Override
    public void afficherInfo() {
        System.out.println("Triangle - Côté 1 : " + cote1 + ", Côté 2 : " + cote2 + ", Côté 3 : " + cote3);
        System.out.println("Aire : " + calculerAire());
        System.out.println("Périmètre : " + calculerPerimetre());
    }
}
