import java.util.Scanner;


public class Menu {
	
	
	private int choix = 0;
	public boolean ok = false;

	public Menu(){
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("Bienvenue !!!");
			System.out.println("1 : Jouer");
			System.out.println("2 : Options");
			System.out.println("3 : Scores");
			System.out.println("4 : Quitter");
			
			try{
				choix = Integer.parseInt(sc.nextLine());
				
				if(choix >0 && choix <=4){
					ok = true;
				}
			}catch(Exception e){
				
			}
		}while(!ok);
		
		System.out.print("Vous avez choisi : ");
		if(choix ==1){
			System.out.println("Jouer");
			lancerJeu();
		}
		if(choix ==2){
			System.out.println("Options");
		}
		if(choix ==3){
			System.out.println("Scores");
		}
		if(choix ==4){
			System.out.println("Quitter\nAu revoir !");
		}
		
	}
	
	public void lancerJeu(){
		
	}
	
	
	
	
}
