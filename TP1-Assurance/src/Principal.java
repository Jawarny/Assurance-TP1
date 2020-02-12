


import java.io.FileNotFoundException;
import java.io.IOException;


public class Principal {
	
	
	public static void main( String[] args ) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println( "Bienvenue chez Barette!\n" );
		
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
		
		String[] fichier = OutilsFichier.lireFichier( OutilsConstante.CHEMIN_FACTURE );
		
		
		Restaurent restaurent01 = new Restaurent( fichier );
		
		restaurent01.afficherFacture();
	}
	
	

}
