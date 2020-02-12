

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class OutilsFichier {
	
	public static void sauvegarderFichier( String chemin, String facture ) throws IOException {

		try (BufferedWriter ecrire = new BufferedWriter( new FileWriter( chemin ) ) ) {
			ecrire.write( facture );
			ecrire.close();
		}
	}

	public static String[] lireFichier( String chemin ) throws IOException {
		
		String[] chaqueLigne = {};
		// new InputStreamReader (new FileInputStream(""), "UTF-8"));
		try (BufferedReader br = new BufferedReader( new FileReader( chemin ) ) ) {
			String ligne;

			while ( ( ligne = br.readLine() ) != null ) {
				chaqueLigne = OutilsTableau.fusionnerTableau( chaqueLigne, ligne );
			}
		} 
		return chaqueLigne;
	}
}
