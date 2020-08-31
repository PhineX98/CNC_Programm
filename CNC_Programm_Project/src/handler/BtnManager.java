package handler;

import java.io.IOException;

import application.SampleController;
import javafx.scene.paint.Color;
import logging.Logging;

/**
 * Diese Klasse überprüft in welchem Zustand sich die Simulation befindet
 *
 * Hierüber kann geprüft werden ob der Nutzer bestimmte Tätigkeiten bereits
 * gemacht hat um zu beispielsweise zu schauen, ob man das Programm stoppen
 * kann, oder ein Log File exportierbar ist
 * 
 * Übernimmt auch die Farbauswahl
 * 
 * @author Jannik Orth
 */
public class BtnManager {

	private boolean settingsSet = false;
	private boolean commandsSet = false;
	private boolean commandListSet = false;
	private boolean processStarted = false;
	private boolean processPaused = false;
	private boolean processStopped = false;
	private boolean logDeleted = true;

	////////////////////////////////
	// Getter um aktuellen Status abfragen zu können
	public boolean getSettingsSet() {
		return settingsSet;
	}

	public boolean getCommandsSet() {
		return commandsSet;
	}

	public boolean getCommandListSet() {
		return commandListSet;
	}

	public boolean getProcessStarted() {
		return processStarted;
	}

	public boolean getProcessPaused() {
		return processPaused;
	}

	public boolean getProcessStopped() {
		return processStopped;
	}

	public boolean getLoggingDeleted() {
		return logDeleted;
	}

	/*
	 * Aktuellen Status setzen wenn Button betätigt werden
	 * User über die Aktionen in der Statusbar informieren
	 */
	public void settingsInitialized(SampleController sc) {
		sc.lblInfo.setText("Einstellungen geladen.");
		settingsSet = true;
	}

	public void commandListInitialized(SampleController sc) {
		sc.lblInfo.setText("Commandliste geladen.");
		commandListSet = true;
		logDeleted = false;
	}

	public void commandAdded(SampleController sc) {
		sc.lblInfo.setText("Command hinzugefügt.");
		commandsSet = true;
	}

	public void commandDeleted(SampleController sc) {
		sc.lblInfo.setText("Alle eingegebenen Commands gelöscht.");
		commandsSet = false;
		commandListSet = false;
	}

	public void startProcess(SampleController sc) {
		sc.lblInfo.setText("Prozess gestartet.");
		processStarted = true;
		processPaused = false;
		processStopped = false;
		logDeleted = false;
	}

	public void pauseProcess(SampleController sc) {
		sc.lblInfo.setText("Prozess pausiert.");
		processStarted = false;
		processPaused = true;
		processStopped = false;
	}

	public void stopProcess(SampleController sc) {
		sc.lblInfo.setText("Prozess gestoppt.");
		processStarted = false;
		processPaused = false;
		processStopped = true;
	}

	public void logDelete(SampleController sc, Logging logger) {
		sc.lblInfo.setText("Log gelöscht.");
		logDeleted = true;
		logger.clearLogs(sc);
	}

	public void exportLog(SampleController sc, Logging logger) throws IOException {
		sc.lblInfo.setText("Log wurde exportiert");
		logger.exportLog();
	}
	

	/*
	 * Umwandlung von eingestellter Farbe in eine annehmbare Farbe
	 */
	public Color colorHandler(String string) {
		switch (string) {
		case "grey":
			return Color.GRAY;
		case "green":
			return Color.LIGHTGREEN;
		case "red":
			return Color.RED;
		case "blue":
			return Color.BLUE;
		case "yellow":
			return Color.YELLOW;
		case "black":
			return Color.BLACK;
		case "purple":
			return Color.PURPLE;
		case "white":
			return Color.WHITE;
		default:
			return Color.BLACK;
		}

	}

}
