/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : Factured.java
 * Date    : 16 février 2020
 */
public class Facture {
	
	double total;
	
	Facture(){
		this(0);
	}
	
	Facture(double total){
		setTotal(total);
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	public double getTotal() {
		return this.total;
	}
}
