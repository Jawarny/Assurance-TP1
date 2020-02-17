/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : Plat.java
 * Date    : 16 février 2020
 */


public class Plat {
	
	private String nom;
	private double prix;
	
	Plat(){
		this("", 0);
	}
	
	Plat( String plat ){
		this(plat.substring( 0, plat.indexOf( " " ) ),
				Double.parseDouble(plat.substring( plat.indexOf( " " ) + 1, plat.length())));
	}
	
	Plat(String nom, double prix){
		setNom(nom);
		setPrix(prix);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getNom () {
		return this.nom;
	}
	
	public double getPrix () {
		return this.prix;
	}
	
	public void afficherPlat() {
		System.out.println( "Nom du plat :\t" + getNom() );
		System.out.println( "Prix du plat :\t" + String.format("%.2f", getPrix()) + "$" );
		System.out.println(  );
	}
}
