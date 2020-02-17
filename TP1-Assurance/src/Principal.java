/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : Principal.java
 * Date    : 16 février 2020
 */

import java.io.FileNotFoundException;
import java.io.IOException;


public class Principal {
	
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println( OutilsConstante.MESSAGE_BIENVENU );
		String fichier = OutilsFichier.lireFichier( OutilsConstante.CHEMIN_FACTURE02 );
		
		if ( !OutilsFichier.fichierRestaurent( fichier ) ) {
			System.out.println( OutilsConstante.ERREUR_FICHIER );
			OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_SFACTURE02, OutilsConstante.ERREUR_FICHIER );
		} else {
			Restaurent res01 = new Restaurent ( fichier );
			res01.afficherFacture( OutilsConstante.CHEMIN_SFACTURE02 );
		}
		
		String[] competencesElias = { "C#", "Java", "Lua" };
		String[] competencesJoseph = { "C#", "Java", "Css" };
//		CV EliasJawhari = 
				new CV( "Jawhari", 
				"Elias",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesElias, 
				"Apprendre de nouvel chose qui vont me faire adorer encore plus la programmation et qu'il vont m'être "
				+ "utile dans le futur");
		
//		CV JosephKhalil = 
				new CV( "Khalil", 
				"Joseph",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesJoseph, 
				"Je n'ai pas une attente précise par rapport au cours");
		
//		CV yasserSoliman = new CV();
//		yasserSoliman.initialiseCV();
//		
//		EliasJawhari.affiche();
//		JosephKhalil.affiche();
//		yasserSoliman.affiche();
		
		
	}
	
	

}
