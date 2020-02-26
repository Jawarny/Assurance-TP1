package Outils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Auteurs : Elias Jawhari et Khalil Joseph
 * Fichier : OutilsConstante.java
 * Date    : 16 février 2020
 */

public class OutilsConstante {
	
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd-HH_mm");
	private static Date date = new Date();
	
	public static final String SAUVEGARDE_DETAILLER = "src\\ressources\\save\\style_detailler.txt";
	public static final String SAUVEGARDE_CORRIGE = "src\\ressources\\save\\style_Corriger.txt";
	
	public static final String MESSAGE_BIENVENU = "Bienvenue chez Barette!\n";
	
	public static final String ERREUR_AUCUNE = "Il n'y a aucune erreur dans le fichier.";
	public static final String ERREUR_FICHIER = "Le fichier ne respecte pas le format demandé :";
	public static final String ERREUR_SECTION = "Erreur dans la section : ";
	
	public static final String ERREUR_CLIENT = OutilsConstante.ERREUR_SECTION + " \"" + OutilsConstante.LISTE_CLIENT 
												+  "\"\n" +"*Le nom d'un client peut seulement contenir des lettres!*";
	
	public static final String ERREUR_PLAT = OutilsConstante.ERREUR_SECTION + " \"" + OutilsConstante.LISTE_PLAT 
												+  "\"\n" + "*Il doit y avoir seulement le nem du plat et le prix "
												+ "separer d'un espace!*";
	
	public static final String ERREUR_COMMANDE = OutilsConstante.ERREUR_SECTION + " \"" 
												+ OutilsConstante.LISTE_COMMANDE 
												+  "\"\n" + "*Il doit y avoir le nom d'un client, le nom du plat et "
												+ "la quantité commander séparer d'espace!*";
	
	public static final String ERREUR_COMMANDES = "Erreur de commande :";
	
	public static final String PATTERN_NOM_CLIENT = "[A-zÀ-ú]+";
	public static final String PATTERN_NOM_PLAT = ".+";
	public static final String PATTERN_PRIX_PLAT = "[0-9]+.[0-9]{1,2}";
	public static final String PATTERN_PRIX_PLAT01 = "[0-9]+";
	public static final String PATTERN_QUANTITE_COMMANDE = "[0-9]+";
	
	public static final String CHEMIN_ERREUR = "src\\ressources\\save\\erreur.txt";

	public static final String CHEMIN_SFACTURE = "src\\ressources\\save\\Facture-du-" 
													+ dateFormat.format(date) + ".txt";

	public static final String CHEMIN_FACTURE = "src\\ressources\\style.txt";
	
	public static final String LISTE_CLIENT = "Clients :";
	public static final String LISTE_PLAT = "Plats :";
	public static final String LISTE_COMMANDE = "Commandes :";
	public static final String LISTE_FACTURE = "Facture :";
	public static final String LISTE_FIN = "Fin";
	
}
