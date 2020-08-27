package application;

public class M04 extends MCommand{
	
	//Spindel ein gegen den Uhrzeigersinn (Linkslauf)
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.startLeft();
		f.setSchnittSpeed(2);
	}
	
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung links
    //Bohrspeed = 2
}
