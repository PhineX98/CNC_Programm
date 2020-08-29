package fileParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.Double.parseDouble;

/**
 * Liest die Befehlscode.json Datei aus dem eingegebenen Pfad ein wandelt alle
 * Befehlscodes mit ihren Parametern in ein Array zur sp√§teren Handhabung.
 *
 * @author Jannik Orth
 */
public class JsonArrayParser {

	/*
	 * Erstellen einer Arraylist des Typs CommandCode aus der Befehlscode.json Datei
	 */
	public ArrayList<CommandCode> parse(String path) {

		JSONParser jsonParser = new JSONParser();
		ArrayList<CommandCode> list = new ArrayList<>();

		try (FileReader reader = new FileReader(path)) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONArray commandList = (JSONArray) obj;

			for (int i = 0; i < commandList.size(); i++) {
				CommandCode tempItem = parseCommandObject((JSONObject) commandList.get(i));
				list.add(tempItem);

			}

		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	/*
	 * ‹bersetzt einen einzelnen Befehl aus der json Datei in ein CommandCode Objekt
	 */
	private CommandCode parseCommandObject(JSONObject command) {
		double i = 0, j = 0, x = 0, y = 0;

		JSONObject commandObject = (JSONObject) command.get("command");

		String number = (String) commandObject.get("number");

		String code = (String) commandObject.get("code");

		JSONObject paramObj = (JSONObject) commandObject.get("parameters");

		if (paramObj.get("x") != null && paramObj.get("y") != null) {
			String xS = paramObj.get("x").toString();
			x = parseDouble(xS);
			String yS = paramObj.get("y").toString();
			y = parseDouble(yS);

			if (paramObj.get("i") != null && paramObj.get("j") != null) {
				String iS = paramObj.get("i").toString();
				i = parseDouble(iS);
				String jS = paramObj.get("j").toString();
				j = parseDouble(jS);
			}
		}

		return new CommandCode(number, code, x, y, i, j);

	}

}
