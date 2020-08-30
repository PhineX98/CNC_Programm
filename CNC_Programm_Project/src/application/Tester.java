package application;

/**
 * Dies ist die Klasse zum überprüfen der Korrektheit von eingegebenen oder
 * eingelesenen Befehlen oder Befehlsfolgen
 * 
 * @author Jannik Orth
 */
public class Tester {

	/*
	 * Überprüfen der Korrektheit von eingegebenen Einzelbefehlen
	 */
	public boolean checkCommand(SampleController sc) {
		String cmd = sc.field_Befehl.getText().toUpperCase();

		if (sc.field_x.getText().isEmpty()) {
			sc.field_x.setText("0");
		}
		if (sc.field_y.getText().isEmpty()) {
			sc.field_y.setText("0");
		}
		if (sc.field_i.getText().isEmpty()) {
			sc.field_i.setText("0");
		}
		if (sc.field_j.getText().isEmpty()) {
			sc.field_j.setText("0");
		}

		Double x = Double.parseDouble(sc.field_x.getText());
		Double y = Double.parseDouble(sc.field_y.getText());

		if (cmd.equals("M00") || cmd.equals("M02") || cmd.equals("M03") || cmd.equals("M04") || cmd.equals("M05")
				|| cmd.equals("M08") || cmd.equals("M09") || cmd.equals("M13") || cmd.equals("M14") || cmd.equals("G00")
				|| cmd.equals("G01") || cmd.equals("G02") || cmd.equals("G03") || cmd.equals("G28")) {

			if (x >= 0 && x <= 1400 && y >= 0 && y <= 1050) {
				return true;
			} else {

				sc.errorHandler.yourCoordinateIsOutOfRange(sc);
				return false;
			}

		} else {
			sc.errorHandler.yourCommandIsNotValid(sc);
			return false;
		}

	}

	/*
	 * Überprüfen der Korrektheit von einem eingelesenen Befehlssatz
	 */
	public boolean checkBlock(SampleController sc) {
		boolean check = true;

		for (int i = 0; i < sc.commands.size(); i++) {

			if (!sc.commands.get(i).getBefehl().equals("M00") && !sc.commands.get(i).getBefehl().equals("M02")
					&& !sc.commands.get(i).getBefehl().equals("M03") && !sc.commands.get(i).getBefehl().equals("M04")
					&& !sc.commands.get(i).getBefehl().equals("M05") && !sc.commands.get(i).getBefehl().equals("M08")
					&& !sc.commands.get(i).getBefehl().equals("M09") && !sc.commands.get(i).getBefehl().equals("M13")
					&& !sc.commands.get(i).getBefehl().equals("M14") && !sc.commands.get(i).getBefehl().equals("G01")
					&& !sc.commands.get(i).getBefehl().equals("G02") && !sc.commands.get(i).getBefehl().equals("G03")
					&& !sc.commands.get(i).getBefehl().equals("G28")) {
				check = false;
				sc.errorHandler.yourCommandsAreNotValid(sc, i);
				break;

			} else if (!(sc.commands.get(i).getX() >= 0) || !(sc.commands.get(i).getX() <= 1400)
					|| !(sc.commands.get(i).getY() >= 0) || !(sc.commands.get(i).getY() <= 1050)) {
				check = false;
				sc.errorHandler.yourCommandsAreNotValid(sc, i);
				break;

			} else {
				check = true;
			}
		}
		return check;

	}
}
