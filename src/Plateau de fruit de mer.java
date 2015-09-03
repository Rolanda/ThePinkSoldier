public class Plateau {
    
    private final Forme[][] grille;
    
    public Plateau(int largeur, int hauteur){
        this.grille = new Forme[largeur][hauteur];
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
                            if(chaine >= 3)
                                for(int l = j ; l < j+chaine ; l++)
                                    grille[i][l] = null;
                            chaine = 0;
                            break;
                        }
                    } catch (Exception e) {}
                }
                chaine = 0;
                for(int k = 1 ; k < 5 ; k++){
                    try {
                        if(grille[i][j].equals(grille[i+k][j]))
                            chaine++;
                        else{
                            if(chaine >= 3)
                                for(int l = i ; l < i+chaine ; l++)
                                    grille[l][j] = null;
                            chaine = 0;
                            break;
                        }
                    } catch (Exception e) {}
                }
            }
        }
    }
    
    
}
