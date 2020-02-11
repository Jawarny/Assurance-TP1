import ressources.OutilsTableau;

public class Restaurent {

	private String[] fichier;
	private String[] client;
	private String[] plat;
	private String[] commandes;
	
	public Restaurent(){
		
	}
	
	public Restaurent(	String[] fichier ) {
		
		setFichier( fichier );
		trouverClient( fichier );
		trouverPlat( fichier );
		trouverCommandes( fichier );
		
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
	
	public String[] trouverClient(String[] fichier ) {
		
		if ( OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_CLIENT ) && 
				OutilsTableau.valExiste( fichier, OutilsConstante.LISTE_PLAT )) {
			this.client = OutilsTableau.extraitIndAIndB( fichier, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_CLIENT ) + 1, 
											OutilsTableau.indiceVal( fichier, OutilsConstante.LISTE_PLAT ) - 1 ) ;
		}
		
		return fichier;
		
	}
	
	private String[] trouverPlat(String[] fichier ) {
		
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
	
	
	
	
}
