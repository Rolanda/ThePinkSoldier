import java.util.Random;

public class Plateau {
	
	private int x;
	private int y;
	private final Forme[][] grille;
	private String[] nom = new String[]{"ROND","TRIANGLE", "CARRE" };
	
	public Plateau(int x, int y) {
            this.x = x;
            this.y = y;
            grille = new Forme[x][y];
            Random rd = new Random();
            for (int i = 0; i < this.x; i++) {
                for (int j = 0; j < this.y; j++) {
                    int random = rd.nextInt(nom.length);
                    grille[i][j] =  new Forme(nom[random].toLowerCase(), i, j);
		}
            }
	}
	
	public boolean deplacer(Forme forme1, Forme forme2){
        if(Math.abs(forme1.getX() - forme2.getX()) > 1 || Math.abs(forme1.getY() - forme2.getY()) > 1)
                return false;
        Forme[][] tmp = grille.clone();
        destruction();
        for(int i = 0 ; i < grille.length ; i++)
            for(int j = 0 ; j < grille[i].length ; j++)
                if(!tmp[i][j].equals(grille[i][j]))
                    return false;
        Forme formeTmp = forme1;
        grille[forme1.getX()][forme1.getY()] = forme2;
        grille[forme2.getX()][forme2.getY()] = forme1;
        
        return true;
        
        
    }
	
	 public void destruction(){
	        for(int i = 0 ; i < grille.length ; i++){
	            for(int j = 0 ; j < grille[i].length ; j++){
	                int chaine = 0;
	                for(int k = 0 ; k < 5 ; k++){
	                    try {
	                        if(grille[i][j].equals(grille[i][j+k]))
	                            chaine++;
	                        else{
	                            if(chaine >= 3){
                                        for(int l = 0 ; l < chaine ; l++){
                                            grille[i][j+l] = new Forme("tamer", i, j+l);
                                        };
	                            }
                                    chaine = 0;
                                    break;
	                        }
	                    } catch (Exception e) {
                                if(chaine >= 3){
                                        for(int l = 0 ; l < chaine ; l++){
                                            grille[i][j+l] = new Forme("tamer", i, j+l);
                                        };
	                            }
                                    chaine = 0;
                                    break;
                            }
	                }
                        chaine = 0;
	                for(int k = 0 ; k < 5 ; k++){
	                    try {
	                        if(grille[i][j].equals(grille[i+k][j]))
	                            chaine++;
	                        else{
	                            if(chaine >= 3){
                                        for(int l = 0 ; l < chaine ; l++){
                                            grille[i+l][j] = new Forme("tamer", i+l, j);
                                        };
	                            }
                                    chaine = 0;
                                    break;
	                        }
	                    } catch (Exception e) {
                                if(chaine >= 3){
                                        for(int l = 0 ; l < chaine ; l++){
                                            grille[i+l][j] = new Forme("tamer", i+l, j);
                                        };
	                            }
                                    chaine = 0;
                                    break;
                            }
	                }
	            }
	        }
	    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public String toString(){
		String result = "";
		for (int i = 0; i < (this.y*2)+1; i++) {
			result += "+";
		}
		result += "\n";
		for(int i = 0; i < this.x; i++){
			result += "+";
			for(int j = 0; j < this.y; j++)
				result += this.grille[i][j] +"+";
			result += "\n";
		}
		for (int i = 0; i < (this.y*2)+1; i++) {
			result += "+";
		}
		return result;
	}
	

}
