package application;

public class M14 extends MCommand{
	
	//Spindel ein, Linkslauf und Kühlmittel ein
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.startLeft();
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung links
    //Kühlmittel an
    //Bohrspeed = 3
}
