/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : Principal.java
 * Date    : 16 février 2020
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import Outils.*;
import Restaurant.*;


public class Principal {
	
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_ERREUR, "Il n'y à aucune erreur dans le fichier." );
		
		//System.out.println( OutilsConstante.MESSAGE_BIENVENU );
		String fichier = OutilsFichier.lireFichierSansEntree( OutilsConstante.CHEMIN_FACTURE03 );
		
		if ( !OutilsFormattage.formatFichier( fichier ) ) {
			System.out.println( OutilsConstante.ERREUR_FICHIER );
			OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_ERREUR, OutilsConstante.ERREUR_FICHIER );
		} else {
			
			if ( !OutilsFormattage.formatSection( fichier ) ) {
				System.out.println( OutilsConstante.ERREUR_SECTION );
				OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_ERREUR, OutilsConstante.ERREUR_SECTION );
			} else {
				Restaurant res01 = new Restaurant ( fichier );
				//res01.afficherDetailler();
				
				res01.afficherFacture( OutilsConstante.CHEMIN_SFACTURE03 );
				res01.afficherFichier();
				
				res01.sauvegarderFichierDetailler( OutilsConstante.SAUVEGARDE );
			}
		}
	}
}
