package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Diese Klasse implementiert die Funktionen um die angefahrenen und
 * ausgeführten Befehle zu notieren und speichern zu können. Außerdem gibt sie
 * die Möglichkeit den Log zu exportieren
 *
 * @author Jannik Orth
 * 
 */
public class Logging {

	private Long timeStart;
	private ObservableList<String> log = FXCollections.observableArrayList();

	public void addToLog(String logEvent) {
		log.add(logEvent);
	}

	/*
	 * Neue File erstellen und diese mit dem gefüllten Log exportieren als json
	 */
	public void exportLog() throws IOException {

		JSONArray outArray = new JSONArray();

		for (int i = 0; i < log.size(); i++) {
			outArray.add(log.get(i));
		}
		JSONObject out = new JSONObject();
		out.put("logging", outArray);

		try {

			// Writing to a file
			File file = new File("log.json");
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(out.toJSONString());
			fileWriter.flush();
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Zeitmessung zum anzeigen im Log
	 */
	public void zeitStarten() {
		timeStart = System.currentTimeMillis();
	}

	public String zeitGebraucht() {
		long temp = System.currentTimeMillis();
		temp = temp - timeStart;
		Double tempSekunden = (double) (temp / 1000);
		return Double.toString(tempSekunden) + "s";
	}

	/*
	 * Log erneueren und löschen, wenn Befehle hinzukommen, oder ein anderes
	 * Programm gestartet wird
	 */
	public void refreshLog(SampleController sc) {
		sc.logList.getItems().clear();
		sc.logList.getItems().addAll(log);
	}

	public void clearLogs(SampleController sc) {
		log.clear();
		sc.logList.getItems().clear();
	}
}
