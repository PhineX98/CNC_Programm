package application;

public class M14 extends MCommand{
	
	//Spindel ein, Linkslauf und K�hlmittel ein
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.startLeft();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung links
    //K�hlmittel an
    //Bohrspeed = 3
}
