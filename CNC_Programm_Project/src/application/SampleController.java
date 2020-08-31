package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fileParser.CommandCode;
import fileParser.ParseHandler;
import gCode.G00;
import gCode.G01;
import gCode.G02;
import gCode.G03;
import gCode.G28;
import handler.BtnManager;
import handler.ErrorHandler;
import handler.Tester;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import komponenten.Fraeser;
import komponenten.Spindel;
import logging.Logging;
import mCode.M00;
import mCode.M02;
import mCode.M03;
import mCode.M04;
import mCode.M05;
import mCode.M08;
import mCode.M09;
import mCode.M13;
import mCode.M14;


/**
 * Dies ist die ControllerKlasse der Anwendung Von hier aus werden alle Button
 * Events gesteuert
 * 
 * @author Jannik Orth
 */

public class SampleController implements Initializable {
	
	//Status Lables
	public Label statX;
	public Label statY;
	public Label statCooling;
	public Label statDirection;
	public Label statFraeser;
	public Label statSpeed;

	//Einstellungsanzeige
	public Label lblHomePos;
	public Label lblSpeedCooling;
	public Label lblSpeedNoCooling;
	public Label lblSpeedNoDrill;
	public Label lblDrillDiameter;
	public Label lblInfo;

	//Eingabefelder
	public TextField field_Befehl;
	public TextField field_Pos;
	public TextField field_x;
	public TextField field_y;
	public TextField field_i;
	public TextField field_j;

	//Anzeige der Animation
	public Rectangle drillSurface;
	public Circle circHomePosition;
	public Circle circDrill;
	public Path path;
	public Color drillColor;
	public Pane drawPane;
	
	//Logging
	public ListView<String> logList;
	public Logging logger = new Logging();
	
	//Andere
	public int iterator = 0;
	public BtnManager btnManager = new BtnManager();
	public ErrorHandler errorHandler = new ErrorHandler();
	public ArrayList<CommandCode> commands = new ArrayList<>();
	ArrayList<CommandCode> tempCommands = new ArrayList<>();
	public Fraeser fraeser = new Fraeser();
	Spindel spindel = new Spindel();
	Tester tester = new Tester();

	//Overlay zug�ngig machen
	public static SampleController sc;

	////////////////////////////////////////
	// Handlers
	M00 handleM00 = new M00();
	M02 handleM02 = new M02();
	M03 handleM03 = new M03();
	M04 handleM04 = new M04();
	M05 handleM05 = new M05();
	M08 handleM08 = new M08();
	M09 handleM09 = new M09();
	M13 handleM13 = new M13();
	M14 handleM14 = new M14();
	G00 handleG00 = new G00();
	G01 handleG01 = new G01();
	G02 handleG02 = new G02();
	G03 handleG03 = new G03();
	G28 handleG28 = new G28();
	////////////////////////////////////////
	

	/*
	 * Handling wenn ein Command über manuelle Zeile hinzugefügt wird Es wird
	 * automatisch geprüft ob dieser valide ist Falls ja wird er in die Commandliste
	 * übernommen und ist breit zum ausführen
	 */
	public void btnAddCommand(ActionEvent actionEvent) {
		// tester.checkCommand(sc);

		
			if (tester.checkCommand(sc)) {
				if (!btnManager.getCommandListSet()) {
					if (field_Befehl.getText().length() > 1) {
						CommandCode cc = new CommandCode(field_Pos.getText().toUpperCase(),
								field_Befehl.getText().toUpperCase(), Double.parseDouble(field_x.getText()),
								Double.parseDouble(field_y.getText()), Double.parseDouble(field_i.getText()),
								Double.parseDouble(field_j.getText()));

						tempCommands.add(cc);

						for (int i = 1; i < tempCommands.size(); i++) {
							for (int j = 0; j < tempCommands.size() - i; j++) {
								if (Integer.parseInt(tempCommands.get(j).getPos().substring(1)) > Integer
										.parseInt(tempCommands.get(j + 1).getPos().substring(1))) {

									CommandCode temp = tempCommands.get(j);
									tempCommands.set(j, tempCommands.get(j + 1));
									tempCommands.set(j + 1, temp);
								}
							}
						}

						int zaehler = Integer.parseInt(field_Pos.getText().substring(1)) + 10;
						field_Pos.setText("N" + zaehler);
						logger.addToLog(cc.toString());
						logger.refreshLog(sc);
						field_Befehl.clear();

						commands = tempCommands;		
						
						// Ausgabe in der Konsole
						for (int i = 0; i < commands.size(); i++) {
							commands.get(i).printValues();
						}

						btnManager.commandAdded(sc);
					}

				} else {
					errorHandler.firstDeleteCommands();
				}
			}
		} 

