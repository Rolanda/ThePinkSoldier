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
		
		if(choix ==1){
			lancerJeu();
		}
		if(choix ==2){
			afficherOptions();
		}
		if(choix ==3){
			afficherScores();
		}
		if(choix ==4){
			enoncerRegles();
			
			
		}
		if(choix ==5){
			System.out.println("Au revoir !");
			System.exit(0);
		}
		
	}
	
	public void lancerJeu(){
		Main.p = new Plateau(5,5);
		System.out.println(Main.p);		
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
	
	public void afficherScores(){
		System.out.println("Scores    ");
		int retour =0;
		do{
			System.out.println("\n1: Retour");
			try{
				retour = Integer.parseInt(sc.nextLine());
			}catch(Exception e){		
			}
		}while(retour!= 1);
		new Menu();
	}
	public void afficherOptions(){
		System.out.println("Options    ");

		int retour =0;
		do{
			System.out.println("\n1: Retour");
			try{
				retour = Integer.parseInt(sc.nextLine());
			}catch(Exception e){		
			}
		}while(retour!= 1);
		new Menu();
	}
	
	
	
	
}
