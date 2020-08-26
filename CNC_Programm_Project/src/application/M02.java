package application;

public class M02 {
	
	public static void exec() {
		//Programm beenden
		
		Spindel.drillStop();
		Fraeser.setFraeserStatus(false);
		Fraeser.setCoolingStatus(false);
		Fraeser.setFahrSpeed(0);
	}
	
	//Programm Ende
    //Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}
