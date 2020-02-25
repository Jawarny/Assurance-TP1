package Restaurant;

public class Client {
	private String nom;
	private Facture facture;
	
	Client(){
		this("", new Facture());
	}
	
	Client(String nom, Facture facture){
		setNom(nom);
		setFacture(facture);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	public String getNom () {
		return this.nom;
	}
	
	public Facture getFacture() {
		return this.facture;
	}
	
	public void afficherClient() {
		System.out.println( "Nom du Client :\t" + getNom() );
	}
	
	public void afficherFacture() {
		System.out.println( "Nom du Client :\t" + getNom() );
		System.out.println( "Total à payer :\t" + getFacture().getTotal() + "$" );
	}
	
}
