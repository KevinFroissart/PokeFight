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
	
	public static void NewScore(String joueur, String score) throws IOException {
		BufferedWriter classement = new BufferedWriter(new FileWriter(FileName));
		BufferedReader read = new BufferedReader(new FileReader(FileName));
		int compteur = 0;
		while (read.readLine() != null) {
			 compteur++;
		}
		read.close();
		classement.write(joueur);
		classement.write(";");
		classement.write(score);
		classement.write("\n");
		/*classement.append("test2");
		classement.append(";");
		classement.append("54");
		classement.append("\n");*/
		classement.flush();
		classement.close();

	}
	
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
		try {
			read = new BufferedReader(new FileReader(FileName));
			int compteur = 0;
			while (read.readLine() != null) {
				 compteur++;
				 System.out.println(compteur);
			}
			read.close();
			List<String> list = Affichage(",");
			 System.out.println(compteur);
			 for(int i=0;i<Affichage(",").size();i++){
				    System.out.println(list.get(i));
				} 			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}