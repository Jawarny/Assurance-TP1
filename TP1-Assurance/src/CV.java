
import java.util.Scanner;

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
		
		setNom(nom);
		setPrenom(prenom);
		setFormation(formation);
		setNbAnneeTravail(nbAnneeTravail);
		setCompetences(competences);
		setAttentes(attentes);
	}
	
	public void initialiseCV() {
		 Scanner reponse = new Scanner(System.in);
		
		 System.out.print( "Entrez votre nom : ");
		 setNom(reponse.nextLine()); 
		 System.out.println();
		 
		 System.out.print( "Entrez votre prénom : ");
		 setPrenom(reponse.nextLine()); 
		 System.out.println();
		 
		 System.out.print( "Entrez votre formation : ");
		 setFormation(reponse.nextLine()); 
		 System.out.println();
		 
		 System.out.print( "Entrez votre nombre d'année d'expérience de travail : ");
		 setNbAnneeTravail(Integer.parseInt(reponse.nextLine()));
		 System.out.println();
		 
		 System.out.print( "Entrez vos compétences (séparer avec des espaces) : ");
		 setCompetences(reponse.nextLine()); 
		 System.out.println();
		 
		 System.out.print( "Quel sont vos attentes vis à vis le cours 4B4 : ");
		 setAttentes(reponse.nextLine()); 
		 System.out.println();
		 
		 reponse.close();
	} 
	
	public void setNom( String nom ) {
		this.nom = nom;
	}

	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}

	public void setFormation( String formation ) {
		this.formation = formation;
	}

	public void setNbAnneeTravail( int nbAnneeTravail ) {
		this.nbAnneeTravail = nbAnneeTravail;
	}

	public void setCompetences(String competances ) {

		this.competences = competances.split( " " ); 
	}
	
	public void setCompetences(String[] competances ) {

		this.competences = competances; 
	}

	public void setAttentes( String attentes ) {
		this.attentes = attentes;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getFormation() {
		return this.formation;
	}

	public int getNbAnneeTravail() {
		return this.nbAnneeTravail;
	}

	public String[] getCompetences() {
		return this.competences;
	}

	public String getAttentes() {
		return this.attentes;
	}
	
	
	public void affiche() {
		
		System.out.println( "Nom : \t\t\t\t\t" + this.nom + "," );
		System.out.println( "Prénom : \t\t\t\t" + this.prenom + ".");
		System.out.println( "Formation : \t\t\t\t" + this.formation + "." );
		System.out.println( "Expériance de travail : \t\t" + this.nbAnneeTravail + " an(s)." );
		System.out.println( "Compétences : \t\t\t\t" + afficherCompetences(this.competences) );
		System.out.println( "Attentes vis à vis le cours 4B4 : \t" + this.attentes + ".");
		System.out.println( "\n" );
	}
	
	private static String afficherCompetences( String[] competences ) {
		String chaineCompetances = "";
		
		for ( int i = 0; i < competences.length; i++ ) {
			
			if ( i == competences.length - 1 ) {
				
				chaineCompetances += competences[i] + ".";
			} else {
				
				chaineCompetances += competences[i] + ", ";
			}
		}
		return chaineCompetances;
	}
}
