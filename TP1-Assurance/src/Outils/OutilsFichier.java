package Outils;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class OutilsFichier {

	
	public static String lireFichierSansEntree(String chemin) throws IOException {

		String chaqueLigne = "";
		int ligneVide = 0;
		try (BufferedReader lire = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF8"))) {
			String ligne;

			while ((ligne = lire.readLine()) != null) {
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
				sauvegarderAFichier( OutilsConstante.CHEMIN_ERREUR , "Il y avait " + ligneVide 
																	+ " ligne vide dans le fichier qui ont ete "
																	+ "retirer!\n\n");
			}
		}
		return chaqueLigne;
	}
	
	public static String lireFichier(String chemin) throws IOException {

		String chaqueLigne = "";
		try (BufferedReader lire = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF8"))) {
			String ligne;

			while ((ligne = lire.readLine()) != null) {
				
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
		
		try (OutputStreamWriter ecrire =
	             new OutputStreamWriter(new FileOutputStream(chemin), StandardCharsets.UTF_8)) {
			ecrire.write(fichier + "\n" + newFichier);
			ecrire.close();
		}
	}
	
	public static void sauvegarderFichier(String chemin, String newFichier) throws IOException {
		
		try (OutputStreamWriter ecrire =
	             new OutputStreamWriter(new FileOutputStream(chemin), StandardCharsets.UTF_8)) {
			ecrire.write(newFichier);
			ecrire.close();
		}
		
	}

}