	/*
	 * L�scht alle eingelesenen oder eingegebenen Commands
	 */
	public void btnCommandsDelete(ActionEvent actionEvent) {
		commands.clear();
		tempCommands.clear();
		field_Pos.setText("N00");
		for (int i = 0; i < commands.size(); i++) {
			commands.get(i).printValues();
		}

		btnManager.commandDeleted(sc);
	}

	/*
	 * Einlesen der Einstellungen der Fräse. Muss am Anfang betätigt werden.
	 * Waährend das Programm läuft, könnte die Settingsfile geupdatet werden und neu
	 * eingelesen. Anezige der Einstellungen wird ebenfalls gesetzt.
	 */
	public void btnSettingsRead(ActionEvent actionEvent) {
		
		if (!btnManager.getSettingsSet()) {
			ParseHandler ph1 = new ParseHandler();
			String[] settings = ph1.handleSettings();
			setSettings(settings);

			// fraeser.printValues();
			btnManager.settingsInitialized(sc);
		}else {
			errorHandler.settingsAreAlreadyLoaded(sc);
		}
		
	}

	/*
	 * Einlesen der Commands.json Datei um einen ganzen Befehlsblock übernehem und
	 * ausführen zu können Während des Einlesens wird die Validität der Befehle
	 * geprüft und das Programm gibt Feedback, sollten ungültige Befehle versucht
	 * werden einzulesen.
	 */
	public void btnCommandsRead(ActionEvent actionEvent) { // Alle Commands in die ArrayList commands einlesen
		

			if (!btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
				ParseHandler ph2 = new ParseHandler();
				commands.clear();
				commands = ph2.handleCommand();
				if (tester.checkBlock(sc)) {

					// Ausgabe in der Konsole
					for (int i = 0; i < commands.size(); i++) {
						commands.get(i).printValues();
					} ////////////////////
					
					logger.addToLog("Befehlscode.json eingelesen");
					logger.refreshLog(sc);
					btnManager.commandListInitialized(sc);
				}

			} else {
				errorHandler.firstDeleteCommands();
			}
		 

	}

	/*
	 * Starten der Befehlsverarbeitung und Simulation der eingegebenen Befehle
	 */
	public void btnStart(ActionEvent actionEvent) throws InterruptedException {
		if (!btnManager.getSettingsSet() && !btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
			errorHandler.firstReadSettingsCommands();
		} else if (!btnManager.getSettingsSet() && (btnManager.getCommandsSet() || btnManager.getCommandListSet())) {
			errorHandler.firstReadSettings();
		} else if (btnManager.getSettingsSet() && !btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
			errorHandler.firstReadCommands();
		} 
		

		else {

			/////////////////////////
			// STARTEN DER SIMULATION
			/////////////////////////
			System.out.println("FrÃ¤se startet");
			btnManager.startProcess(sc);

//			cutCode(commands.get(iterator));
//			iterator++;
//			launchCommand();
			
			
//			for (int i = 0; i < commands.size(); i++) {
//				launchCommand();
//			}
			
			launchCommand();
			
//			new Thread(() -> {
//	
//				do {
//					System.out.println("nice");
//				} while (angeshaltet );
//
//					if (Thread.interrupted()) {
//						return;
//					}
//				}).start();
			
			
			
			
//			logger.refreshLog(sc);
			
	      

			// Stop

		}

	}

	
	/*
	 * Pausieren der Befehlsfolge
	 */
	public void btnPause(ActionEvent actionEvent) {
		if (!btnManager.getProcessStarted() || btnManager.getProcessStopped()) {
			errorHandler.firstStartProcess();
		} else {

			// Programm Pausieren

			btnManager.pauseProcess(sc);
		}

	}

	/*
	 * Stoppen der Anwendung
	 */
	public void btnStopp(ActionEvent actionEvent) throws InterruptedException {
		if (btnManager.getProcessStopped()) {
			errorHandler.youStoppedProcess();
		} else if (!btnManager.getProcessPaused() && !btnManager.getProcessStarted()) {
			errorHandler.firstStartProcess();
		} else {
			System.exit(1);
			btnManager.stopProcess(sc);
		}

	}

	/*
	 * L�schen des Logverlaufes
	 */
	public void btnDeleteLog(ActionEvent actionEvent) {
		if (btnManager.getLoggingDeleted()) {
			errorHandler.thereIsNoLog();
		} else {
			btnManager.logDelete(sc, logger);
		}
	}

