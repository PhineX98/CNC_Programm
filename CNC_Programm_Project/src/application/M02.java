
package application;

public class M02 extends Befehl{
	
	public void exec(Spindel s, Fraeser f, SampleController c) {
		//Programm beenden
		
		s.stop();
		f.setFraeserStatus(false);
		f.setCoolingStatus(false);
		f.setFahrSpeed(0);
	}
	
	//Programm Ende
    //Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}

