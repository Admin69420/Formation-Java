package be.bstorm.exo.oo.geometrie;

public class Main {
    public static void main(String[] args) {
        Carre carre = new Carre(4);
        Triangle triangle = new Triangle(3, 4, 5);
        Cercle cercle = new Cercle(5);
        Cube cube = new Cube(3);
        Sphere sphere = new Sphere(3);

        Affichable[] formes = {carre, triangle, cercle, cube, sphere};

        for (Affichable forme : formes) {
            forme.afficherInfo();
            System.out.println("-------------------");
        }

    }
}
