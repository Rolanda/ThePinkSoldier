
public enum Forme {
TRIANGLE("triangle",-1,-1), CARRE("carre",-1,-1), ROND("rond",-1,-1);
	
	private char image;
	private String nom = "";
	private int x,y;
	
	Forme(String nom , int x, int y ){
		this.nom = nom;
		this.y = y;
		this.x = x;
	}
	
	public char representation(String nom){
		if(nom.equals("rond")){
			return '●';
		}else if(nom.equals("triangle")){
			return '▲';
		}else if(nom.equals("carre")){
			return '■';
		}
		return '★';
		
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

}
