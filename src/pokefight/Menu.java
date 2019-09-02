package pokefight;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void clearScreen() {
		for(int i=0; i<30; i++) System.out.println();
	}

	public static String scann() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	int score = 0;
	
	static String titre = "\n" + 
			" /$$$$$$$           /$$                 /$$$$$$$$ /$$           /$$         /$$     \n" + 
			"| $$__  $$         | $$                | $$_____/|__/          | $$        | $$    \n" + 
			"| $$  \\ $$ /$$$$$$ | $$   /$$  /$$$$$$ | $$       /$$  /$$$$$$ | $$$$$$$  /$$$$$$  \n" + 
			"| $$$$$$$//$$__  $$| $$  /$$/ /$$__  $$| $$$$$   | $$ /$$__  $$| $$__  $$|_  $$_/  \n" + 
			"| $$____/| $$  \\ $$| $$$$$$/ | $$$$$$$$| $$__/   | $$| $$  \\ $$| $$  \\ $$  | $$    \n" + 
			"| $$     | $$  | $$| $$_  $$ | $$_____/| $$      | $$| $$  | $$| $$  | $$  | $$ /$$\n" + 
			"| $$     |  $$$$$$/| $$ \\  $$|  $$$$$$$| $$      | $$|  $$$$$$$| $$  | $$  |  $$$$/\n" + 
			"|__/      \\______/ |__/  \\__/ \\_______/|__/      |__/ \\____  $$|__/  |__/   \\___/  \n" + 
			"                                                      /$$  \\ $$                    \n" + 
			"                                                     |  $$$$$$/                    \n" + 
			"                                                      \\______/                     ";
	static String jouer = "1 - Jouer";
	static String regles = "2 - Règles";
	static String progression = "3 - Progression";
	static String classement = "4 - Classement";
	static String quitter = "5 - Quitter";
	static String MRelges = "            -------------------------\n            | REGLES DE POKEFIGHTER |\n            -------------------------\n" 
			               + "Dans ce jeu vous incarnez  un Pokefighter qui se \n"  
			               + "retrouve bloquer dans un donjon. \n" 
			               + "Pour réussir à s'en sortir, \nvous allez devoir combattre de terribles "
			               + "adversaires \net acquerir de l'experience jusqu'à vaincre le boss\n"
			               + "final de ce donjon. \n"
			               + "Mais attention à ne pas vous retrouver sans point de vie avant la fin,\n"
			               + "ou vous devrez retourner à l'entrée ! \n"
			               + "Depuis le menu principal, vous pouvez lancer une nouvelle partie, consulter vos précédents records, \n"
			               + "voir les crédits ou quitter le jeu.\n";

	public static void main(String args[]) throws IOException {

		String nomJoueur = "";

		System.err.println(titre);
		System.out.println();
		System.out.println(jouer);
		System.out.println(regles);
		System.out.println(progression);
		System.out.println(classement);
		System.out.println(quitter);

		//Scanner scan = new Scanner(System.in);
		boolean ok = false;
		while(!ok) {
			int scaned = Integer.parseInt(scann());
			if(scaned > 0 && scaned < 6) ok = true;

			if(scaned == 5) Runtime.getRuntime().exec("taskkill /F /IM process.exe");;

			if(scaned == 4) ;

			if(scaned == 3) ;

			if(scaned == 2) { clearScreen(); System.out.println(MRelges); }

			if(scaned == 1) {

				int nomOK = 0;
				
				while(nomOK == 0) {
					
					clearScreen();
					System.out.println("Entre ton nom :");

					nomJoueur = scann();

					System.out.println("Ton nom est bien " + nomJoueur + " ?");
					System.out.println("Oui = o    Non = n");
					
					String roz = scann();
					
					if(roz.equals("o")) nomOK = 1; 
					
				}
			}
		}
	}
}
