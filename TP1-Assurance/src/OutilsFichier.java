/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : OutilsFichier.java
 * Date    : 16 février 2020
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class OutilsFichier {
	
	public static void sauvegarderFichier( String chemin, String facture ) throws IOException {

		try (BufferedWriter ecrire = new BufferedWriter( new FileWriter( chemin ) ) ) {
			ecrire.write( facture );
			ecrire.close();
		}
	}

	public static String lireFichier( String chemin ) throws IOException {
		
		String chaqueLigne = "";
		try (BufferedReader br = new BufferedReader( new InputStreamReader( new FileInputStream(chemin), "UTF8") ) ) {
			String ligne;

			while ( ( ligne = br.readLine() ) != null  ) {
				if ( !ligne.contentEquals( "" ) ) {
					
					if ( ligne.endsWith( " " ) ) {
						ligne = ligne.substring( 0, ligne.length() - 1 );
					}
					if ( chaqueLigne.contentEquals( "" ) ) {
						chaqueLigne += ligne;
					} else {
						chaqueLigne += "\n" + ligne;
					}
				}
			}
		} 
		return chaqueLigne;
	}
	
	public static boolean fichierRestaurent(String fichier ) {
		return (fichier.contains(OutilsConstante.LISTE_CLIENT) && 
				fichier.contains(OutilsConstante.LISTE_PLAT) && 
				fichier.contains(OutilsConstante.LISTE_COMMANDE) && 
				fichier.endsWith(OutilsConstante.LISTE_FIN) );
	}
}
