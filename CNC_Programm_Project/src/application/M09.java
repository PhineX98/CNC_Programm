package application;

public class M09 extends MCommand{
	
	//Kühlmittel aus
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		f.setCoolingStatus(false);
		f.setSchnittSpeed(2);
	}
	//Kühlung aus
    //Bohrspeed = 2

}
