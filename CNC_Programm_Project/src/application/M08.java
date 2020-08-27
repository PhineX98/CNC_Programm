package application;

public class M08 extends MCommand {
	 
	//Kühlmittel ein
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//Kühlung ein
    //Bohrspeed = 3
}
