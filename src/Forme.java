
public class Forme {
	
	private char image;
	private String nom = "";
	private int x,y;
	private String couleur="";
	
	Forme(String nom , int x, int y ){
		this.nom = nom;
		this.y = y;
		this.x = x;
		this.image = representation(nom);
	}
	
	public char representation(String nom){
		if(nom.equals("rond")){
			this.couleur = Constante.ANSI_BLUE_BG;
			return '●';
		}else if(nom.equals("triangle")){
			this.couleur = Constante.ANSI_GREEN_BG;
			return '▲';
		}else if(nom.equals("carre")){
			this.couleur = Constante.ANSI_RED_BG;
			return '■';
		}
		return '★';
		
	}
	
	public String getCouleur(){
		return this.couleur;
	}
	public String getNom(){
		return nom;
	}
	public void setCouleur(String s){
		this.couleur=s;
	}
	
	public int getX(){
		return this.x;
	}
	
	
	public int getY(){
		return this.y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.x = y;
	}
	
	public String toString(){
		return ""+image;
	}
	public boolean equals(Forme f){
		if(this.nom.equals(f.nom)){
			return true;
		}
		return false;
	}

}

