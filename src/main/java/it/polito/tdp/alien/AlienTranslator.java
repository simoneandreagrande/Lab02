package it.polito.tdp.alien;

import java.util.HashMap;
import java.util.Map.Entry;

public class AlienTranslator {

	private HashMap<String, String> dictionary;

	public AlienTranslator() {
		dictionary = new HashMap<String, String>();
	}

	public void aggiungiParola(String parolaAliena, String traduzione) {
		dictionary.put(parolaAliena.toLowerCase(), traduzione.toLowerCase());
		return;
	}


	public String cercaTraduzione(String parolaAliena) {
		String traduzione = dictionary.get(parolaAliena.toLowerCase());
		if (traduzione != null) {
			return traduzione;
		} else {
			return null;
		}

	}


	public HashMap<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(HashMap<String, String> dictionary) {
		this.dictionary = dictionary;
	}

}
