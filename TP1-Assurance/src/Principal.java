
public class Principal {
	
	
	public static void main( String[] args ) {
		// TODO Auto-generated method stub
		
		System.out.println( "Bienvenue chez Barette!\n" );
		
		String[] competencesElias = { "C#", "Java", "Lua" };
		String[] competencesJoseph = { "C#", "Java", "Css" };
		CV EliasJawhari = new CV( "Jawhari", 
				"Elias",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesElias, 
				"Apprendre de nouvel chose qui vont me faire adorer encore plus la programmation et qu'il vont m'être "
				+ "utile dans le futur.");
		
		CV JosephKhalil = new CV( "Khalil", 
				"Joseph",
				"DEC 420-AA Technique d'informatique : Informatique de gestion", 
				2, 
				competencesJoseph, 
				"Je n'ai pas une attente précise par rapport au cours.");
		EliasJawhari.affiche();
		JosephKhalil.affiche();
	}

}
