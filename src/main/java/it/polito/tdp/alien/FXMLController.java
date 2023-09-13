/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
//	AlienTranslator model;
	public AlienTranslator translator = new AlienTranslator();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnClearText"
    private Button btnClearText; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtCom"
    private Label txtCom; // Value injected by FXMLLoader

    @FXML // fx:id="txtDizionario"
    private TextArea txtDizionario; // Value injected by FXMLLoader

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader
    
    @FXML // fx:id="btnVediDiz"
    private Button btnVediDiz; // Value injected by FXMLLoader

    @FXML
    void doClearText(ActionEvent event) {
    	txtDizionario.clear();
    	txtParola.clear();

    }
    
    @FXML
    void stampaDizionario(ActionEvent event) {
    	txtCom.setText("");
    	txtDizionario.clear();
    	for (Entry<String, List<String>> entry : translator.getDictionary().entrySet()) {
    	    String parolaAliena = entry.getKey();
    	    List<String> traduzione = entry.getValue();
    	    txtDizionario.appendText(parolaAliena + ": " + traduzione.toString() + "\n");
    	}
    	
  
    }

    @FXML
    void usaTranslate(ActionEvent event) {
    	txtDizionario.clear();
        String[] parole = txtParola.getText().split(" ");
        if (parole.length == 2) {
            String parolaAliena = parole[0].toLowerCase();
            String traduzione = parole[1].toLowerCase();
            if (parolaAliena.matches("[a-zA-Z]+") && traduzione.matches("[a-zA-Z]+")) {
                translator.aggiungiParola(parolaAliena, traduzione);
                txtCom.setText("Parola aggiunta al dizionario!");
                txtParola.clear();
            } else {
            	txtCom.setText("Le parole devono contenere solo lettere alfabetiche");
            }
        } else if (parole.length == 1) {
            String parolaAliena = parole[0].toLowerCase();
            if (parolaAliena.matches("[a-zA-Z]+")) {
                List<String> traduzione = translator.cercaTraduzione(parolaAliena);
//              translator.stampaTraduzioni(String parolaAliena);
                if (traduzione == null) {
                	txtCom.setText("Parola non trovata nel dizionario");
                } else {
                	txtCom.setText("Parola trovata con successo!");
                    txtDizionario.setText("Traduzione di '" + parolaAliena + "': " + traduzione);
                	txtParola.clear();
                }
            } else {
                txtCom.setText("La parola deve contenere solo lettere alfabetiche");
            }
        } else {
            txtCom.setText("Inserisci una parola o una coppia di parole separata da uno spazio");
        }
        
        txtParola.clear();

    }
    
    
    

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnClearText != null : "fx:id=\"btnClearText\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCom != null : "fx:id=\"txtCom\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtDizionario != null : "fx:id=\"txtDizionario\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}
