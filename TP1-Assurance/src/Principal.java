import java.io.FileNotFoundException;
import java.io.IOException;


public class Principal {
	
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		//System.out.println( OutilsConstante.MESSAGE_BIENVENU );
		String fichier = OutilsFichier.lireFichier( OutilsConstante.CHEMIN_FACTURE );
		
		if ( !OutilsFichier.fichierRestaurent( fichier ) ) {
			System.out.println( OutilsConstante.ERREUR_FICHIER );
			OutilsFichier.sauvegarderFichier( OutilsConstante.CHEMIN_SFACTURE, OutilsConstante.ERREUR_FICHIER );
		} else {
			Restaurent res01 = new Restaurent ( fichier );
			res01.afficherFacture( OutilsConstante.CHEMIN_SFACTURE );
		}
		
		String[] competencesElias = { "C#", "Java", "Lua" };
		String[] competencesJoseph = { "C#", "Java", "Css" };
//		CV EliasJawhari = 
				new CV( "Jawhari", 
				"Elias",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesElias, 
				"Apprendre de nouvel chose qui vont me faire adorer encore plus la programmation et qu'il vont m'�tre "
				+ "utile dans le futur");
		
//		CV JosephKhalil = 
				new CV( "Khalil", 
				"Joseph",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesJoseph, 
				"Je n'ai pas une attente pr�cise par rapport au cours");
		
//		CV yasserSoliman = new CV();
//		yasserSoliman.initialiseCV();
//		
//		EliasJawhari.affiche();
//		JosephKhalil.affiche();
//		yasserSoliman.affiche();
		
		
	}
	
	

}