	/*
	 * Exportieren des zur Laufzeit geschriebenen Logs
	 */
	public void btnExportLog(ActionEvent actionEvent) throws IOException {
		if (btnManager.getLoggingDeleted()) {
			errorHandler.thereIsNoLog();
		} else {
			btnManager.exportLog(sc, logger);
		}
	}

	/*
	 * Alle wichtigen Einstellungen an die Komponenten übertragen
	 * 0 -> HomePosX				6
	 * 1 -> HomePosY
	 * 2 -> Speed Kühlung an
	 * 3 -> Speed Kühlung aus
	 * 4 -> Speed zum verfahren
	 * 5 -> Radius des Fräsers
	 * 6 -> Farbe des Fräsers
	 * 7 -> Farbe der Oberfläche
	 * 8 -> Farbe der bearbeiteten Oberfläche
	 * 9 -> Farbe der Homeposition
	 */
	public void setSettings(String[] settings) {
		fraeser.setHomePosX(Double.parseDouble(settings[0]));
		fraeser.setHomePosY(Double.parseDouble(settings[1])); 
		fraeser.setSchnittSpeedCooling(Double.parseDouble(settings[2]));
		fraeser.setSchnittSpeedNoCooling(Double.parseDouble(settings[3]));
		fraeser.setFahrSpeed(Double.parseDouble(settings[4])); 
		fraeser.setDrillDiameter(Double.parseDouble(settings[5]) / 2); 
		circDrill.setFill(btnManager.colorHandler(settings[6])); 
		drillSurface.setFill(btnManager.colorHandler(settings[7])); 
	    drillColor = (btnManager.colorHandler(settings[8]));
		circHomePosition.setFill(btnManager.colorHandler(settings[9]));

		lblHomePos.setText(fraeser.getPosX() + " ; " + fraeser.getHomePosY());
		lblSpeedCooling.setText(fraeser.getSchnittSpeedCooling() + "m/min");
		lblSpeedNoCooling.setText(fraeser.getSchnittSpeedNoCooling() + "m/min");
		lblSpeedNoDrill.setText(fraeser.getFahrSpeed() + "m/min");
		lblDrillDiameter.setText(fraeser.getDrillDiameter() * 2 + "mm");

		circHomePosition.setLayoutX(fraeser.getHomePosX());
		circHomePosition.setLayoutY(fraeser.getHomePosY());
		circHomePosition.setRadius(fraeser.getDrillDiameter()+1);
		circDrill.setLayoutX(fraeser.getHomePosX());
		circDrill.setLayoutY(fraeser.getHomePosY());
		circDrill.setRadius(fraeser.getDrillDiameter() / 2);

	}

	/*
	 * Zur Abarbeitung der erstellten Befehlsfolge
	 */
	public void cutCode(CommandCode paramList) {

		switch (paramList.getBefehl()) {
		case "M00":
			handleM00.exec(spindel, fraeser, sc, logger);
			break;
		case "M02":
			handleM02.exec(spindel, fraeser, sc, logger);
			break;
		case "M03":
			handleM03.exec(spindel, fraeser, sc, logger);
			break;
		case "M04":
			handleM04.exec(spindel, fraeser, sc, logger);
			break;
		case "M05":
			handleM05.exec(spindel, fraeser, sc, logger);
			break;
		case "M08":
			handleM08.exec(spindel, fraeser, sc, logger);
			break;
		case "M09":
			handleM09.exec(spindel, fraeser, sc, logger);
			break;
		case "M13":
			handleM13.exec(spindel, fraeser, sc, logger);
			break;
		case "M14":
			handleM14.exec(spindel, fraeser, sc, logger);
			break;

		case "G00":
			handleG00.exec(spindel, fraeser, sc, logger, paramList);
			break;
		case "G01":
			handleG01.exec(spindel, fraeser, sc, logger, paramList);
			break;
		case "G02":
			handleG02.exec(spindel, fraeser, sc, logger, paramList);
			break;
		case "G03":
			handleG02.exec(spindel, fraeser, sc, logger, paramList);
			break;
		case "G28":
			handleG28.exec(spindel, fraeser, sc, logger, paramList);
			break;
		}
	}
	
	
	
	public void launchCommand() {
//		Platform.runLater(() -> {
//			
//				cutCode(commands.get(iterator));
//				iterator ++;
//				logger.refreshLog(sc);
//			
//       	 
//        });
		
		
		
		logger.refreshLog(sc);
		if (iterator < commands.size()) {
			cutCode(commands.get(iterator));
			iterator ++;
		}else {
			errorHandler.NoMoreCommands();
		}

	}

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		sc = this;

	}

	public void refreshDrillPos() {
		statX.setText(Double.toString(fraeser.getPosX()*2));
		statY.setText(Double.toString(fraeser.getPosY()*2));
		
		
	}



}
