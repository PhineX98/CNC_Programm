package application;

public class M08 extends Befehl{
	
	//K�hlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c) {
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//K�hlung ein
    //Bohrspeed = 3
}
