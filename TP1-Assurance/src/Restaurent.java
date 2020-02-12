


public class Restaurent {

	private String[] fichier;
	private String[] client;
	private String[] plat;
	private String[] commandes;
	private String[] facture;
	
	public Restaurent(){
		
	}
	
	public Restaurent(	String[] fichier ) {
		
		setFichier( fichier );
		trouverClients( fichier );
		trouverPlats( fichier );
		trouverCommandes( fichier );
		trouverFacture();
		
	}
	
	public void setFichier( String[] fichier ) {
		this.fichier = fichier;
	}
	
	public String[] getFichier() {
		return this.fichier;
	}

	public String[] getClient() {
		return this.client;
	}

	public String[] getPlat() {
		return this.plat;
	}

	public String[] getCommandes() {
		return this.commandes;
	}
	
	public String[] getFacture() {
		return this.facture;
	}
	
	public String[] trouverClients(String[] fichier ) {
		
		if ( OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_CLIENT ) && 
				OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_PLAT )) {
			this.client = OutilsTableau.extraitIndAIndB( fichier, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_CLIENT ) + 1, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_PLAT ) - 1 ) ;
		}
		
		return fichier;
		
	}
	
	private String[] trouverPlats(String[] fichier ) {
		
		if ( OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_PLAT ) && 
				OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_COMMANDES )) {
			this.plat = OutilsTableau.extraitIndAIndB( fichier, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_PLAT  ) + 1, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_COMMANDES ) - 1 ) ;
		}
		return fichier;
	}
	
	private String[] trouverCommandes(String[] fichier ) {

		if ( OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_COMMANDES )) {
			this.commandes = OutilsTableau.extraitIndAIndB( fichier, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_COMMANDES ) + 1, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_FIN ) - 1 ) ;
		}
		
		return fichier;
	}
	
	private void trouverFacture() {
		String[] facture = this.client.clone();
		double[] prix = new double[this.client.length];
		
		
			
		for ( int indiceCommande = 0; indiceCommande < this.commandes.length; indiceCommande++ ) {
			String[] commande = this.commandes[indiceCommande].split( " " );
			int platTrouve = -1;
			int clientTrouve = -1;
			
			clientTrouve = OutilsTableau.indiceVal( this.client, commande[0] + " " );
			
			for ( int indicePlat = 0; indicePlat < this.plat.length && platTrouve == -1; indicePlat++ ) {
				String[] plat = this.plat[indicePlat].split( " " );
				if ( plat[0].equals( commande[1] ) ) {
					platTrouve = indicePlat;
				}
			}
			
			String[] plat = this.plat[platTrouve].split( " " );
			prix[clientTrouve] += (Double.parseDouble(plat[1]) * Double.parseDouble(commande[2]));
			
		}
		
		for ( int i = 0; i < facture.length; i++ ) {
			facture[i] += String.format("%.2f", prix[i]) + "$";
		}
		
		this.facture = facture;
	}
	
	
	
	public void afficher() {
		
		afficherClients();
		afficherPlat();
		afficherCommande();
	}	
	
	public void afficherClients() {
		System.out.println( OutilsConstante.LISTE_CLIENT );
		System.out.println(OutilsTableau.toStringEnter(getClient()) +"\n");
	}
	
	public void afficherPlat() {
		System.out.println( OutilsConstante.LISTE_PLAT );
		System.out.println( OutilsTableau.toStringEnter(getPlat()) + "\n" );
	}
	
	public void afficherCommande() {
		System.out.println( OutilsConstante.LISTE_COMMANDES );
		System.out.println(OutilsTableau.toStringEnter(getCommandes()) + "\n");
	}
	
	public void afficherFacture() {
		System.out.println( "Factures:" );
		System.out.println(OutilsTableau.toStringEnter(getFacture()) + "\n");
	}
	
}
