package application;


import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Logging {
	
	private ArrayList<String> log = new ArrayList<>(); 
	private Long timeStart;
	private ObservableList<String> teStrings = FXCollections.observableArrayList();

	
	public void addToLog(String logEvent) {
		log.add(logEvent);
		teStrings.add(logEvent);
	}
	
	
	public void exportLog() {
		//Export Logging to Jsonfile
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
		sc.logList.getItems().addAll(teStrings);
	}
}
