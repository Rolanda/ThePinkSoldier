/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thepinksoldier;

/**
 *
 * @author lopezb
 */
import java.util.Random;

public class Plateau {

    private int largeur;
    private int hauteur;
    private Forme[][] grille;
    private String[] nom = new String[]{"rond", "triangle", "carre", "losange"};

    public Plateau(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        grille = new Forme[largeur][hauteur];
        Random rd = new Random();
        for (int i = 0; i < this.largeur; i++) {
            for (int j = 0; j < this.hauteur; j++) {
                int random = rd.nextInt(nom.length);
                grille[i][j] = new Forme(nom[random], i, j);
            }
        }
    }

    public boolean deplacer(Forme forme1, Forme forme2) {
        
        //if (Math.abs(forme1.getX() - forme2.getX()) > 1 || Math.abs(forme1.getY() - forme2.getY()) > 1)
        int x1 = 0,y1 = 0,x2 = 0,y2 = 0;
        for(int i = 0 ; i < grille.length ; i++){
            for(int j = 0 ; j < grille[i].length ; j++){
                if(forme1 == grille[i][j]){
                    x1 = i;
                    y1 = j;
                }
                if(forme2 == grille[i][j]){
                    x2 = i;
                    y2 = j;
                }
            }
        }
        if(!(Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1 && ((x1 == x2 && y1 != y2) || (x1 != x2 && y1 == y2))))
            return false;
//        Forme[][] tmp = grille.clone();
//        destruction();
//        for (int i = 0; i < grille.length; i++) {
//            for (int j = 0; j < grille[i].length; j++) {
//                if (!tmp[i][j].equals(grille[i][j])) {
//                    return false;
//                }
//            }
//        }
        
        
        
        Forme formeTmp = forme1;
        grille[x1][y1] = forme2;
        grille[x2][y2] = forme1;

        return true;

    }

