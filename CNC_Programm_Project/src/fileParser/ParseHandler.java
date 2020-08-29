package fileParser;

import java.util.ArrayList;

/**
 *
 * @author Jannik Orth
 */
public class ParseHandler {
	
	/*
	 * Ausgabe des CommandArrays zur weiteren Verarbeitung
	 */
	public ArrayList<CommandCode> handleCommand() {
		ArrayList<CommandCode> commandArray;
		final String path = "src/fileParser/Befehlscode.json";

		// Den Parser erstellen
		JsonArrayParser parser = new JsonArrayParser();

		// Liste zum Ausgeben und weiterentwickelen erstellen
		commandArray = parser.parse(path);

		// Testweise mal alle Werte aus der json ausgeben

		return commandArray;

	}

	/*
	 * Ausgabe der gesetzten Einstellungen zur weiteren Verarbeitung
	 */
	public String[] handleSettings() {
		final String settingsPath = "src/fileParser/Settings.json";

		// Den Parser erstellen
		JsonSettingsParser settingsParser = new JsonSettingsParser();
		settingsParser.readSettings(settingsPath);
		
		String a = (Long.toString(settingsParser.getHomePosX()));
		String b = (Long.toString(settingsParser.getHomePosY()));
		String c = (Long.toString(settingsParser.getSpeedCooling()));
		String d = (Long.toString(settingsParser.getSpeedNoCooling()));
		String e = (Long.toString(settingsParser.getSpeedNoDrill()));
		String f = (Long.toString(settingsParser.getDrillDiameter()));
		String g = ((settingsParser.getDrillColor()));
		String h = ((settingsParser.getSurfaceColor()));
		String i = ((settingsParser.getSurfaceDrilledColor()));
		String j = ((settingsParser.getHomePosColor()));
		

		String[] settings = { a, b, c, d, e, f, g, h, i, j};

		return settings;

	}

}
