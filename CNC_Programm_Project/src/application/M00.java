package application;

public class M00 {
	
	//Programmhalt
	
	public static void exec() {
		Drill.drillStop();
		Fraeser.stopFraeser();
		Fraeser.cutSpeed = 0;
		Fraeser.coolingStatus = false;
		
	}
	
	//Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}
