package application;

public class M05 extends MCommand{
	
	//Spindel stopp
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.stop();
	}
	
	
	//Spindel aus
    //Bohrspeed = 2
}
