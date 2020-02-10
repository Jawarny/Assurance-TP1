
public class CV {
	
	private String nom;
	private String prenom;
	private String formation;
	private int nbAnneeTravail;
	private String[] competences;
	private String attentes;
	
	public CV() {
		this( "", "", "", 0, new String[]{""}, "");
	}
	
	public CV(	String nom, String prenom, 
				String formation, int nbAnneeTravail, 
				String[] competences, String attentes) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.formation = formation;
		this.nbAnneeTravail = nbAnneeTravail;
		this.competences = competences;
		this.attentes = attentes;
	}
	
	
	
	public void affiche() {
		
		System.out.println( this.nom );
		System.out.println( this.prenom );
		System.out.println( this.formation );
		System.out.println( this.nbAnneeTravail );
		System.out.println( afficherCompetences(this.competences) );
		System.out.println( this.attentes );
		System.out.println( "\n" );
	}
	
	public static String afficherCompetences( String[] competences ) {
		String chaineCompetances = "";
		
		for ( int i = 0; i < competences.length; i++ ) {
			
			if ( i == competences.length - 1 ) {
				
				chaineCompetances += competences[i];
			} else {
				
				chaineCompetances += competences[i] + ",";
			}
		}
		return chaineCompetances;
	}
}
