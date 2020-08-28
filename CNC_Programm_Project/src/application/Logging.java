package application;

import com.google.gson.Gson;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *Diese Klasse implementiert die Funktionen um die angefahrenen und ausgeführten
 *Befehle zu notieren und speichern zu können.
 *
 * @author Jannik Orth
 */
public class Logging {
	
	private Long timeStart;
	private ObservableList<String> log = FXCollections.observableArrayList();

	
	public void addToLog(String logEvent) {
		log.add(logEvent);
	}
	
	
	public String exportLog() {
		Gson gson = new Gson();
	    StringBuilder sb = new StringBuilder();
	    
	    for (int j = 0; j < log.size(); j++) {
	    	sb.append(gson.toJson(log.get(j)));
		}
	    
	    String output = sb.toString();
	    System.out.println(output);
	    return output;
	}
	
	public void zeitStarten(){
		timeStart = System.currentTimeMillis();
	}
	
	public String zeitGebraucht(){
		long temp = System.currentTimeMillis();
		temp = temp - timeStart;
		Double tempSekunden = (double) (temp/1000);
		return Double.toString(tempSekunden) + "s";
	}

	public void refreshLog(SampleController sc) {
		sc.logList.getItems().clear();
		sc.logList.getItems().addAll(log);
	}
	
	public void clearLogs(SampleController sc) {
		log.clear();
		sc.logList.getItems().clear();
	}
}
