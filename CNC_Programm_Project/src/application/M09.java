package application;

public class M09 extends Befehl{
	
	//Kühlmittel aus
	public void exec(Spindel s, Fraeser f, SampleController c) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);
	}
	//Kühlung aus
    //Bohrspeed = 2

}
