package pokefight;

import java.util.Scanner;

public class ChoixPerso {
	
	private static Personnage PersoChoisi;
	
	public static String scann() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static void main(String[] args) {
		
		Personnage pikachou = new Personnage("Pikachou", 500, Type.FEU, "Attaque",10, 20, "Soin",20, "Vamp",20);
		Personnage herbisoux = new Personnage("Herbisoux", 500, Type.PLANTE, "Attaque", 10, 20, "Soin",20, "Vamp",20);
		Personnage magicarpette = new Personnage("Magicarpette", 500, Type.EAU, "Attaque", 10, 20, "Soin",20, "Vamp",20);		
		System.out.println("Choisissez votre personnage :");
		
		System.out.println("PokeFighter 1 : Pikachou [FEU]");
		System.out.println("PokeFighter 2 : Herbisoux [PLANTE]");
		System.out.println("PokeFighter 3 : Magicarpette [EAU]");
		System.out.println("Rentrez le numéro de votre PokeFighter");
		
		boolean ok = false;
		
		while(!ok) {
			int scaned = Integer.parseInt(scann());
			if(scaned > 0 && scaned < 4) ok = true;
			
			if(scaned == 1) ChoixPerso.PersoChoisi = pikachou;

			if(scaned == 2) ChoixPerso.PersoChoisi = herbisoux;

			if(scaned == 3) ChoixPerso.PersoChoisi = magicarpette;
		}	
	}
}
