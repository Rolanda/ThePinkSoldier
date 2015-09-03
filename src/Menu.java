import java.util.Scanner;


public class Menu {
	
	
	private int choix = 0;
	public boolean ok = false;

	Scanner sc = new Scanner(System.in);
	
	public Menu(){
		do{
			System.out.println("Bienvenue !!!");
			System.out.println("1 : Jouer");
			System.out.println("2 : Options");
			System.out.println("3 : Scores");
			System.out.println("4 : Regles de jeu");
			System.out.println("5 : Quitter");

			
			try{
				choix = Integer.parseInt(sc.nextLine());
				
				if(choix >0 && choix <=5){
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
			System.out.println("Regles de jeu");
			enoncerRegles();
			
			
		}
		if(choix ==5){
			System.out.println("Quitter\nAu revoir !");
			System.exit(0);
		}
		
	}
	
	public void lancerJeu(){
		Plateau p = new Plateau(5,5);
		System.out.println(p);
	}
	
	public void enoncerRegles(){
		int retour = 0;
			do{
			System.out.println("- Aligner de 3 à 5 figures identiques");
			System.out.println("- Score en fonction du nombre de figures détruites");
			System.out.println("- indiquer les positions des 2 figures à intervertir");
			System.out.println("\n1: Retour");
			try{
				retour = Integer.parseInt(sc.nextLine());
			}catch(Exception e){
				
			}
			
		}while(retour!= 1);
			new Menu();
	}
	
	
	
	
}
