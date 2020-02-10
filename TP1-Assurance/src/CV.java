
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
		
		System.out.println( "Nom : \t\t\t\t" + this.nom );
		System.out.println( "Prénom : \t\t\t" + this.prenom );
		System.out.println( "Formation : \t\t\t" + this.formation );
		System.out.println( "Expériance de travail : \t" + this.nbAnneeTravail );
		System.out.println( "Compétences : \t\t\t" + afficherCompetences(this.competences) );
		System.out.println( "Attentes : \t\t\t" + this.attentes );
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
