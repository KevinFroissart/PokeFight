package pokefight;

import java.io.IOException;
import java.util.Scanner;

public class Menu {

	public static void clearScreen() {
		for(int i=0; i<60; i++) System.out.println();
	}

	public static String scann() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	static boolean boss1 = false;
	static boolean boss2 = false;
	static boolean boss3 = false;
	static boolean boss4 = false;
	static boolean boss5 = false;

	static int score = 0;
	static int nbBoss = 5;
	static int nbBossBattu = 0;
	static String nomJoueur = "";
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
			+ "Bienvenu dans PokéFight \n"  
			+ "Choisissez votre PokéFighter et affrontez tous les boss pour gagner. \n" 
			+ "Chaque Pokéfighter et chaque ennemies possèdent des types parmis \n "
			+ "les types EAU,\n"
			+ "final de ce donjon. \n"
			+ "Mais attention à ne pas vous retrouver sans point de vie avant la fin,\n"
			+ "ou vous devrez retourner à l'entrée ! \n"
			+ "Depuis le menu principal, vous pouvez lancer une nouvelle partie, consulter vos précédents records, \n"
			+ "voir les crédits ou quitter le jeu.\n";

	public static void main(String args[]) throws IOException, InterruptedException {

		//clearScreen();



		System.err.println(titre);
		System.out.println();
		Thread.sleep(100);
		System.out.println(jouer);
		System.out.println(regles);
		System.out.println(progression);
		System.out.println(classement);
		System.out.println(quitter);



		boolean ok = false;
		while(!ok) {

			String scanedT = scann();

			if(scanedT.matches("[1-5]")) {

				int scaned = Integer.parseInt(scanedT);
				ok = true;

				if(scaned == 5) Runtime.getRuntime().exec("taskkill /F /IM process.exe");;

				if(scaned == 4) {
					Score.main(args);
					System.out.println();
					System.out.println("Appuye sur 1 puis Entrer pour revenir au menu");
					boolean ok2 = false;
					while(!ok2) {
						if(scann().matches("1")) {
							main(args);
							ok2 = true;
						} else {
							System.err.println("Veuillez entrer 1 pour revenir au menu.");
						}
					}
				}

				if(scaned == 3) {

					for(int i = 0; i < nbBoss; i++) {
						System.out.print("Boss n°" + (i+1) + " :");

						switch(i) {
						case 0: if(boss1) System.out.print("OK");
						case 1: if(boss2) System.out.print("OK");
						case 2: if(boss3) System.out.print("OK");
						case 3: if(boss4) System.out.print("OK");
						case 4: if(boss5) System.out.print("OK");
						System.out.println();
						}
					}
					System.out.println("Appuye sur 1 puis Entrer pour revenir au menu");
					boolean ok3 = false;
					while(!ok3) {
						if(scann().matches("1")) {
							main(args);
							ok3 = true;
						} else {
							System.err.println("Veuillez entrer 1 pour revenir au menu.");
						}
					}
				}

				if(scaned == 2) { 

					clearScreen(); 
					System.out.println(MRelges); 
					System.out.println("Appuye sur 1 puis Entrer pour revenir au menu");
					boolean ok4 = false;
					while(!ok4) {
						if(scann().matches("1")) {
							main(args);
							ok4 = true;
						} else {
							System.err.println("Veuillez entrer 1 pour revenir au menu.");
						}
					}
					if(Integer.parseInt(scann()) == 1) main(args);

				}

				if(scaned == 1) {

					if (nbBossBattu == 0 ) {
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
					ChoixPerso.main(args);
					CombatTourParTour.main(args);
					//System.out.println("pokemon vs pokemon\n-----------------------------");//Jauge de vie

					if (nbBossBattu == 1)boss1 = true;
					if (nbBossBattu == 2){boss2 = true; boss1 = false;}
					if (nbBossBattu == 3){boss3 = true; boss2 = false;}
					if (nbBossBattu == 4){boss4 = true; boss3 = false;}
					if (nbBossBattu == 5){boss5 = true; boss4 = false;}

					if(nbBossBattu != 5) {System.out.println("Vous avez vaincu ce Boss légendaire ! Le suivant n'a qu'à bien se tenir !\n\n\n");
					Menu.main(args);
					}
				} 
			} else {
				System.err.println("Entrez un nombre en 1 et 5 !");
			}
		} 				System.out.println("BRAVO !!!!! VOUS ETES SORTIE INDEMNE DE CE DONJON !!!!!\n VOUS ETES LIBRE ET VOUS ETES DEVENU LE MEILLEUR POKEFIGHTER");


	}

	public static int getNbBossBattu() {
		return nbBossBattu;
	}

	public static void setNbBossBattu(int nbBossBattu) {
		Menu.nbBossBattu = nbBossBattu;
	}

	public static void reset() {
		score = 0;
		Menu.setNbBossBattu(0);
		boss1 = false;
		boss2 = false;
		boss3 = false;
		boss4 = false;
		boss5 = false;
	}
}
