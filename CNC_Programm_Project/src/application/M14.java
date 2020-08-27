package application;

public class M14 extends Befehl{
	
	//Spindel ein, Linkslauf und KÃ¼hlmittel ein
	public void exec(Spindel s, Fraeser f, SampleController c) {
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
