package application;

public class M03 extends MCommand {
	
	//Spindel ein im Uhrezigersinn (Rechtslauf)
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.startRight();
		f.setSchnittSpeed(2);
	}
	
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung rechts
    //Bohrspeed = 2
}
