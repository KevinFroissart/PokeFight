package pokefight;

import java.util.Scanner;

public class ChoixPerso {

	private static Personnage PersoChoisi;

	public static String scann() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static void main(String[] args) {

		Personnage pikachou = new Personnage("Pikachou", 450, Type.FEU, "Incendie",55, 65, "Foyer",50, "Deplacement thermique",20);
		Personnage herbisoux = new Personnage("Herbisoux", 500, Type.PLANTE, "Bucheronnage", 40, 50, "Synthese",60, "Vampigrain",35);
		Personnage magicarpette = new Personnage("Magicarpette", 600, Type.EAU, "Torpille", 35, 55, "Eponge",70, "Trampette",20);		
		System.out.println("Choisissez votre personnage :");


		System.out.println("PokeFighter 1 : Pikachou [FEU]");
		System.out.println("PokeFighter 2 : Herbisoux [PLANTE]");
		System.out.println("PokeFighter 3 : Magicarpette [EAU]");
		System.out.println("Rentrez le numéro de votre PokeFighter");

		boolean ok = false;

		while(!ok) {

			String scanedT = scann();

			if(scanedT.matches("[1-3]")) {
				ok = true;
				int scaned = Integer.parseInt(scanedT);
				
				if(scaned > 0 && scaned < 4) ok = true;

				if(scaned == 1) ChoixPerso.PersoChoisi = pikachou;

				if(scaned == 2) ChoixPerso.PersoChoisi = herbisoux;

				if(scaned == 3) ChoixPerso.PersoChoisi = magicarpette;
			} else {
				System.err.println("Entrez un nombre entre 1 et 3 !");
			}
		}
	}

	public static Personnage PersoChoisi() {
		return ChoixPerso.PersoChoisi;
	}
}
