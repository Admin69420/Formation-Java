package be.bstorm.exo.oo.lambda;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    public static void main (String [] args) {
        int [] tab = {1, 24, -22563, 12349, -38, 56, -3236 } ;

        System.out.print ("-- Les positifs de tab : ") ;
        affichage_selectif (tab, e -> e > 0) ;

        System.out.print ("-- Les négatifs de tab : ") ;
        affichage_selectif (tab, e -> e < 0) ;

        System.out.print ("-- Les pairs de tab : ") ;
        affichage_selectif (tab, e -> e%2 == 0) ;

        System.out.print("-- Les carrés de tab : ");
    }

    public static void affichage_selectif (int [] t, Predicate<Integer> f){
        for (int val : t)
            if (f.test (val))
                System.out.print (val + " * ") ;

        System.out.println () ;
    }

    


}
