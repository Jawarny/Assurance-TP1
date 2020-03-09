import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import Outils.OutilsFichier;
import Outils.OutilsFormattage;
import Restaurant.Restaurant;

public class PrincipalTest {

	@Test
	public void test() throws IOException {

		// Vide.
		System.out.println( "1:Vide." );
		assertEquals( false, OutilsFormattage.formatFichier( "" ) );

		// Les 4 existes avec le même ordre.
		System.out.println( "2:Les 4 existes avec le même ordre." );
		assertEquals( true, OutilsFormattage.formatFichier( "Clients :\nPlats :\nCommandes :\nFin" ) );

		// Les 4 existe avec un ordre différent.
		System.out.println( "3:Les 4 existe avec un ordre différent." );
		assertEquals( true, OutilsFormattage.formatFichier( "Clients :\nCommandes :\nPlats :\nFin" ) );

		// Les 4 existe avec un doublon.
		System.out.println( "4:Les 4 existe avec un doublon." );
		assertEquals( false, OutilsFormattage.formatFichier( "Clients :\nClients :\nPlats :\nCommandes :\nFin" ) );
		// Les 4 existe avec des doublons.
		System.out.println( "5:Les 4 existe avec des doublons." );
		assertEquals( false,
				OutilsFormattage.formatFichier( "Clients :\nClients :\nPlats :\nPlats :\n" + "Commandes :\nFin" ) );

		// Manque "Clients :"
		System.out.println( "6:Manque \"Clients :\"" );
		assertEquals( false, OutilsFormattage.formatFichier( "Plats :\nCommandes :\nFin" ) );
		// Manque "Clients :" et "Plats :"
		System.out.println( "7:Manque \"Clients :\" et \"Plats :\"" );
		assertEquals( false, OutilsFormattage.formatFichier( "Commandes :\nFin" ) );

		// Manque "Clients :" avec un doublon.
		System.out.println( "8:Manque \"Clients :\" avec un doublon." );
		assertEquals( false, OutilsFormattage.formatFichier( "Plats :\nPlats :\nCommandes :\nFin" ) );
		// Manque "Clients :" et "Plats :" avec des doublons.
		System.out.println( "9:Manque \"Clients :\" et \"Plats :\" avec des doublons." );
		assertEquals( false, OutilsFormattage.formatFichier( "Commandes :\nCommandes :\nFin\nFin" ) );

		// Fin n'est pas a la fin.
		System.out.println( "10:Fin n'est pas a la fin." );
		assertEquals( false, OutilsFormattage.formatFichier( "Clients :\nPlats :\nFin\nCommandes :" ) );

		// Pas d'espace de trop ni d'enter de trop.
		System.out.println( "11:Pas d'espace de trop ni d'enter de trop." );
		assertEquals( "Clients :", OutilsFormattage.formatterChaqueLigne( "Clients :" ) );

		// Espaces d'espace de trop avant, apres, entre et des enters de trop.
		System.out.println( "12:Espaces d'espace de trop pas d'enter de trop." );
		assertEquals( "Clients :", OutilsFormattage.formatterChaqueLigne( "   Clients   :   " ) );

		// bonne liste de client.
		System.out.println( "13:bonne liste de client." );
		assertEquals( true, OutilsFormattage.formatClient( "Clients :\nStouf\nElias\nJoseph\nFin" ) );

		// Erreur dans stouf (chiffre) erreur dans elias (espace).
		System.out.println( "14:Erreur dans stouf (chiffre) erreur dans elias (espace)." );
		assertEquals( false, OutilsFormattage.formatClient( "Clients :\nStouf09\nEli as\nJoseph\nFin" ) );

		// bonne liste de Plat.
		System.out.println( "15:bonne liste de Plat." );
		assertEquals( true, OutilsFormattage
				.formatPlat( "Plats :\n" + "Poutine 10.5\n" + "Frites 2.50\n" + "Repas_Poulet 15\nFin" ) );
		// erreur dans la liste des plats.
		System.out.println( "16:Erreur dans la liste des plats (respecte pas le format), "
				+ "(trop d'espace) et (string a la place d'un chiffre)." );
		assertEquals( false, OutilsFormattage
				.formatPlat( "Plats :\n" + "Poutine 10.\n" + "Frit es 2.50\n" + "Repas_Poulet aa\nFin" ) );

		// bonne liste de Plat.
		System.out.println( "17:bonne liste de Plat." );
		assertEquals( true, OutilsFormattage.formatCommande(
				"Commandes :\n" + "Roger Poutine 1\n" + "Céline Frites 2\n" + "Céline Repas_Poulet 1\n" + "Fin" ) );
		// erreur dans la liste des plats.
		System.out.println( "18:Erreur dans la liste des commandes (respecte pas le format), "
				+ "(trop d'espace), (nom et plat coller) et (string a la place d'un chiffre)." );
		assertEquals( false, OutilsFormattage.formatCommande( "Commandes :\n" + "Rog5er Poutine 1\n"
				+ "Céline Fr ites 2\n" + "Céline Repas_Poulet a\n" + "CélineRepas_Poulet 2\n" + "Fin" ) );
		
		System.out.println( "19:Test sans erreur!" );
		assertEquals(  true, OutilsFormattage.formatSection( "Clients :\n" + 
																"Roger\n" + 
																"Céline\n" + 
																"Steeve\n" + 
																"Plats :\n" + 
																"Poutine 10.5\n" + 
																"Frites 2.5\n" + 
																"Repas_Poulet 15.75\n" + 
																"Commandes :\n" + 
																"Roger Poutine 1\n" + 
																"Céline Frites 2\n" + 
																"Céline Repas_Poulet 1\n" + 
																"Fin" ) );
		
		
		System.out.println( "20:Test avec erreur dans chaque section!" );
		assertEquals(  false, OutilsFormattage.formatSection( "Clients :\n" + 
																"Roger\n" + 
																"Céline\n" + 
																"Steeve\n" + 
																"Plats :\n" + 
																"Poutine 10.\n" + 
																"Frites 2.5\n" + 
																"Repas_Poulet 15.75\n" + 
																"Commandes :\n" + 
																"RogerPoutine 1\n" + 
																"Céline Frites 2\n" + 
																"Céline Repas_Poulet 1\n" + 
																"Fin" ) );
		
		assertEquals(  "Test", OutilsFichier.lireFichierSansEntree("src\\ressources\\TestUnitaire.txt"));

	}
	
	

}
