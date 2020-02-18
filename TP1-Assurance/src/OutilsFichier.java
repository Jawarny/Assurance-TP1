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
					
					//DELEAT SPACES extra SPACES
					while ( ligne.contains( "  " ) ) {
						ligne = garderUnEspace( ligne );
					}
					
					//DELEAT SPACES at END
					while ( ligne.endsWith( " " ) ) {
						ligne = ligne.substring( 0, ligne.length() - 1 );
					}
					//DELEAT SPACES at START
					while ( ligne.startsWith( " " ) ) {
						ligne = ligne.substring( 1, ligne.length());
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
	
	public static String garderUnEspace( String ligne ) {
		
		ligne = ligne.replaceAll( "  ", " " );
		
		return ligne;
	}
	
	public static boolean formatFichier(String fichier ) {
		return (fichier.contains(OutilsConstante.LISTE_CLIENT) && 
				fichier.contains(OutilsConstante.LISTE_PLAT) && 
				fichier.contains(OutilsConstante.LISTE_COMMANDE) && 
				fichier.endsWith(OutilsConstante.LISTE_FIN) );
	}
	public static boolean formatSection( String fichier ) {
		boolean client = formatClient( fichier );
		boolean plat = formatPlat( fichier );
		boolean commande = formatCommande( fichier );
		return ( client && plat && commande );
	}
	
	public static boolean formatClient(String fichier ) {
		
		boolean bonClient = true;
		
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_CLIENT );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = fichierTab.length - 1;
		}
		String[] clientTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		for (int i = 0; i < clientTab.length ; i++) {
			if ( !clientTab[i].matches( OutilsConstante.PATTERN_NOM_CLIENT ) ) {
				System.out.println( OutilsConstante.ERREUR_CLIENT);
				bonClient = false;
			}
		}
		return (bonClient);
	}
	
	public static boolean formatPlat(String fichier ) {
		
		boolean bonPlat = true;
		
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_PLAT );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_FIN );
		}
		String[] platTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		for (int i = 0; i < platTab.length ; i++) {
			String[] platLigne = platTab[i].split( " " );
			if ( platLigne.length == 2  && 
					platLigne[0].matches( OutilsConstante.PATTERN_NOM_PLAT ) && 
					(platLigne[1].matches( OutilsConstante.PATTERN_PRIX_PLAT  ) || 
					platLigne[1].matches( OutilsConstante.PATTERN_PRIX_PLAT01 ))) {
			} else {
				System.out.println(  OutilsConstante.ERREUR_PLAT + (i + 1) + "!" );
				bonPlat = false;
			}
		}
		
		return (bonPlat);
	}

	public static boolean formatCommande(String fichier ) {
		
		boolean bonneCommande = true;
		
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_COMMANDE );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_FIN );
		}
		
		String[] commandeTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		for (int i = 0; i < commandeTab.length ; i++) {
			String[] commandeLigne = commandeTab[i].split( " " );
			if ( commandeLigne.length == 3  && 
					commandeLigne[0].matches( OutilsConstante.PATTERN_NOM_CLIENT ) && 
					commandeLigne[1].matches( OutilsConstante.PATTERN_NOM_PLAT  ) && 
					commandeLigne[2].matches( OutilsConstante.PATTERN_QUANTITE_COMMANDE  )) {
				
			} else {
				System.out.println( OutilsConstante.ERREUR_COMMANDE + (i + 1) + "!" );
				bonneCommande = false;
			}
		}
		return (bonneCommande);
	}
}
