package be.bstorm.exo.oo.geometrie;

public class Sphere extends Forme3D implements Affichable {
    private double rayon;

    public Sphere(double rayon) {
        this.rayon = rayon;
    }

    @Override
    public double calculerVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(rayon, 3);
    }

    @Override
    public void afficherInfo() {
        System.out.println("Sphère - Rayon : " + rayon);
        System.out.println("Volume : " + calculerVolume());
    }
}
