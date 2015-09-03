import java.awt.FontFormatException;
import java.util.Random;

public class Plateau {
	
	private int x;
	private int y;
	private Forme[][] grille;
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
	                for(int k = 1 ; k < 5 ; k++){
	                    try {
	                        if(grille[i][j].equals(grille[i][j+k]))
	                            chaine++;
	                        else{
	                            if(chaine >= 3){
	                                for(int l = j ; l < j+chaine ; l++)
	                                    grille[i][l] = null;
	                                chaine = 0;
	                                destruction();
	                                break;
	                            }
	                        }
	                    } catch (Exception e) {}
	                }
	                for(int k = 1 ; k < 5 ; k++){
	                    try {
	                        if(grille[i][j].equals(grille[i+k][j]))
	                            chaine++;
	                        else{
	                            if(chaine >= 3){
	                                for(int l = i ; l < i+chaine ; l++)
	                                    grille[l][j] = null;
	                           chaine = 0;
	                            destruction();
	                            break;
	                            }
	                        }
	                    } catch (Exception e) {}
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
		for (int i = 0; i < (this.y*2)+4; i++) {
			result += "++";
		}
		result += "\n";
		for(int i = 0; i < this.x; i++){
			result += "+";
			for(int j = 0; j < this.y; j++){
				result += this.grille[i][j] +"+";
				
			}
			int a = i*x+x;
			result+=" + "+i*x+" à "+a;
			
			result += "+\n";
		}
		for (int i = 0; i < (this.y*2)+4; i++) {
			result += "++";
		}
		
		return result;
	}
	

}
