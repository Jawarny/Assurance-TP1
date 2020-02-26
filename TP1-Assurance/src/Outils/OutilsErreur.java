package Outils;

import java.io.IOException;

public class OutilsErreur {
	
	public static void creerFichierErreur() throws IOException {
		
		OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_ERREUR, OutilsConstante.ERREUR_AUCUNE );
		
	}
	
	public static void ajouterErreur( String erreur ) throws IOException {
		String fichierErreur = OutilsFichier.lireFichier( OutilsConstante.CHEMIN_ERREUR );
		
		if ( fichierErreur.contentEquals( OutilsConstante.ERREUR_AUCUNE ) ) {
			OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_ERREUR, erreur );
		} else {
			OutilsFichier.sauvegarderAFichier( OutilsConstante.CHEMIN_ERREUR, erreur );
		}
	}
}
