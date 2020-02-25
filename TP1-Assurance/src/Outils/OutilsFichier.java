package Outils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class OutilsFichier {

	public static void sauvegarderFichier(String chemin, String newFichier) throws IOException {

		try (BufferedWriter ecrire = new BufferedWriter(new FileWriter(chemin))) {
			ecrire.write(newFichier);
			ecrire.close();
		}
	}

	public static String lireFichierSansEntree(String chemin) throws IOException {

		String chaqueLigne = "";
		int ligneVide = 0;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF8"))) {
			String ligne;

			while ((ligne = br.readLine()) != null) {
				ligne = OutilsFormattage.formatterChaqueLigne( ligne );
				
				if ( !(ligne.contentEquals("") || ligne.contentEquals(" ")) ) {
					if (chaqueLigne.contentEquals("")) {
						chaqueLigne += ligne;
					} else {
						chaqueLigne += "\n" + ligne;
					}
				} else {
					ligneVide++;
				}
			}
			
			if ( ligneVide > 0  ) {
				sauvegarderAFichier( OutilsConstante.CHEMIN_ERREUR , "Il y à " + ligneVide 
																	+ " ligne vide  dans le fichier!\n");
			}
			
		}
		return chaqueLigne;
	}
	
	public static String lireFichier(String chemin) throws IOException {

		String chaqueLigne = "";
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF8"))) {
			String ligne;

			while ((ligne = br.readLine()) != null) {
				ligne = OutilsFormattage.formatterChaqueLigne( ligne );
				
				if (chaqueLigne.contentEquals("")) {
					chaqueLigne += ligne;
				} else {
					chaqueLigne += "\n" + ligne;
				}
			}
		}
		return chaqueLigne;
	}
	
	public static void sauvegarderAFichier(String chemin, String newFichier) throws IOException {
		
		String fichier = lireFichier( chemin );
		
		try (BufferedWriter ecrire = new BufferedWriter(new FileWriter(chemin))) {
			ecrire.write(fichier + "\n" + newFichier);
			ecrire.close();
		}
	}
}
