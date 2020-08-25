package application;

public class M02 {
	
	public static void exec() {
		//Programm beenden
		
		Drill.drillStop();
		Fraeser.setFraeserStatus(false);
		Fraeser.setCoolingStatus(false);
		Fraeser.setDriveSpeed(0);
	}
	
	//Programm Ende
    //Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}
