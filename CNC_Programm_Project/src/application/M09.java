package application;

public class M09 extends MCommand{
	
	//K�hlmittel aus
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);
	}
	//K�hlung aus
    //Bohrspeed = 2

}
