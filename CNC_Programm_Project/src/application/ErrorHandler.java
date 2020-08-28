package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Jannik Orth
 */
public class ErrorHandler {

	public void firstDeleteCommands() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du musst zuerst alle bisher eingegebenen Commands löschen.");

		alert.showAndWait();
	}

	public void firstReadSettings() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du musst zuerst eine Einstellungsdatei einlesen.");

		alert.showAndWait();
	}

	public void firstReadCommands() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du musst zuerst Commands einlesen oder manuell eingeben.");

		alert.showAndWait();
	}

	public void firstReadSettingsCommands() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du musst zuerst Commands einlesen oder manuell eingeben und eine Einstellungsdatei laden.");

		alert.showAndWait();
	}

	public void firstStartProcess() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du musst zuerst den Prozess Starten um pausieren oder stoppen zu können.");

		alert.showAndWait();
	}

	public void youStoppedProcess() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Du hast den Prozess bereits gestoppt.");

		alert.showAndWait();
	}
	
	public void thereIsNoLog() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Achtung!");
		alert.setHeaderText(null);
		alert.setContentText("Es existiert noch kein Log.");

		alert.showAndWait();
		
	}
}
