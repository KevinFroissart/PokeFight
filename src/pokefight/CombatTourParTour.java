package pokefight;
import java.util.Random;
import java.util.Scanner;

public class CombatTourParTour {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        Random rand = new Random();
     
        
        //variable joueur
        int vie = 10000000;
        int attaqueMax = 20;
        
        //variable boss
        
        String [] bosses = { "pikachou","salamouche","herbizoure","carapouce"};
        int vieBoss = 100;
        int attaqueMaxBoss = 15;
        
        boolean running = true;

        System.out.println("Vous rentrez en combat !");
        
        while (running){
        	
        	System.out.println("-------------------------------------------------------");
        	
        	String boss = bosses [rand.nextInt(bosses.length)];
        	System.out.println("\t# ATTENTION ! Un " + boss + " est apparu ! #\n");
        	
        	 while (vieBoss >0){

                 System.out.println("\t Votre vie : " + vie);
                 System.out.println("\t Le " + boss + " a "+ vieBoss +" point de vie");
                 System.out.println("\n\t quelle action ? ");
                 System.out.println("\t1. Attaquer");
                 System.out.println("\t2. Abandonner");
                 System.out.println("----------------------------------------------------------------\n");
                 
                 String clavier = sc.nextLine();

                 if(clavier.equals("1")){
                	 int dommagePerso = rand.nextInt(attaqueMax);
                     int dommageBoss = rand.nextInt(attaqueMaxBoss);

                     vieBoss-= dommagePerso;
                     vie-= dommageBoss;
                     
                     System.out.println("----------------------------------------------------------------\n");
                     System.out.println("\t> vous frapper " + boss +" et causez "+ dommagePerso + " dmg");
                     System.out.println("\t> " + boss +" riposte et vous cause " +  dommageBoss +" dmg\n");
                 }
                 
                 else if(clavier.equals("2")){
                	 System.out.println("Vous abandonnez le combat.");
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
