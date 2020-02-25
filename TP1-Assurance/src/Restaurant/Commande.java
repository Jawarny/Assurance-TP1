package Restaurant;

public class Commande {

	private Client client;
	private Plat plat;
	private int quantite;
	
	Commande(){
		this(new Client(), new Plat(), 0);
	}
	
	Commande(Client client, Plat plat, int quantite ){
		setClient(client);
		setPlat(plat);
		setQuantite(quantite);
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	public Client getClient () {
		return this.client;
	}
	
	public Plat getPlat () {
		return this.plat;
	}
	
	public int getQuantite () {
		return this.quantite;
	}
	

	public void afficherCommande() {
		System.out.println( "Nom du client :\t" + getClient().getNom());
		System.out.println( "Nom du plat :\t" + getPlat().getNom() );
		System.out.println( "Quantité(s) :\t" + getQuantite() );
		System.out.println(  );
		
	}
	
}
