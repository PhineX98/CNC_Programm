package application;

public class M08 extends Befehl{
	
	//Kühlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c) {
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
		
		resetStatus(s, f, c);
	}
	//Kühlung ein
    //Bohrspeed = 3
}
