package application;

public class M05 extends Befehl{
	
	//Spindel stopp
	public void exec(Spindel s, Fraeser f, SampleController c) {
		s.stop();
		
		resetStatus(s, f, c);
	}
	
	
	//Spindel aus
    //Bohrspeed = 2
}
