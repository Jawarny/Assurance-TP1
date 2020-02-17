/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : Restaurent.java
 * Date    : 16 février 2020
 */

import java.io.IOException;

public class Restaurent {

	private String fichier;
	private Client[] clients = {};
	private Plat[] plats = {};
	private Commande[] commandes = {};
	
	public Restaurent(){
		
	}
	
	public Restaurent(	String fichier ) {
		
		setFichier( fichier );
		trouverClients( fichier );
		trouverPlats( fichier );
		trouverCommandes( fichier );
		trouverFacture();
		
	}
	
	public void setFichier( String fichier ) {
		this.fichier = fichier;
	}
	
	public String getFichier() {
		return this.fichier;
	}

	public Client[] getClient() {
		return this.clients;
	}

	public Plat[] getPlat() {
		return this.plats;
	}

	public Commande[] getCommandes() {
		return this.commandes;
	}
	
//	public String[] getFacture() {
//		return this.facture;
//	}
	
	public void trouverClients( String fichier ) {
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_CLIENT );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = fichierTab.length - 1;
		}
		String[] clientTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		for ( int i = 0; i < clientTab.length; i++ ) {
			this.clients = OutilsTableau.fusionnerTableau( this.clients, new Client(clientTab[i], new Facture()) );
		}
	}
	
	private void trouverPlats(String fichier ) {
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_PLAT );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_FIN );
		}
		String[] platTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		for ( int i = 0; i < platTab.length; i++ ) {
			this.plats = OutilsTableau.fusionnerTableau( this.plats, new Plat(platTab[i]) );
		}
	}
	
	private void trouverCommandes(String fichier ) {
		
		String[]fichierTab = fichier.split( "\n" );
		
		int indA = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_COMMANDE );
		int indB = OutilsTableau.indiceCharContenu( fichierTab, ':', indA + 1);
		
		if ( indB == -1 ) {
			indB = OutilsTableau.indiceVal( fichierTab, OutilsConstante.LISTE_FIN );
		}
		
		String[] commandeTab = OutilsTableau.extraitIndAIndB( fichierTab,  indA + 1,  indB - 1);
		
		
		for ( int i = 0; i < commandeTab.length; i++ ) {
			
			Client clientTemp = new Client();
			Plat platTemp = new Plat();
			
			int quantite = 0; 
			
			String[]uneCommande = commandeTab[i].split( " " );
			
			for ( int j = 0; j < getClient().length && clientTemp.getNom().contentEquals( "" ); j++ ) {
				
				if ( getClient()[j].getNom().contentEquals( uneCommande[0] ) ) {
					clientTemp = getClient()[j];
				}
			}
			
			for ( int j = 0; j < getPlat().length && platTemp.getNom().contentEquals( "" ) ; j++ ) {
				if ( getPlat()[j].getNom().contentEquals( uneCommande[1] ) ) {
					platTemp = getPlat()[j];
				}
			}
			
			quantite = Integer.parseInt( uneCommande[2] );
			
			
			this.commandes = OutilsTableau.fusionnerTableau( this.commandes, 
					new Commande(clientTemp, platTemp, quantite) );
		}
	}
	
	private void trouverFacture() {
			
		for ( int indiceCommande = 0; indiceCommande < getCommandes().length; indiceCommande++ ) {
			
			getCommandes()[indiceCommande].getClient().setFacture( 
					new Facture( getCommandes()[indiceCommande].getClient().getFacture().getTotal() 
					+ (getCommandes()[indiceCommande].getQuantite() 
					* getCommandes()[indiceCommande].getPlat().getPrix()) ));
		}
	}
	
	public void afficherFichier() {
		System.out.println( "\nLe fichier style.txt :");
		System.out.println(getFichier() + "\n" );
	}
	
	public void afficherClients() {
		System.out.println( OutilsConstante.LISTE_CLIENT );
		for ( int i = 0; i < getClient().length; i++ ) {
			if ( i == getClient().length - 1 ) {
				System.out.println( getClient()[i].getNom() + "\n" );
			} else {
				System.out.println( getClient()[i].getNom() );
			}
		}
	}
	
	public void afficherPlats() {
		System.out.println( OutilsConstante.LISTE_PLAT );
		for ( int i = 0; i < getPlat().length; i++ ) {
			if ( i == getPlat().length - 1 ) {
				System.out.println( getPlat()[i].getNom() + " " 
									+  String.format("%.2f", getPlat()[i].getPrix()) + "$\n" );
			} else {
				System.out.println( getPlat()[i].getNom() + " " 
									+  String.format("%.2f", getPlat()[i].getPrix()) + "$" );
			}
		}
	}
	
	public void afficherCommandes() {
		
		System.out.println( OutilsConstante.LISTE_COMMANDE );
		
		for ( int i = 0; i < getCommandes().length; i++ ) {
			
			if ( i == getCommandes().length - 1 ) {
				
				System.out.println( getCommandes()[i].getClient().getNom() + " " 
									+  getCommandes()[i].getPlat().getNom() + " " 
									+  getCommandes()[i].getQuantite() + "\n" );
			} else {
				System.out.println( getCommandes()[i].getClient().getNom() + " " 
									+  getCommandes()[i].getPlat().getNom() + " " 
									+  getCommandes()[i].getQuantite() );
			}
		}
	}
	
	public void afficherFacture( String chemin ) throws IOException {
		
		String facture = OutilsConstante.MESSAGE_BIENVENU;
		facture += OutilsConstante.LISTE_FACTURE + "\n";
		for ( int i = 0; i < getClient().length; i++ ) {
			if ( i == getClient().length - 1 ) {
				facture += getClient()[i].getNom() + " " 
									+ String.format("%.2f", getClient()[i].getFacture().getTotal()) + "$";
			} else {
				facture += getClient()[i].getNom() + " " 
									+ String.format("%.2f", getClient()[i].getFacture().getTotal()) + "$\n";
			}
		}
		System.out.println( facture );
		OutilsFichier.sauvegarderFichier( chemin, facture );
	}
	
	public void afficherClientsDetailler() {
		System.out.println( OutilsConstante.LISTE_CLIENT );
		for ( int i = 0; i < getClient().length; i++ ) {
			getClient()[i].afficherClient();
		}
		System.out.println(  );
	}
	
	public void afficherPlatsDetailler() {
		System.out.println( OutilsConstante.LISTE_PLAT );
		for ( int i = 0; i < getPlat().length; i++ ) {
			getPlat()[i].afficherPlat();
		}
		System.out.println(  );
	}
	
	public void afficherCommandesDetailler() {
		
		System.out.println( OutilsConstante.LISTE_COMMANDE );
		
		for ( int i = 0; i < getCommandes().length; i++ ) {
			getCommandes()[i].afficherCommande();
		}
		System.out.println(  );
	}
	
	public void afficherTout() {
		
		afficherClients();
		afficherPlats();
		afficherCommandes();
	}
	
	public void afficherDetailler() {
		
		afficherClientsDetailler();
		afficherPlatsDetailler();
		afficherCommandesDetailler();
	}	
	
	
//	public void afficherFacture() {
//		System.out.println( "Factures:" );
//		System.out.println(OutilsTableau.toStringEnter(getFacture()) + "\n");
//	}
	
}
