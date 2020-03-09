package Restaurant;

public class Facture {
	
	double sousTotal;
	double grandTotal;
	

	Facture(){
		this(0);
	}
	
	Facture(double total){
		setTotal(total);
		setGrandTotal();
	}
	
	public void setTotal(double total) {
		this.sousTotal = total;
	}
	
	
	public double getTotal() {
		return this.sousTotal;
	}
	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal( ) {
		this.grandTotal = Double.parseDouble( String.format("%.2f", getTotal() * 1.14975) );
	}
}
