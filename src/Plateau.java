import java.util.Random;

public class Plateau {

    private int x;
    private int y;
    private Forme[][] grille;
    private String[] nom = new String[]{"rond", "triangle", "carre"};

    public Plateau(int x, int y) {
        this.x = x;
        this.y = y;
        grille = new Forme[x][y];
        Random rd = new Random();
        for (int i = 0; i < this.x; i++) {
            for (int j = 0; j < this.y; j++) {
                int random = rd.nextInt(nom.length);
                grille[i][j] = new Forme(nom[random], i, j);
            }
        }
    }

    public boolean deplacer(Forme forme1, Forme forme2) {
        if (Math.abs(forme1.getX() - forme2.getX()) > 1 || Math.abs(forme1.getY() - forme2.getY()) > 1) {
            return false;
        }
        Forme[][] tmp = grille.clone();
        destruction();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (!tmp[i][j].equals(grille[i][j])) {
                    return false;
                }
            }
        }
        Forme formeTmp = forme1;
        grille[forme1.getX()][forme1.getY()] = forme2;
        grille[forme2.getX()][forme2.getY()] = forme1;

        return true;

    }

    public void destruction() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                int chaine = 0;
                for (int k = 0; k < 5; k++) {
                    try {
                        if (grille[i][j].equals(grille[i][j + k])) {
                            chaine++;
                        } else {
                            if (chaine >= 3) {
                                for (int l = 0; l < chaine; l++) {
                                    grille[i][j + l] = new Forme("Vide", i, j + l);
                                };
                            }
                            chaine = 0;
                            break;
                        }
                    } catch (Exception e) {
                        if (chaine >= 3) {
                            for (int l = 0; l < chaine; l++) {
                                grille[i][j + l] = new Forme("Vide", i, j + l);
                            };
                        }
                        chaine = 0;
                        break;
                    }
                }
                chaine = 0;
                for (int k = 0; k < 5; k++) {
                    try {
                        if (grille[i][j].equals(grille[i + k][j])) {
                            chaine++;
                        } else {
                            if (chaine >= 3) {
                                for (int l = 0; l < chaine; l++) {
                                    grille[i + l][j] = new Forme("Vide", i + l, j);
                                };
                            }
                            chaine = 0;
                            break;
                        }
                    } catch (Exception e) {
                        if (chaine >= 3) {
                            for (int l = 0; l < chaine; l++) {
                                grille[i + l][j] = new Forme("Vide", i + l, j);
                            };
                        }
                        chaine = 0;
                        break;
                    }
                }
            }
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
        }while (!done);
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
 public String toString() {
		
		 String ans ="  ";
		 char lettre = 'a';
		 int chiffre = 1;
		 for(int i=0; i<grille.length;i++){
		 	ans+="|" +lettre;
		 	lettre++;
		}
		 if(chiffre<10) ans+= "|\n──"+quadrillage() + "\n " + chiffre + "|";
		 else ans+= "|\n──"+quadrillage() + "\n" + chiffre + "|";
		
		 for (int i = 0; i < grille.length; i++) {
		    chiffre++;
		    for (int j = 0; j < grille[0].length; j++) ans += grille[i][j]+"|";
		    if(i < grille.length - 1) {
		    	if(chiffre<10) ans+= "\n──"+quadrillage() + "\n " + chiffre + "|";
		    	else ans+= "\n──"+quadrillage() + "\n" + chiffre + "|";
		    }
		 }
		 return ans + "\n──" + quadrillage();    
	 }
		  
	 private String quadrillage(){
		 String ans = "+";
		 for (int i = 0; i < grille[0].length ; i++) ans += "─+";
		 return ans;
	 }
}
