package application;

public class M00 {
	
	//Programmhalt
	
	public static void exec() {
		Spindel.drillStop();
		Fraeser.stopFraeser();
		Fraeser.schnittSpeed = 0;
		Fraeser.coolingStatus = false;
		
	}
	
	//Spindel aus
    //Vorschub aus
    //K�hlmittel aus
    //Bohrspeed = 0
}
