package model;

import java.util.ArrayList;

public class Info {

	public static ArrayList<String> brukernavn = new ArrayList<String>();
	public static ArrayList<String> navn = new ArrayList<String>();
	public static ArrayList<String> epost = new ArrayList<String>();
	public static ArrayList<String> passord = new ArrayList<String>();
	
	public static ArrayList<String> konkurranser = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> konkurranseInformasjon = new ArrayList<ArrayList<String>>();
	
	public static ArrayList<String> maaleapparater = new ArrayList<String>();
	public static ArrayList<Boolean> tilkobledeMaaleapparater = new ArrayList<Boolean>();
	
	public static ArrayList<String> lagNavn = new ArrayList<String>();
	public static ArrayList<ArrayList<String>> lagListe = new ArrayList<ArrayList<String>>();
	
	public static String valgtKonkurranse = null;
	public static String bruker = null;
	public static String konkurranse = null;
	
	public static boolean erPaaLag() {
		for (ArrayList<String> lag : lagListe) {
			if (lag.contains(bruker)) {
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<String> brukersLag(String annenBruker) {
		for (ArrayList<String> lag : lagListe) {
			if (lag.contains(annenBruker)) {
				return lag;
			}
		}
		return null;
	}
	
	public static ArrayList<String> brukersLag() {
		for (ArrayList<String> lag : lagListe) {
			if (lag.contains(bruker)) {
				return lag;
			}
		}
		return null;
	}
	
	public static void fjernFraLag(String lagkamerat) {
		brukersLag(lagkamerat).remove(lagkamerat);
	}
	
	public static void fjernFraLag() {
		if (brukersLag() != null) {
			brukersLag().remove(bruker);
		}
	}
	
	public static void loggUt() {
		bruker = null;
	}
	
	public static void slettBruker() {
		fjernFraLag();
		int index = brukernavn.indexOf(bruker);
		brukernavn.remove(index);
		navn.remove(index);
		passord.remove(index);
		epost.remove(index);
		bruker = null;
	}
	
	public static void slettLag() {
		int index = lagListe.indexOf(brukersLag());
		lagListe.remove(index);
		lagNavn.remove(index);
	}
	
	public static String hentPassord() {
		return passord.get(brukernavn.indexOf(bruker));
	}
	
	public static String hentNavn() {
		return navn.get(brukernavn.indexOf(bruker));
	}
	
	public static String hentEpost() {
		return epost.get(brukernavn.indexOf(bruker));
	}
	
}
