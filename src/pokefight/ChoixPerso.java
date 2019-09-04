package pokefight;

import java.util.ArrayList;
import java.util.Scanner;

public class ChoixPerso {

	private static Personnage PersoChoisi;
	static Personnage pikachou = new Personnage("Pikachou", 450, Type.FEU, "Incendie",55, 65, "Foyer",50, "Deplacement thermique",20);
	static Personnage herbisoux = new Personnage("Herbisoux", 500, Type.PLANTE, "Bucheronnage", 40, 50, "Synthese",60, "Vampigrain",35);
	static Personnage magicarpette = new Personnage("Magicarpette", 600, Type.EAU, "Torpille", 35, 55, "Eponge",70, "Trampette",20);		

	public static String[] getAllNom() {
		String listeNom[] = new String[3];
		listeNom[0] = pikachou.getNom();
		listeNom[1] = herbisoux.getNom();
		listeNom[2] = magicarpette.getNom();
		return listeNom;
	}

	public static void setNom1(String nom) {
		pikachou.setNom(nom);
	}
	public static void setNom2(String nom) {
		herbisoux.setNom(nom);
	}
	public static void setNom3(String nom) {
		magicarpette.setNom(nom);
	}

	public static String scann() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public static void main(String[] args) {


		System.out.println("Choisissez votre personnage :");


		System.out.println("PokeFighter 1 : "+pikachou.getNom()+" [FEU]");
		System.out.println("PokeFighter 2 : "+herbisoux.getNom()+" [PLANTE]");
		System.out.println("PokeFighter 3 : "+ magicarpette.getNom()+" [EAU]");
		System.out.println("PokeFighter 4 : Creer votre PokeFighter");
		System.out.println("Rentrez le numéro de votre PokeFighter");

		boolean ok = false;

		while(!ok) {

			String scanedT = scann();

			if(scanedT.matches("[1-4]")) {
				ok = true;
				int scaned = Integer.parseInt(scanedT);

				if(scaned > 0 && scaned < 5) ok = true;

				if(scaned == 1) ChoixPerso.PersoChoisi = pikachou;

				if(scaned == 2) ChoixPerso.PersoChoisi = herbisoux;

				if(scaned == 3) ChoixPerso.PersoChoisi = magicarpette;

				if(scaned == 4) ChoixPerso.PersoChoisi = creationPerso();
			} else {
				System.err.println("Entrez un nombre entre 1 et 4 !");
			}
		}
	}

	public static Personnage PersoChoisi() {
		return ChoixPerso.PersoChoisi;
	}

	public static Personnage creationPerso() {
		String nom = "";
		int vie = 0;
		int puissance = 0;
		int regen = 0;
		String var;
		Type type = Type.FEU;
		String nomType;
		String comp1;
		String comp2;
		String comp3;
		boolean okstat = false;
		boolean oktype = false;

		System.out.println("Choisissez le nom de votre PokeFighter :");

		nom = scann();

		System.out.println("Choisissez le type de "+nom+" entre FEU, EAU ou PLANTE :");

		while(!oktype) {
			nomType = scann();
			if(nomType.equals("FEU")) {
				type = Type.FEU;
				oktype = true;
			} else if(nomType.equals("EAU")) {
				type = Type.EAU;
				oktype = true;
			} else if(nomType.equals("PLANTE")) {
				type = Type.PLANTE;
				oktype = true;
			} else {
				System.out.print("Vous n'avez pas correctement rentré le type !");
			}

		}

		System.out.println("Choisissez le nom de votre premiere capacite :");

		comp1 = scann();

		System.out.println("Choisissez le nom de votre deuxieme capacite :");

		comp2 = scann();

		System.out.println("Choisissez le nom de votre troisieme capacite :");

		comp3 = scann();

		System.out.println("Vous possedez un total de 100 points que vous pouvez associer \n"+
				"aux caracteristiques de votre PokeFighter.");
		while(!okstat) {
			System.out.println("Degats :");	
			var = scann();
			if(var.matches("[0-9]+") && var.length() > 0 && var.length() < 3) {
				puissance = Integer.parseInt(var);
			}

			System.out.println("Vie :");
			var = scann();
			if(var.matches("[0-9]+") && var.length() > 0 && var.length() < 3) {
				vie = Integer.parseInt(var);
			}
			System.out.println("Regeneration :");
			var = scann();
			if(var.matches("[0-9]+") && var.length() > 0 && var.length() < 3) {
				regen = Integer.parseInt(var);
			}
			if((puissance+vie+regen)!=100) {
				System.out.println("Vous n'avez pas correctement assigne vos 100 points.");
			} else {
				okstat = true;
				System.out.print(nom+" est pret à combattre !");
			}
		}


		if(puissance<11) {
			puissance = 10;
		}

		Personnage custom = new Personnage(nom, vie*10, type, comp1, puissance-10, puissance+10, comp2, (int) (regen*2.5), comp3, (int) (regen*2));
		return custom;
	}
}
