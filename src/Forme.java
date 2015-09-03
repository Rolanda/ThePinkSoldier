
public enum Forme {
TRIANGLE("triangle",-1,-1), CARRE("carre",-1,-1), ROND("rond",-1,-1);
	
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
			return '●';
			this.couleur="\033[34m"; 
		}else if(nom.equals("triangle")){
			return '▲';
			this.couleur = "\033[32m"; 
		}else if(nom.equals("carre")){
			return '■';
			this.couleur = "\033[31m"; 
		}
		return '★';
		
	}
	
	public String getCouleur(){
		return this.couleur;
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
