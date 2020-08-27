package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fileParser.CommandCode;
import fileParser.ParseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;

/**
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

	public TextField field_Befehl;
	public TextField field_Pos;
	public TextField field_x;
	public TextField field_y;
	public TextField field_i;
	public TextField field_j;

	public Rectangle drillSurface;

	ArrayList<CommandCode> commands = new ArrayList<>();
	ArrayList<CommandCode> tempCommands = new ArrayList<>();
	Fraeser fraeser = new Fraeser();
	Spindel spindel = new Spindel();

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

	public void setX(String s) {
		lblDrillDiameter.setText(s);
	}

	public void btnAddCommand(ActionEvent actionEvent) {

		if (field_Befehl.getText().length() > 1) {
			CommandCode cc = new CommandCode(field_Pos.getText().toUpperCase(), field_Befehl.getText().toUpperCase(),
					Double.parseDouble(field_x.getText()), Double.parseDouble(field_y.getText()),
					Double.parseDouble(field_i.getText()), Double.parseDouble(field_j.getText()));

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

			System.out.println("wurde hinzugefügt");
		}
	}

	public void btnCommandsDelete(ActionEvent actionEvent) {
		commands.clear();
		tempCommands.clear();
		for (int i = 0; i < commands.size(); i++) {
			commands.get(i).printValues();
		}
		System.out.println("wurde gelöscht");

	}

	public void btnSettingsRead(ActionEvent actionEvent) { // Setting einlesen und auf Lables übertragen
		ParseHandler ph1 = new ParseHandler();
		String[] settings = ph1.handleSettings();
		setSettings(settings);
	}

	public void btnCommandsRead(ActionEvent actionEvent) { // Alle Commands in die ArrayList commands einlesen
		ParseHandler ph2 = new ParseHandler();
		commands = ph2.handleCommand();

		// Ausgabe in der Konsole
		for (int i = 0; i < commands.size(); i++) {
			commands.get(i).printValues();
		}

	}

	public void btnStart(ActionEvent actionEvent) {

		// Startpunkt anfahren

		// Liste mit commands anfahren

		// Stop
		System.out.println(field_Befehl.getText());

	}

	public void btnStopp(ActionEvent actionEvent) throws InterruptedException {
		System.out.println("4");

		// Thread aussenrum bauen
		for (int i = 0; i < 20; i++) {

			lblDrillDiameter.setText(String.valueOf(i));
			Thread.sleep(100);
		}
	}

	public void btnPause(ActionEvent actionEvent) {
		System.out.println("5");
	}

	// geladene Einstellungen auf Anzeige und Fräser übertragen
	public void setSettings(String[] settings) {
		lblHomePos.setText(settings[0] + " ; " + settings[1]);
		lblSpeedCooling.setText(settings[2]);
		lblSpeedNoCooling.setText(settings[3]);
		lblSpeedNoDrill.setText(settings[4]);
		lblDrillDiameter.setText(settings[5]);

		fraeser.setHomePosX(Double.parseDouble(settings[0]));
		fraeser.setHomePosY(Double.parseDouble(settings[1]));
	}

	private void cutCode(CommandCode paramList) {

		switch (paramList.getBefehl()) {
		case "M00":
			handleM00.exec(spindel, fraeser, sc);
			break;
		case "M02":
			handleM02.exec(spindel, fraeser, sc);
			break;
		case "M03":
			handleM03.exec(spindel, fraeser, sc);
			break;
		case "M04":
			handleM04.exec(spindel, fraeser, sc);
			break;
		case "M05":
			handleM05.exec(spindel, fraeser, sc);
			break;
		case "M08":
			handleM08.exec(spindel, fraeser, sc);
			break;
		case "M09":
			handleM09.exec(spindel, fraeser, sc);
			break;
		case "M13":
			handleM13.exec(spindel, fraeser, sc);
			break;
		case "M14":
			handleM14.exec(spindel, fraeser, sc);
			break;

		case "G00":
			handleG00.exec(spindel, fraeser, sc);
			break;
		case "G01":
			handleG01.exec(spindel, fraeser, sc);
			break;
		case "G02":
			handleG02.exec(spindel, fraeser, sc);
			break;
		case "G03":
			handleG02.exec(spindel, fraeser, sc);
			break;
		case "G28":
			handleG28.exec(spindel, fraeser, sc);
			break;
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		sc = this;

	}

}
