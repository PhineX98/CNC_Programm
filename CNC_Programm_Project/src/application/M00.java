package application;



public class M00 extends MCommand{
	
	//Programmhalt
	
	@Override
	public void exec(Spindel s, Fraeser f) {
		s.stop();
		f.stopFraeser();
		f.setSchnittSpeed(0);
		f.setCoolingStatus(false);
		
		
		
	}
	
	//Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}
