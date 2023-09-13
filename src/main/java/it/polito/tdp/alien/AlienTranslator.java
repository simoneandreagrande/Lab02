package it.polito.tdp.alien;

import java.util.*;

public class AlienTranslator {

	private Map<String, List<String>> dictionary;

	public AlienTranslator() {
		dictionary = new HashMap<>();
	}

	public void aggiungiParola(String parolaAliena, String traduzione) {
		String key = parolaAliena.toLowerCase();
	    List<String> traduzioni = dictionary.get(key);
        if (traduzioni == null) {
            traduzioni = new ArrayList<>();
            dictionary.put(key, traduzioni);
        } else if (traduzioni.contains(traduzione)) {
        	return;
        }
        traduzioni.add(traduzione);
		return;
	}


	
	public List<String> cercaTraduzione(String parolaAliena) {
        String key = parolaAliena.toLowerCase();
        List<String> traduzioni = dictionary.get(key);
        if (traduzioni == null) {
            traduzioni = Collections.emptyList();
            return null;
        }
        
        // Search for wildcard
        int wildcardIndex = key.indexOf('?');
        if (wildcardIndex != -1) {
            String prefix = key.substring(0, wildcardIndex);
            String suffix = key.substring(wildcardIndex + 1);
            List<String> results = new ArrayList<>();
            for (String k : dictionary.keySet()) {
                if (k.length() != key.length()) {
                    continue;
                }
                if (k.startsWith(prefix) && k.endsWith(suffix)) {
                    results.addAll(dictionary.get(k));
                }
            }
            return results;
        }
        
        return traduzioni;
    }
//	public String cercaTraduzione(String parolaAliena) {
//		List<String> translations = dictionary.get(alienWord);
//        if (translations == null) {
//            translations = Collections.emptyList();
//        }
//        return translations;
//		String traduzione = dictionary.get(parolaAliena.toLowerCase());
//		if (traduzione != null) {
//			return traduzione;
//		} else {
//			return null;
//		}
//
//	}
	
	
	
//	public boolean stampaTraduzioni(String parolaAliena) {
//	    String key = parolaAliena.toLowerCase();
//	    List<String> traduzioni = dictionary.get(key);
//	    if (traduzioni == null || traduzioni.isEmpty()) {
//	        System.out.println("Nessuna traduzione trovata per la parola aliena " + parolaAliena + ".");
//	        return true;
//	    } else {
//	        System.out.println("Traduzioni per la parola aliena " + parolaAliena + ": " + traduzioni.toString().replaceAll("[\\[\\]]", ""));
//	        return false;
//	    }
//	}

	public Map<String, List<String>> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, List<String>> dictionary) {
		this.dictionary = dictionary;
	}

	@Override
	public String toString() {
		return "AlienTranslator [dictionary=" + dictionary + "]";
	}

	

	

}
