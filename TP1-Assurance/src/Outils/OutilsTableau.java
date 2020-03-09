package Outils;

import Restaurant.*;

public class OutilsTableau {
	
	public static int dernierIndice( String[] tabVal ) {

		return tabVal.length - 1;
	}
	
	public static boolean indiceExiste( String[] tabVal, int indice ) {

		return ( tabVal.length > 0 && indice >= 0 && indice <= dernierIndice( tabVal ) );
	}
	
	public static String[] fusionnerTableau( String[] tableau, String element ) {

		return fusionnerTableau( tableau, new String[] { element } );
	}
	
	public static String[] fusionnerTableau(String[] tabA, String[] tabB) {
		
		String[] tab = new String[tabA.length + tabB.length];
		
		for ( int i = 0; i < tab.length; i++ ) {
			if ( i < tabA.length ) {
				tab[i] = tabA[i];
			} else {
				tab[i] = tabB[i - tabA.length];
			}
		}
		return tab;
	}
	
	
	public static Commande[] fusionnerTableau( Commande[] tableau, Commande element ) {

		return fusionnerTableau( tableau, new Commande[] { element } );
	}
	
	public static Commande[] fusionnerTableau(Commande[] tabA, Commande[] tabB) {
		
		Commande[] tab = new Commande[tabA.length + tabB.length];
		
		for ( int i = 0; i < tab.length; i++ ) {
			if ( i < tabA.length ) {
				tab[i] = tabA[i];
			} else {
				tab[i] = tabB[i - tabA.length];
			}
		}
		return tab;
	}
	
	public static Plat[] fusionnerTableau( Plat[] tableau, Plat element ) {

		return fusionnerTableau( tableau, new Plat[] { element } );
	}
	
	public static Plat[] fusionnerTableau(Plat[] tabA, Plat[] tabB) {
		
		Plat[] tab = new Plat[tabA.length + tabB.length];
		
		for ( int i = 0; i < tab.length; i++ ) {
			if ( i < tabA.length ) {
				tab[i] = tabA[i];
			} else {
				tab[i] = tabB[i - tabA.length];
			}
		}
		return tab;
	}
	
	public static Client[] fusionnerTableau( Client[] tableau, Client element ) {

		return fusionnerTableau( tableau, new Client[] { element } );
	}
	
	public static Client[] fusionnerTableau(Client[] tabA, Client[] tabB) {
		
		Client[] tab = new Client[tabA.length + tabB.length];
		
		for ( int i = 0; i < tab.length; i++ ) {
			if ( i < tabA.length ) {
				tab[i] = tabA[i];
			} else {
				tab[i] = tabB[i - tabA.length];
			}
		}
		return tab;
	}
	
	
	public static boolean valExiste( String[] tabVal, String val ) {

		boolean existe = false;

		for ( int i = 0; i < tabVal.length && !existe; i++ ) {
			existe = tabVal[i].equals( val );
		}
		return existe;
	}
	
	public static int nbValExiste( String[] tabVal, String val ) {

		int existe = 0;

		for ( int i = 0; i < tabVal.length; i++ ) {
			if (tabVal[i].contentEquals(val)) {
				existe ++;
			}
			
		}
		return existe;
	}
	
	public static int indiceVal( String[] tabVal, String val ) {

		int indice = -1;

		for ( int i = 0; i < tabVal.length && indice == -1; i++ ) {

			if ( tabVal[i].equals( val ) ) {
				indice = i;
			}
		}
		return indice;
	}
	

	public static int indiceCharContenu( String[] tabVal, char caractere, int indiceDebut ) {

		int indice = -1;

		for ( int i = indiceDebut; i < tabVal.length && indice == -1; i++ ) {

			if ( tabVal[i].indexOf( caractere ) != -1 ) {
				indice = i;
			}
		}
		return indice;
	}
	

	public static String[] extraitIndAIndB( String[] tabVal, int indiceA, int indiceB ) {

		String[] tabExtrait = {};

		if ( indiceExiste( tabVal, indiceA ) && indiceExiste( tabVal, indiceB ) && indiceA < indiceB ) {
			tabExtrait = new String[indiceB - indiceA + 1];

			for ( int i = 0; i < tabExtrait.length; i++ ) {
				tabExtrait[i] = tabVal[indiceA + i];
			}
		}
		return tabExtrait;
	}
	
	public static String toStringEnter( String[] tabVal ) {

		String chaine = "";

		for ( int i = 0; i < tabVal.length; i++ ) {

			if ( i == dernierIndice( tabVal ) ) {
				chaine += tabVal[i];
			} else {
				chaine += tabVal[i] + "\n";
			}
		}
		return chaine;
	}

}
