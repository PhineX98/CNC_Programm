package application;

public class M13 extends MCommand{
	
	//Spindel ein, Rechtslauf und K�hlmittel ein
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.startRight();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung rechts
    //K�hlmittel an
    //Bohrspeed = 3
}
