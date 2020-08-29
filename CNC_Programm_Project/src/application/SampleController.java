package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fileParser.CommandCode;
import fileParser.ParseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Rectangle;

/**
 * Dies ist die ControllerKlasse der Anwendung Von hier aus werden alle Button
 * Events gesteuert
 * 
 * @author Jannik Orth
 */

public class SampleController implements Initializable {

	public Label statX;
	public Label statY;
	public Label statCooling;
	public Label statDirection;
	public Label statFraeser;
	public Label statSpeed;

	public Label lblHomePos;
	public Label lblSpeedCooling;
	public Label lblSpeedNoCooling;
	public Label lblSpeedNoDrill;
	public Label lblDrillDiameter;
	public Label lblInfo;

	public TextField field_Befehl;
	public TextField field_Pos;
	public TextField field_x;
	public TextField field_y;
	public TextField field_i;
	public TextField field_j;

	public Rectangle drillSurface;
	public Circle circHomePosition;
	public Circle circDrill;
	public Path path;
	public Pane drawPane;

	public ListView<String> logList;

	ArrayList<CommandCode> commands = new ArrayList<>();
	ArrayList<CommandCode> tempCommands = new ArrayList<>();
	Fraeser fraeser = new Fraeser();
	Spindel spindel = new Spindel();

	public static SampleController sc;
	public Logging logger = new Logging();
	public BtnManager btnManager = new BtnManager();
	public ErrorHandler errorHandler = new ErrorHandler();

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

