package pokefight;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CombatTourParTour {
	
	private static int score;
	
	public static void clearScreen() {
		for(int i=0; i<60; i++) System.out.println();
	}

	public static void main(String[] args) throws IOException {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		Boss turtuna = new Boss("Turtuna",400,Type.EAU, "Jet d'eau", 35,55); //plante
		Boss jaguabite = new Boss("Jaguabite",450,Type.FEU, "Lance flamme", 45,60); //eau
		Boss salamord = new Boss("Salamord",480,Type.PLANTE, "Tranche herbe", 45,65); //feu
		Boss bellupine = new Boss("Bellupine",500,Type.EAU, "Pistolet à O", 50,60); //plante 
		Boss zebibron = new Boss("Zebibron",650,Type.FEU, "Jugement", 25,70);
		Personnage perso = ChoixPerso.PersoChoisi();
		

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
		int vieDispo = 2;
		
		boolean running = true;

		System.out.println("Vous rentrez en combat !");

		while (running){

			System.out.println("-------------------------------------------------------");

			System.out.println("\t# ATTENTION ! Un " + boss.getNom() + " est apparu ! #\n");
			System.out.println("\t"+perso.getNom()+" à toi de jouer !\n");

			while (boss.getVie()>0){
				System.out.println(perso.ascii()+"\n");
				System.out.println("\t "+perso.getNom()+" ["+perso.getVie()+"/"+perso.getVieMax()+"]");
				System.out.println(perso);
				System.out.println("\t "+boss.getNom()+" ["+boss.getVie()+"/"+boss.getVieMax()+"]");
				System.out.println(boss);
				System.out.println("----------------------------------------------------------------\n");
				System.out.println("\n\t Que doit faire "+perso.getNom()+" ?\n");
				System.out.println("	Compétences :\n");
				System.out.print("\t1. "+perso.getComp1());
				System.out.print("\t2. "+perso.getComp2() + "("+vieDispo+")");
				System.out.println("\t3. "+perso.getComp3());
				System.out.println();
				System.out.println("\t4. Abandonner");
				System.out.println("----------------------------------------------------------------\n");

				String clavier = sc.nextLine();
				clearScreen();
				System.out.println("----------------------------------------------------------------\n");

				

				if(clavier.equals("1")){
					int dommagePerso = efficaciteJoueur(perso, boss, perso.attaque());
					int dommageBoss = efficaciteBoss(perso, boss, boss.attaque());
					score = score + dommagePerso;

					boss.vieRestante(dommagePerso);
					perso.vieRestante(dommageBoss);
					
					
					System.out.println("\t> Vous frappez " + boss.getNom() +" et infligez "+ dommagePerso + " degats.");
					System.out.println("\t> " + boss.getNom() +" riposte avec "+boss.getComp1()+" et vous cause " +  dommageBoss +" degats.\n");
				}
				
				if(clavier.equals("2") && vieDispo > 0){
					perso.soin(perso.getSoin());
					int dommageBoss = efficaciteBoss(perso, boss, boss.attaque());
					
					perso.vieRestante(dommageBoss);
					
					vieDispo--;
				
					System.out.println("\t> Vous vous soignez et recevez "+ perso.getSoin()+" points de vie.");
					System.out.println("\t> " + boss.getNom() +" riposte avec "+boss.getComp1()+" et vous cause " +  dommageBoss +" degats.\n");
				}
				
				if(clavier.equals("3")){
					int dommagePerso = efficaciteJoueur(perso, boss, perso.getDmgVamp());
					perso.soin(perso.getHealVamp());
					int dommageBoss = efficaciteBoss(perso, boss, boss.attaque());
					score = score + dommagePerso;
					
					boss.vieRestante(dommagePerso);
					perso.vieRestante(dommageBoss);
					
					
					System.out.println("\t> Vous frapper " + boss.getNom() +" et infligez "+ dommagePerso + " degats et vous vous soignez de "+ perso.getHealVamp()+" points de vie.");
					System.out.println("\t> " + boss.getNom() +" riposte avec "+boss.getComp1()+" et vous cause " +  dommageBoss +" degats.\n");
				}
				
				else if(clavier.equals("4")){
					System.out.println("Vous abandonnez le combat.");
					running = false;
					Menu.reset();
					break;
				}
				

				if(perso.getVie()<=0) {
					System.out.println("Vous avez perdu, vous devez retourner au debut :(");
					System.out.println("Score obtenu : "+score); 
					Score.NewScore(Menu.nomJoueur, score+"");
					running = false;
					perso.setFullVie();
					Menu.reset();
					break;

				}
				running = false;

			}
			
			if(perso.getVie()<=0) {
				
				break;
			}
			if (boss.getVie() <=0) { 
				System.out.println(boss.ascii()+"\n");
				System.out.println(boss.getNom()  +" n'a plus de vie, vous avez vaincu "+ boss.getNom() + ".");
				score = score+perso.getVie();
				perso.setFullVie();
				System.out.println("Score obtenu : "+score); 
				Menu.setNbBossBattu(Menu.getNbBossBattu()+1);
			running = false;
			
			}
		}
	}
	
	public static int efficaciteJoueur(Personnage perso, Boss boss, int dmg) {
		if(boss.getType() == Type.PLANTE) {
			if(perso.getType() == Type.EAU) {
				System.out.println("\t> Ce n'est pas tres efficace...");
				return (int) (dmg * 0.85);
			}		
			if(perso.getType() == Type.PLANTE) {
				return dmg;
			}
			
			if(perso.getType() == Type.FEU) {
				System.out.println("\t> C'est super efficace !");
				return (int) (dmg * 1.15);
			}
		}
		
		if(boss.getType() == Type.EAU) {
			if(perso.getType() == Type.FEU) {
				System.out.println("\t> Ce n'est pas tres efficace...");
				return (int) (dmg * 0.85);
			}
			
			if(perso.getType() == Type.EAU) {
				return dmg;
			}
			
			if(perso.getType() == Type.PLANTE) {
				System.out.println("\t> C'est super efficace !");
				return (int) (dmg * 1.15);
			}
		}
		
		
		if(boss.getType() == Type.FEU) {
			if(perso.getType() == Type.PLANTE) {
				System.out.println("\t> Ce n'est pas tres efficace...");
				return (int) (dmg * 0.85);
			}
			
			if(perso.getType() == Type.FEU) {
				return dmg;
			}
			
			if(perso.getType() == Type.EAU) {
				System.out.println("\t> C'est super efficace !");
				return (int) (dmg * 1.15);
			}
		}
		return 0;
	}
	
	public static int efficaciteBoss(Personnage perso, Boss boss, int dmg) {
		if(boss.getType() == Type.PLANTE) {
			if(perso.getType() == Type.EAU) {
				return (int) (dmg * 1.30);
			}
			
			if(perso.getType() == Type.PLANTE) {
				return dmg;
			}
			
			if(perso.getType() == Type.FEU) {
				return (int) (dmg * 0.70);
			}
		}
		
		if(boss.getType() == Type.EAU) {
			if(perso.getType() == Type.FEU) {
				return (int) (dmg * 1.30);
			}
			
			if(perso.getType() == Type.EAU) {
				return dmg;
			}
			
			if(perso.getType() == Type.PLANTE) {
				return (int) (dmg * 0.70);
			}
		}
		
		if(boss.getType() == Type.FEU) {
			if(perso.getType() == Type.PLANTE) {
				return (int) (dmg * 1.30);
			}
			
			if(perso.getType() == Type.FEU) {
				return dmg;
			}
			
			if(perso.getType() == Type.EAU) {
				return (int) (dmg * 0.70);
			}
		}
		return 0;
	}
}
