package pokefight;
import java.util.Random;
import java.util.Scanner;

public class CombatTourParTour {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		Boss turtuna = new Boss("Turtuna",400,Type.EAU,35,55);
		Boss jaguabite = new Boss("Jaguabite",450,Type.FEU, 45,60);
		Boss salamord = new Boss("Salamord",480,Type.PLANTE,45,65);
		Boss bellupine = new Boss("Bellupine",500,Type.EAU,50,60);
		Boss zebibron = new Boss("Zébibron",650,Type.FEU,25,70);
		Personnage perso = new Personnage(Menu.nomJoueur, 500, Type.PLANTE, 40, 60, 35, 25);

		int vie = 0;
		int attaqueMax = 0;

		Boss boss = null;
		
		if(Menu.nbBossBattu == 0) {
			 vie = turtuna.getVie();
			 boss = turtuna;
			 }
		if(Menu.nbBossBattu == 1) {
			 vie = jaguabite.getVie();
			 boss = jaguabite;
		}
		if(Menu.nbBossBattu == 2) {
			 vie = salamord.getVie();
			 boss = salamord;
		}
		if(Menu.nbBossBattu == 3) {
			 vie = bellupine.getVie();
			 boss = bellupine;
		}
		if(Menu.nbBossBattu == 4) {
			 vie = zebibron.getVie();
			 boss = zebibron;
		}
	

		int vieBoss = 100;
		int attaqueMaxBoss = 15;

		boolean running = true;

		System.out.println("Vous rentrez en combat !");

		while (running){

			System.out.println("-------------------------------------------------------");

			System.out.println("\t# ATTENTION ! Un " + boss + " est apparu ! #\n");

			while (boss.getVie()>0){

				System.out.println("\t Votre vie : " + vie);
				System.out.println("\t Le " + boss + " a "+ boss.getVie()+" point de vie");
				System.out.println("\n\t quelle action ? ");
				System.out.println("\t1. Attaquer");
				System.out.println("\t2. Abandonner");
				System.out.println("----------------------------------------------------------------\n");

				String clavier = sc.nextLine();

				if(clavier.equals("1")){
					int dommagePerso = perso.attaque();
					int dommageBoss = boss.attaque();

					boss.vieRestante(dommagePerso);
					perso.vieRestante(dommageBoss);

					System.out.println("----------------------------------------------------------------\n");
					System.out.println("\t> vous frapper " + boss.getNom() +" et causez "+ dommagePerso + " dmg");
					System.out.println("\t> " + boss.getNom() +" riposte et vous cause " +  dommageBoss +" dmg\n");
				}

				else if(clavier.equals("2")){
					System.out.println("Vous abandonnez le combat.");
					break;
				}

				if(vie<=0) {
					System.out.println("Vous avez perdu , vous devez retourner au debut :(");
					running = false;
					break;

				}

			}
			if (vieBoss <=0) { System.out.println(boss +" n'a plus de vie, vous avez vaincu "+ boss + ".");
			running = false;
			}
		}
	}
}
