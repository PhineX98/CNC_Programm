package application;

public class M08 extends MCommand {
	 
	//K�hlmittel ein
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		f.setCoolingStatus(true);
		f.setSchnittSpeed(3);
	}
	//K�hlung ein
    //Bohrspeed = 3
}