    public boolean deplacer(int x1, int y1, int x2, int y2) {

        Forme[][] tmp = grille.clone();
        destruction();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (!tmp[i][j].equals(grille[i][j])) {
                    return false;
                }
            }
        }
        Forme formeTmp = grille[x1][y1];
        grille[x1][y1] = grille[x2][y2];
        grille[x2][y2] = formeTmp;

        return true;

    }

    public boolean destruction() {
        boolean aAgit = false;
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                int chaine = 0;
                for (int k = 0; k < 5; k++) {
                    //try{
                    if (j + k < grille[i].length) {
                        if (grille[i][j].equals(grille[i][j + k])) {
                            chaine++;
                        } else {
                            if (chaine >= 3) {
                                for (int l = 0; l < chaine; l++) {
                                    grille[i][j + l] = new Forme("Vide", i, j + l);
                                }
//                                supprimerLigne(i, i, j, j+chaine);
                                aAgit = true;
                                if (Constante.score >= 0) {
                                    Constante.addPoints(chaine);
                                }
                            }
                            chaine = 0;
                            break;
                        }
                    } else {
                        if (chaine >= 3) {
                            for (int l = 0; l < chaine; l++) {
                                grille[i][j + l] = new Forme("Vide", i, j + l);
                            }
//                                supprimerLigne(i, i, j, j+chaine);
                            aAgit = true;
                            if (Constante.score >= 0) {
                                Constante.addPoints(chaine);
                            }
                        }
                        break;
                    }
//                    } catch (Exception e) {
//                        if (chaine >= 3) {
//                            for (int l = 0; l < chaine; l++) 
//                                grille[i][j + l] = new Forme("Vide", i, j + l);
////                            supprimerLigne(i, i, j, j+chaine);
//                            aAgit= true;
//                        }
//                        chaine = 0;
//                        break;
//                    }
                }
                chaine = 0;
                for (int k = 0; k < 5; k++) {
                    //try {
                    if (i + k < grille.length) {
                        if (grille[i][j].equals(grille[i + k][j])) {
                            chaine++;
                        } else {
                            if (chaine >= 3) {
                                for (int l = 0; l < chaine; l++) {
                                    grille[i + l][j] = new Forme("Vide", i + l, j);
                                }
//                                supprimerLigne(i, i + chaine, j, j);
                                aAgit = true;
                                if (Constante.score >= 0) {
                                    Constante.addPoints(chaine);
                                }
                            }
                            chaine = 0;
                            break;
                        }
                    } else {
                    //}catch(Exception e){
                        if (chaine >= 3) {
                            for (int l = 0; l < chaine; l++) {
                                grille[i + l][j] = new Forme("Vide", i + l, j);
                            }
//                                supprimerLigne(i, i, j, j+chaine);
                            aAgit = true;
                            chaine = 0;
                            if (Constante.score >= 0) {
                                Constante.addPoints(chaine);
                            }
                        }
                        break;
                    }
//                    } catch (Exception e) {
//                        if (chaine >= 3) {
//                            for (int l = 0; l < chaine; l++)
//                                grille[i + l][j] = new Forme("Vide", i + l, j);
////                                aAgit= true;
//////                            };
////                            supprimerLigne(i, i + chaine, j, j);
//                            aAgit= true;
//                        }
//                        chaine = 0;
//                        break;
//                    }
                }
            }
        }
        return aAgit;
    }

    public void supprimerLigne(int x1, int y1, int x2, int y2) {
//        for(int i = x1 ; i < x2 ; i++)
//            for(int j = y1 ; j < y2 ; j++)
//                grille[i][j] = new Forme("Vide", i, j);
        if (Constante.score >= 0) {
            Constante.addPoints(Math.abs(x1 - x2) + Math.abs(y1 - y2));
        }

    }

    public void glisser() {
        boolean done;
        do {
            done = true;
            for (Forme[] i : grille) {
                for (Forme j : i) {
                    if (j.getNom().equals("Vide")) {
                        done = false;
                    }
                }
            }
            for (int i = this.grille.length - 1; i >= 0; i--) {
                for (int j = this.grille[i].length - 1; j >= 0; j--) {
                    if (this.grille[i][j].getNom().equals("Vide")) {
                        if (i > 0) {
                            this.grille[i][j] = this.grille[i - 1][j];
                            this.grille[i - 1][j] = new Forme("Vide", i, j);
                        } else {
                            Random rand = new Random();
                            int random = rand.nextInt(nom.length);
                            grille[i][j] = new Forme(nom[random], i, j);
                        }
                    }
                }
            }
        } while (!done);
    }

    public int getX() {
        return largeur;
    }

    public int getY() {
        return hauteur;
    }
    
    public Forme[][] getGrille(){
        return this.grille;
    }

    public String toString() {
        System.out.print("\033[H\033[2J");
        String ans = "  ";
        char lettre = 'a';
        int chiffre = 1;
        for (int i = 0; i < grille.length; i++) {
            ans += "|" + lettre;
            lettre++;
        }
        if (chiffre < 10) {
            ans += "|\n──" + quadrillage() + "\n " + chiffre + "|";
        } else {
            ans += "|\n──" + quadrillage() + "\n" + chiffre + "|";
        }

        for (int i = 0; i < grille.length; i++) {
            chiffre++;
            for (int j = 0; j < grille[0].length; j++) {
                ans += grille[i][j].getCouleur() + grille[i][j] + Constante.ANSI_RESET + "|";
            }
            if (i < grille.length - 1) {
                if (chiffre < 10) {
                    ans += "\n──" + quadrillage() + "\n " + chiffre + "|";
                } else {
                    ans += "\n──" + quadrillage() + "\n" + chiffre + "|";
                }
            }
        }
        return ans + "\n──" + quadrillage();
    }

    private String quadrillage() {
        String ans = "+";
        for (int i = 0; i < grille[0].length; i++) {
            ans += "─+";
        }
        return ans;
    }
}
