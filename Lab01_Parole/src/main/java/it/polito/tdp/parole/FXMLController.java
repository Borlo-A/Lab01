package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML // fx:id="txtTime"
    private TextArea txtTime; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) 
    {
    	long start = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	txtResult.setText(elenco.getElenco().toString());
    	txtParola.setText(null);
    	btnReset.setDisable(false);
    	btnCancel.setDisable(false);
    	txtResult.setDisable(false);
    	txtTime.setDisable(false);
    	long end = System.nanoTime();
    	long tempo = end-start;
    	txtTime.setText("Tempo di esecuzione: " + tempo + " ns");
    }

    @FXML
    void doReset(ActionEvent event) 
    {
    	long start = System.nanoTime();
    	elenco.reset();
    	txtResult.setText(null);
    	txtParola.setText(null);
    	btnReset.setDisable(true);
    	btnCancel.setDisable(true);
    	txtResult.setDisable(true);
    	txtTime.setText(null);
    	long end = System.nanoTime();
    	long tempo = end-start;
    	txtTime.setText("Tempo di esecuzione: " + tempo + " ns");
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	boolean flag=false;
    	long start = System.nanoTime();
    	for (int i=0; i<elenco.getElenco().size(); i++)
    	{
    		if (txtParola.getText().compareToIgnoreCase(elenco.getElenco().get(i))==0)
    		{
    			elenco.getElenco().remove(i);
    			txtResult.setText(elenco.getElenco().toString());
    			i=-1;
    			flag = true;
    		}
    	}
    	if (flag==true)
    		txtParola.setText(null);
    	long end = System.nanoTime();
    	long tempo = end-start;
    	txtTime.setText("Tempo di esecuzione: " + tempo + " ns");
    }
    
    
    @Override
	public String toString() {
		return elenco  + "\n" ;
	}

	@FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";


        elenco = new Parole() ;
    }
}
