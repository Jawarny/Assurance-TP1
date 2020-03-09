package Outils;

import java.io.IOException;

public class OutilsFormattage {

	private static int nbLigne = 0;

	public static String formatterChaqueLigne(String ligne) throws IOException {

		String messageErreur = "";
		int espaceAv = 0;
		int espaceAp = 0;
		int espaceEx = 0;

		if (!ligne.contentEquals("")) {
			nbLigne++;

			// DELEAT SPACES extra SPACES
			while (ligne.contains("  ")) {
				ligne = garderUnEspace(ligne);
				espaceEx++;
			}

			// DELEAT SPACES at START
			while (ligne.startsWith(" ")) {
				ligne = ligne.substring(1, ligne.length());
				espaceAv++;
			}

			// DELEAT SPACES at END
			while (ligne.endsWith(" ")) {
				ligne = ligne.substring(0, ligne.length() - 1);
				espaceAp++;
			}

			if (ligne.length() > 1 && (espaceAv > 0 || espaceAp > 0 || espaceEx > 0)) {

				messageErreur += "Erreur corriger dans la ligne numero " + nbLigne + ":\n";
				if (espaceAv > 0) {
					messageErreur += "Espaces avant : " + espaceAv + "\n";
				}
				if (espaceAp > 0) {
					messageErreur += "Espaces apres : " + espaceAp + "\n";
				}
				if (espaceEx > 0) {
					messageErreur += "Espaces de trop : " + espaceEx + "\n";
				}
				OutilsErreur.ajouterErreur(messageErreur + "\n");
			}
		}

		return ligne;
	}

	public static String garderUnEspace(String ligne) {

		ligne = ligne.replaceAll("  ", " ");

		return ligne;
	}

