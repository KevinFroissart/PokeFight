package pokefight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Score {
	
	public static String FileName = "ressources/classement.csv";
	
	/*public static void NewScore(String joueur, String score) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(FileName))
		BufferedReader read = new BufferedReader(new FileReader(FileName));
		List<String[]> list = new ArrayList<>();
        String line = "";
        while((line = reader.readLine()) != null){
            String[] array = line.split(separator);
            list.add(array);
        }
		BufferedWriter classement = new BufferedWriter(new FileWriter(FileName));
		int compteur = 0;
		while (read.readLine() != null) {
			 compteur++;
		}
		read.close();

		classement.append(joueur);
		classement.append(",");
		classement.append(score);
		classement.append("\n");
		
		classement.flush();
		classement.close();

	}
	*/
	public static List<String[]> Affichage(String separator) {
	    try (BufferedReader reader = new BufferedReader(new FileReader(FileName))){
	        List<String[]> list = new ArrayList<>();
	        String line = "";
	        while((line = reader.readLine()) != null){
	            String[] array = line.split(separator);
	            list.add(array);
	        }
	        return list;
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }  
	}

	public static void main(String args[]) throws IOException {

		BufferedReader read;
		//NewScore("Test1", "40");

		try {
			read = new BufferedReader(new FileReader(FileName));
			List<String[]> list = Affichage(",");
			 for(int i=0;i<list.size();i++){
				    System.out.print(list.get(i)[0]);
				    System.out.print(" : ");
				    System.out.print(list.get(i)[1]);
				    System.out.println(" points");
				} 			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}