package application;


public class M00 extends Befehl{
	
	//Programmhalt
	
	public void exec(Spindel s, Fraeser f, SampleController c) {
		s.stop();
		f.stopFraeser();
		f.setSchnittSpeed(0);
		f.setCoolingStatus(false);
		
		/*
		c.statFraeser.setText("AUS");
		c.statDirection.setText("-");
		c.statCooling.setText("AUS");
		c.statSpeed.setText("0");
		*/
		
		resetStatus(s, f, c);
		
	}
	
	//Spindel aus
    //Vorschub aus
    //Kühlmittel aus
    //Bohrspeed = 0
}

