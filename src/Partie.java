/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepinksoldier;

/**
 *
 * @author Lopez Benjamin
 */
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Partie {

    private Scanner sc = new Scanner(System.in);
    private final Plateau plateau;
    private final int taille;

    public Partie(int taille) {
        Score score = new Score();
        score.start();
        this.taille = taille;
        plateau = new Plateau(taille, taille);
        do {
            //System.out.println(plateau);
            plateau.destruction();
            //System.out.println(plateau);
            plateau.glisser();
        } while (plateau.destruction());
        Constante.addPoints(1);
//        System.out.println(plateau);
//        int y = -1;
//        int x = -1;
//        do {
//            System.out.println("Choisissez le bloc à bouger : (Exemple : c2)");
//            try {
//                String s = sc.nextLine();
//                y = s.charAt(0) - 'a';
////                System.out.println("y = " + y);
//                x = Integer.parseInt(s.substring(1, s.length())) - 1;
////                System.out.println("x = " + x);
//                if (x < 0 || x > taille || y < 0 || y > taille) {
//                    x = -1;
//                    y = -1;
//                }
//            } catch (Exception e) {}
//        } while (x == -1 || y == -1);
//        int y2 = -1;
//        int x2 = -1;
//        do {
//            System.out.println("Choisissez le bloc voisin à échanger avec le premier : (Exemple : c3)");
//            try {
//                String s2 = sc.nextLine();
//                y2 = s2.charAt(0) - 'a';
////                System.out.println("y2 = " + y2);
//                x2 = Integer.parseInt(s2.substring(1, s2.length())) - 1;
////                System.out.println("x2 = " + x2);
//                if (x2 < 0 || x2 > taille || y2 < 0 || y2 > taille) {
//                    x2 = -1;
//                    y2 = -1;
//                    System.out.println("Format invalide");
//                } else if (!voisins(x, y, x2, y2)) {
//                    System.out.println("Choisissez un bloc voisin !");
//                    x2 = -1;
//                    y2 = -1;
//                }
//            } catch (Exception e) {}
//        } while (x2 == -1 || y2 == -1);
//
//        plateau.deplacer(x, y, x2, y2);
//        plateau.destruction();
//        System.out.println(plateau);
//        Timer timerDestruction = new Timer();
//        timerDestruction.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                plateau.glisser();
//                System.out.println(plateau);
//            }
//        }, 1000);
        
        System.out.println(plateau);
        while(true){
            nouveauTour();
        }
        

        //}while(/*temps*/)
    }
    
    public void nouveauTour(){
        int y = -1;
        int x = -1;
        do {
            System.out.println("Choisissez le bloc à bouger : (Exemple : c2)");
            try {
                String s = sc.nextLine();
                y = s.charAt(0) - 'a';
//                System.out.println("y = " + y);
                x = Integer.parseInt(s.substring(1, s.length())) - 1;
//                System.out.println("x = " + x);
                if (x < 0 || x > taille || y < 0 || y > taille) {
                    x = -1;
                    y = -1;
                }
            } catch (Exception e) {}
        } while (x == -1 || y == -1);
        int y2 = -1;
        int x2 = -1;
        do {
            System.out.println("Choisissez le bloc voisin à échanger avec le premier : (Exemple : c3)");
            try {
                String s2 = sc.nextLine();
                y2 = s2.charAt(0) - 'a';
//                System.out.println("y2 = " + y2);
                x2 = Integer.parseInt(s2.substring(1, s2.length())) - 1;
//                System.out.println("x2 = " + x2);
                if (x2 < 0 || x2 > taille || y2 < 0 || y2 > taille) {
                    x2 = -1;
                    y2 = -1;
                    System.out.println("Format invalide");
                } else if (!voisins(x, y, x2, y2)) {
                    System.out.println("Choisissez un bloc voisin !");
                    x2 = -1;
                    y2 = -1;
                }
            } catch (Exception e) {}
        } while (x2 == -1 || y2 == -1);

        plateau.deplacer(x, y, x2, y2);
        plateau.destruction();
        System.out.println(plateau);
        Timer timerDestruction = new Timer();
        timerDestruction.schedule(new TimerTask() {

            @Override
            public void run() {
                plateau.glisser();
                System.out.println(plateau);
            }
        }, 1000);
    }

    public boolean voisins(int x1, int y1, int x2, int y2) {

//        if (x1 < x2) {
//            if (x1 + 1 == x2) {
//                if (y1 == y2) {
//                    return true;
//                }
//            }
//        } else {
//            if (x2 + 1 == x1) {
//                if (y1 == y2) {
//                    return true;
//                }
//            }
//        }
//        if (y1 < y2) {
//            if (y1 + 1 == y2) {
//                if (x1 == x2) {
//                    return true;
//                }
//            }
//        } else {
//            if (y2 + 1 == y1) {
//                if (x1 == x2) {
//                    return true;
//                }
//            }
//        }
        
        return Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1 && ((x1 == x2 && y1 != y2) || (x1 != x2 && y1 == y2));

        //return false;

    }

}