	public void btnAddCommand(ActionEvent actionEvent) {
		btnManager.checkCommand(field_Befehl.getText(), sc);

		if (btnManager.checkCommand(field_Befehl.getText(), sc)) {
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

	public void btnCommandsDelete(ActionEvent actionEvent) {
		commands.clear();
		tempCommands.clear();
		for (int i = 0; i < commands.size(); i++) {
			commands.get(i).printValues();
		}

		btnManager.commandDeleted(sc);
	}

	public void btnSettingsRead(ActionEvent actionEvent) { // Setting einlesen und auf Lables übertragen
		ParseHandler ph1 = new ParseHandler();
		String[] settings = ph1.handleSettings();
		setSettings(settings);

		

		btnManager.settingsInitialized(sc);
	}

	public void btnCommandsRead(ActionEvent actionEvent) { // Alle Commands in die ArrayList commands einlesen
		if (!btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
			ParseHandler ph2 = new ParseHandler();
			commands = ph2.handleCommand();

			// Ausgabe in der Konsole
			for (int i = 0; i < commands.size(); i++) {
				commands.get(i).printValues();
			}

			btnManager.commandListInitialized(sc);
		} else {
			errorHandler.firstDeleteCommands();
		}

	}

	public void btnStart(ActionEvent actionEvent) throws InterruptedException {
		if (!btnManager.getSettingsSet() && !btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
			errorHandler.firstReadSettingsCommands();
		} else if (!btnManager.getSettingsSet() && (btnManager.getCommandsSet() || btnManager.getCommandListSet())) {
			errorHandler.firstReadSettings();
		} else if (btnManager.getSettingsSet() && !btnManager.getCommandsSet() && !btnManager.getCommandListSet()) {
			errorHandler.firstReadCommands();
		} else {

			/////////////////////////
			// STARTEN DER SIMULATION
			/////////////////////////
			System.out.println("Fräse startet");
			btnManager.startProcess(sc);

			// Startpunkt anfahren

			// Liste mit commands anfahren
			for (int i = 0; i < commands.size(); i++) {
				cutCode(commands.get(i));
				logger.refreshLog(sc);
			}

			// Stop

		}

	}

	public void btnPause(ActionEvent actionEvent) {
		System.out.println("5");
		if (!btnManager.getProcessStarted() || btnManager.getProcessStopped()) {
			errorHandler.firstStartProcess();
		} else {

			// Programm Pausieren

			btnManager.pauseProcess(sc);
		}

	}

	public void btnStopp(ActionEvent actionEvent) throws InterruptedException {
		if (btnManager.getProcessStopped()) {
			errorHandler.youStoppedProcess();
		} else if (!btnManager.getProcessPaused() && !btnManager.getProcessStarted()) {
			errorHandler.firstStartProcess();
		} else {

			// ProgrammS Stoppen

			btnManager.stopProcess(sc);
		}

	}

	public void btnDeleteLog(ActionEvent actionEvent) {
		if (btnManager.getLoggingDeleted()) {
			errorHandler.thereIsNoLog();
		} else {
			btnManager.logDelete(sc, logger);

		}
	}

	public void btnExportLog(ActionEvent actionEvent) {
		if (btnManager.getLoggingDeleted()) {
			errorHandler.thereIsNoLog();
		} else {
			btnManager.exportLog(sc, logger);
		}
	}

	// geladene Einstellungen auf Anzeige und Fräser übertragen
	public void setSettings(String[] settings) {
		fraeser.setHomePosX(Double.parseDouble(settings[0]));				//HomePos x
		fraeser.setHomePosY(Double.parseDouble(settings[1]));				//HomePos y
		fraeser.setSchnittSpeedCooling(Double.parseDouble(settings[2]));	//Speed kühlung an
		fraeser.setSchnittSpeedNoCooling(Double.parseDouble(settings[3]));	//Speed kühlung aus
		fraeser.setFahrSpeed(Double.parseDouble(settings[4]));				//Speed zum verfahren
		fraeser.setDrillDiameter(Double.parseDouble(settings[5]));			//Fräser Durchmesser
		circDrill.setFill(btnManager.colorHandler(settings[6]));			//Farbe Fräser
		drillSurface.setFill(btnManager.colorHandler(settings[7]));			//Farbe Oberfläche
		//circDrill.setFill(btnManager.colorHandler(settings[8]));			//Farbe bearbeitete Oberfläche
		circHomePosition.setFill(btnManager.colorHandler(settings[9]));		//Farbe HomePos
		
		lblHomePos.setText(fraeser.getPosX() + " ; " + fraeser.getHomePosY());
		lblSpeedCooling.setText(fraeser.getSchnittSpeedCooling() + "m/min");
		lblSpeedNoCooling.setText(fraeser.getSchnittSpeedNoCooling() + "m/min");
		lblSpeedNoDrill.setText(fraeser.getFahrSpeed() + "m/min");
		lblDrillDiameter.setText(fraeser.getDrillDiameter() + "mm");
		
		circHomePosition.setLayoutX(fraeser.getHomePosX());
		circHomePosition.setLayoutY(fraeser.getHomePosY());
		circDrill.setLayoutX(fraeser.getHomePosX());
		circDrill.setLayoutY(fraeser.getHomePosY());
		circDrill.setRadius(fraeser.getDrillDiameter() / 2);
		
		
	}

	private void cutCode(CommandCode paramList) {

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

	public void btnTest(ActionEvent actionEvent) {
		
		Line line = new Line();
		line.setStartX(50);
		line.setStartY(50);
		line.setEndX(100);
		line.setEndY(50);
		line.setStroke(Color.RED);
		
		drawPane.getChildren().add(line);

		//////////////////////////////////////////

		MoveTo moveTo = new MoveTo();
		moveTo.setX(0.0f);
		moveTo.setY(0.0f);

		QuadCurveTo quadCurveTo = new QuadCurveTo();
		quadCurveTo.setX(120.0f);
		quadCurveTo.setY(60.0f);
		quadCurveTo.setControlX(100.0f);
		quadCurveTo.setControlY(0.0f);

		LineTo lineTo = new LineTo();
		lineTo.setX(175.0f);
		lineTo.setY(55.0f);

		ArcTo arcTo = new ArcTo();
		arcTo.setX(50.0f);
		arcTo.setY(50.0f);
		arcTo.setRadiusX(50.0f);
		arcTo.setRadiusY(50.0f);

		path.getElements().add(moveTo);
		path.getElements().add(quadCurveTo);
		path.getElements().add(lineTo);
		path.getElements().add(arcTo);

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		sc = this;

		
	}

}
