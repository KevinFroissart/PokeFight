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

	public static String FileName = "src/ressources/classement.csv";


	public static List<String[]> trie(List<String[]> list) {
		int longueur = list.size();
		String tampon0 = "";
		String tampon1 = "";
		boolean permut;

		do {
			permut = false;
			for (int i = 0; i < longueur - 1; i++) {
				if (Integer.parseInt(list.get(i)[1]) < Integer.parseInt(list.get(i+1)[1])) {
					tampon0 = list.get(i)[0];
					tampon1 = list.get(i)[1];
					list.get(i)[1] = list.get(i+1)[1];
					list.get(i)[0] = list.get(i+1)[0];
					list.get(i+1)[0] = tampon0;
					list.get(i+1)[1] = tampon1;
					permut = true;
				}
			}
		} 
		while (permut);
		return list;
	}

	public static void NewScore(String joueur, String score) throws IOException {
		try
		{
		 FileWriter fw = new FileWriter(FileName,true);
		 fw.write(joueur+","+score+"\n");
		 fw.close();
		}
		catch(IOException ioe)
		{
		 System.err.println("IOException:" + ioe.getMessage());
		}
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
			List<String[]> list = Affichage(",");
			list = trie(list);
			System.out.println("---- CLASSEMENT ----");
			System.out.println();
			int cpt = 0;
			for(int i=0;i<list.size();i++){
				if(cpt < 10) {
				System.out.print((i+1)+" ");
				System.out.print(list.get(i)[0]);
				System.out.print(" : ");
				System.out.print(list.get(i)[1]);
				System.out.println(" points");
				cpt++;
				}
			} 	
			read.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}
}