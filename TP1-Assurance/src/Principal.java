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
		OutilsErreur.creerFichierErreur();
		
		//System.out.println( OutilsConstante.MESSAGE_BIENVENU );
		String fichier = OutilsFichier.lireFichierSansEntree( OutilsConstante.CHEMIN_FACTURE );
		
		if ( OutilsFormattage.formatFichier( fichier ) ) {
			OutilsFichier.sauvegarderFichier( OutilsConstante.SAUVEGARDE_CORRIGE, fichier );
			
			if ( OutilsFormattage.formatSection( fichier ) ) {
				Restaurant res01 = new Restaurant ( fichier );
				
				res01.afficherFacture( OutilsConstante.CHEMIN_SFACTURE );
				res01.sauvegarderFichierDetailler( OutilsConstante.SAUVEGARDE_DETAILLER );
			}
		}
	}
}
