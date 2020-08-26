package application;

public class M13 {
	
	//Spindel ein, Rechtslauf und Kühlmittel ein
	public void exec(Spindel s, Fraeser f) {
		s.startRight();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung rechts
    //Kühlmittel an
    //Bohrspeed = 3
}