	public static boolean formatFichier(String fichier) throws IOException {

		String messageErreur = OutilsConstante.ERREUR_FICHIER + "\n";

		if (!(fichier.contains(OutilsConstante.LISTE_CLIENT) && fichier.contains(OutilsConstante.LISTE_PLAT)
				&& fichier.contains(OutilsConstante.LISTE_COMMANDE) && fichier.contains(OutilsConstante.LISTE_FIN))) {

			messageErreur += "Il manque la/les ligne(s) suivante(s) :\n";

			if (!fichier.contains(OutilsConstante.LISTE_CLIENT)) {
				messageErreur += "\"" + OutilsConstante.LISTE_CLIENT + "\"" + "\n";
			}

			if (!fichier.contains(OutilsConstante.LISTE_PLAT)) {
				messageErreur += "\"" + OutilsConstante.LISTE_PLAT + "\"" + "\n";
			}

			if (!fichier.contains(OutilsConstante.LISTE_COMMANDE)) {
				messageErreur += "\"" + OutilsConstante.LISTE_COMMANDE + "\"" + "\n";
			}
			if (!fichier.contains(OutilsConstante.LISTE_FIN)) {
				messageErreur += "\"" + OutilsConstante.LISTE_FIN + "\"" + "\n";

			}
			System.out.println(messageErreur + "\n");
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		if (OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_CLIENT) > 1
				|| OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_PLAT) > 1
				|| OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_COMMANDE) > 1
				|| OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_FIN) > 1) {

			messageErreur = "Il y a un ou plusieurs doublons dans la/les ligne(s) suivante(s) :\n";

			int nbOccurence = OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_CLIENT);

			if (nbOccurence > 1) {
				messageErreur += "\"" + OutilsConstante.LISTE_CLIENT + "\" apparait " + nbOccurence + " fois!" + "\n";
			}

			nbOccurence = OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_PLAT);

			if (nbOccurence > 1) {
				messageErreur += "\"" + OutilsConstante.LISTE_PLAT + "\" apparait " + nbOccurence + " fois!" + "\n";
			}

			nbOccurence = OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_COMMANDE);
			if (nbOccurence > 1) {
				messageErreur += "\"" + OutilsConstante.LISTE_COMMANDE + "\" apparait " + nbOccurence + " fois!" + "\n";
			}

			nbOccurence = OutilsTableau.nbValExiste(fichier.split("\n"), OutilsConstante.LISTE_FIN);
			if (nbOccurence > 1) {
				messageErreur += "\"" + OutilsConstante.LISTE_FIN + "\" apparait " + nbOccurence + " fois!" + "\n";
			}

			System.out.println(messageErreur + "\n");
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		if (fichier.contains(OutilsConstante.LISTE_FIN) && !fichier.endsWith(OutilsConstante.LISTE_FIN)) {
			messageErreur = "\"" + OutilsConstante.LISTE_FIN + "\" n'est pas manquant, mais doit être à la " + "fin!\n";

			System.out.println(messageErreur + "\n");
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		return (fichier.contains(OutilsConstante.LISTE_CLIENT) && fichier.contains(OutilsConstante.LISTE_PLAT)
				&& fichier.contains(OutilsConstante.LISTE_COMMANDE) && fichier.endsWith(OutilsConstante.LISTE_FIN));
	}

	public static boolean formatSection(String fichier) throws IOException {
		boolean client = formatClient(fichier);
		boolean plat = formatPlat(fichier);
		boolean commande = formatCommande(fichier);
		return (client && plat && commande);
	}

	public static boolean formatClient(String fichier) throws IOException {

		boolean bonClient = true;

		String messageErreur = OutilsConstante.ERREUR_CLIENT + "\n";

		String[] fichierTab = fichier.split("\n");

		int indA = OutilsTableau.indiceVal(fichierTab, OutilsConstante.LISTE_CLIENT);
		int indB = OutilsTableau.indiceCharContenu(fichierTab, ':', indA + 1);

		if (indB == -1) {
			indB = fichierTab.length - 1;
		}
		String[] clientTab = OutilsTableau.extraitIndAIndB(fichierTab, indA + 1, indB - 1);

		for (int i = 0; i < clientTab.length; i++) {
			if (!clientTab[i].matches(OutilsConstante.PATTERN_NOM_CLIENT)) {

				if (bonClient) {
					System.out.println(messageErreur);
				}
				messageErreur += "Erreur dans le client numero " + (i + 1) + "!\n";
				bonClient = false;
			}
		}

		if (!bonClient) {
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		return (bonClient);
	}

	public static boolean formatPlat(String fichier) throws IOException {

		boolean bonPlat = true;

		String messageErreur = OutilsConstante.ERREUR_PLAT + "\n";

		String[] fichierTab = fichier.split("\n");

		int indA = OutilsTableau.indiceVal(fichierTab, OutilsConstante.LISTE_PLAT);
		int indB = OutilsTableau.indiceCharContenu(fichierTab, ':', indA + 1);

		if (indB == -1) {
			indB = OutilsTableau.indiceVal(fichierTab, OutilsConstante.LISTE_FIN);
		}
		String[] platTab = OutilsTableau.extraitIndAIndB(fichierTab, indA + 1, indB - 1);

		for (int i = 0; i < platTab.length; i++) {
			String[] platLigne = platTab[i].split(" ");
			if (!(platLigne.length == 2 && platLigne[0].matches(OutilsConstante.PATTERN_NOM_PLAT)
					&& (platLigne[1].matches(OutilsConstante.PATTERN_PRIX_PLAT)
							|| platLigne[1].matches(OutilsConstante.PATTERN_PRIX_PLAT01)))) {

				if (bonPlat) {
					System.out.println(messageErreur);
				}
				messageErreur += "Erreur dans le plat numero " + (i + 1) + "!\n";
				bonPlat = false;
			}
		}

		if (!bonPlat) {
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		return (bonPlat);
	}

	public static boolean formatCommande(String fichier) throws IOException {

		boolean bonneCommande = true;

		String messageErreur = OutilsConstante.ERREUR_COMMANDE + "\n";

		String[] fichierTab = fichier.split("\n");

		int indA = OutilsTableau.indiceVal(fichierTab, OutilsConstante.LISTE_COMMANDE);
		int indB = OutilsTableau.indiceCharContenu(fichierTab, ':', indA + 1);

		if (indB == -1) {
			indB = OutilsTableau.indiceVal(fichierTab, OutilsConstante.LISTE_FIN);
		}

		String[] commandeTab = OutilsTableau.extraitIndAIndB(fichierTab, indA + 1, indB - 1);

		for (int i = 0; i < commandeTab.length; i++) {
			String[] commandeLigne = commandeTab[i].split(" ");

			if (!(commandeLigne.length == 3 && commandeLigne[0].matches(OutilsConstante.PATTERN_NOM_CLIENT)
					&& commandeLigne[1].matches(OutilsConstante.PATTERN_NOM_PLAT)
					&& commandeLigne[2].matches(OutilsConstante.PATTERN_QUANTITE_COMMANDE))) {

				if (bonneCommande) {
					System.out.println(messageErreur);
				}
				messageErreur += "Erreur dans la commande numero " + (i + 1) + "!\n";
				bonneCommande = false;
			}
		}

		if (!bonneCommande) {
			OutilsErreur.ajouterErreur(messageErreur + "\n");
		}

		return (bonneCommande);
	}

}
