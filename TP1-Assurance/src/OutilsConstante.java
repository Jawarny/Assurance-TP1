/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : OutilsConstante.java
 * Date    : 16 février 2020
 */


public class OutilsConstante {
	
	public static final String SAUVEGARDE = "src\\ressources\\save\\Save.txt";
	
	public static final String MESSAGE_BIENVENU = "Bienvenue chez Barette!\n";
	
	public static final String ERREUR_FICHIER = "Le fichier ne respecte pas le format demandé !";
	public static final String ERREUR_SECTION = "Une ou plusieurs des sections ne respecte pas le format demandé !";
	
	public static final String ERREUR_CLIENT = "Erreur! Un client peut seulement avoir des lettres dans son nom!";
	public static final String ERREUR_PLAT = "Erreur de format dans le plat numéro ";
	public static final String ERREUR_COMMANDE = "Erreur de format dans la commande numéro ";
	
	public static final String PATTERN_NOM_CLIENT = "[A-zÀ-ú]+";
	public static final String PATTERN_NOM_PLAT = ".+";
	public static final String PATTERN_PRIX_PLAT = "[0-9]+.[0-9]{1,2}";
	public static final String PATTERN_PRIX_PLAT01 = "[0-9]+";
	public static final String PATTERN_QUANTITE_COMMANDE = "[0-9]+";
	
	public static final String CHEMIN_ERREUR = "src\\ressources\\save\\erreur.txt";
	
	public static final String CHEMIN_SFACTURE03 = "src\\ressources\\save\\facture03.txt";
	public static final String CHEMIN_SFACTURE02 = "src\\ressources\\save\\facture02.txt";
	public static final String CHEMIN_SFACTURE01 = "src\\ressources\\save\\facture01.txt";
	public static final String CHEMIN_SFACTURE = "src\\ressources\\save\\facture.txt";
	
	public static final String CHEMIN_FACTURE03 = "src\\ressources\\style03.txt";
	public static final String CHEMIN_FACTURE02 = "src\\ressources\\style02.txt";
	public static final String CHEMIN_FACTURE01 = "src\\ressources\\style01.txt";
	public static final String CHEMIN_FACTURE = "src\\ressources\\style.txt";
	
	public static final String LISTE_CLIENT = "Clients :";
	public static final String LISTE_PLAT = "Plats :";
	public static final String LISTE_COMMANDE = "Commandes :";
	public static final String LISTE_FACTURE = "Facture :";
	public static final String LISTE_FIN = "Fin";
	
}
