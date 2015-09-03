import java.util.Scanner;


public class Partie {

	Scanner sc = new Scanner(System.in);
	
	public Partie(int taille) {
		Plateau p = new Plateau(taille,taille);
		do{
			//System.out.println(p);
			p.destruction();
			//System.out.println(p);
			p.glisser();
		}while(p.destruction());
		System.out.println(p);
		
		//do{
			int y=-1;
			int x=-1;
			do{
				System.out.println("Choisissez le bloc à bouger : (exemple : c2)");
			try{
				String s = sc.nextLine();
				y =  s.charAt(0) - 'a';
				System.out.println("y = "+y);
				x = Integer.parseInt(s.substring(1,s.length())) -1;
				System.out.println("x = "+x);
				if(x<0 || x >taille || y<0 || y>taille){
					x=-1;
					y=-1;
				}
			}catch(Exception e){
				
			}
			}while(x==-1 || y==-1);
			
			int y2=-1;
			int x2=-1;
			do{
				System.out.println("Choisissez le bloc voisin à échanger avec le premier : (exemple : c2)");
			try{
				String s2 = sc.nextLine();
				y2 =  s2.charAt(0) - 'a';
				System.out.println("y2 = "+y2);
				x2 = Integer.parseInt(s2.substring(1,s2.length())) -1;
				System.out.println("x2 = "+x2);
				if(x2<0 || x2 >taille || y2<0 || y2>taille){
					x2=-1;
					y2=-1;
					System.out.println("format invalide");

				}
				else if(!voisins(x,y,x2,y2)){
					System.out.println("choisissez un bloc voisin !");
					x2=-1;
					y2=-1;
				}
			}catch(Exception e){
				
			}
			}while(x2==-1 || y2==-1);
			
			p.deplacer(x, y, x2, y2);
			
			
			System.out.println(p);
			
		//}while(/*temps*/)
	}
	
	public boolean voisins(int x1, int y1, int x2, int y2){
		
		if(x1<x2){
			if(x1+1 == x2){
				if(y1==y2) return true;
			}
		}
		else {
			if(x2+1 == x1){
				if(y1 == y2) return true;
			}
		}
		if(y1<y2){
			if(y1+1 == y2){
				if(x1==x2) return true;
			}
		}
		else {
			if(y2+1 == y1){
				if(x1 == x2) return true;
			}
		}
		
		
		
		return false;
				
	}
	
}
