package application;

public class M09 extends Befehl{
	
	//K�hlmittel aus
	public void exec(Spindel s, Fraeser f, SampleController c) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);
	}
	//K�hlung aus
    //Bohrspeed = 2

}
