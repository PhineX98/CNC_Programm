package fileParser;

import java.util.ArrayList;

public class ParseHandler {
	
	public ArrayList<CommandCode> handleCommand(){
	   ArrayList<CommandCode> commandArray;
        //final String path = "C:\\Users\\janni\\iCloudDrive\\DHBW\\S2_Programmieren 2\\Projekt\\A_dateien\\Befehlscode.json";
        //final String path = " C:\\Users\\bohne\\IdeaProjects\\CNC_Frase\\Files\\Json\\Befehlscode.json";
        final String path = "src/fileParser/Befehlscode.json";

        //Den Parser erstellen
        JsonArrayParser parser = new JsonArrayParser();

        //Liste zum Ausgeben und weiterentwickelen erstellen
        commandArray = parser.parse(path);


        //Testweise mal alle Werte aus der json ausgeben
      
        
        return commandArray;
        
	}
	
	
	public String[] handleSettings() {
        final String settingsPath = "src/fileParser/Settings.json";

        //Den Parser erstellen
        JsonSettingsParser settingsParser = new JsonSettingsParser();
        settingsParser.readSettings(settingsPath);

        
        String a = (Long.toString(settingsParser.getHomePosX()) + " ; " + Long.toString(settingsParser.getHomePosY()));
        String c = (Long.toString(settingsParser.getSpeedCooling()));
        String d = (Long.toString(settingsParser.getSpeedNoCooling()));
        String e = (Long.toString(settingsParser.getSpeedNoDrill()));
        String f = (Long.toString(settingsParser.getDrillDiameter()));
        
        String[] settings = {a, c, d, e, f};
        
		return settings;
        
	}
	

	
}
