package application;

public class M03 extends Befehl{
	
	//Spindel ein im Uhrezigersinn (Rechtslauf)
	
	public void exec(Spindel s, Fraeser f, SampleController c) {
		s.startRight();
		f.setSchnittSpeed(2);
	}
	
	//Spindel ein
    //Vorschub ein?
    //Drehrichtung rechts
    //Bohrspeed = 2
}
