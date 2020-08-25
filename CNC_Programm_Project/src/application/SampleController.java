package application;


import java.util.ArrayList;

import fileParser.CommandCode;
import fileParser.ParseHandler;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;


public class SampleController {

	public Label statX;
	public Label statY;
	public Label statCooling;
	public Label statDirection;
	public Label statFraeser;
	public Label statSpeed;

    public Label lblHomePos;
    public Label lblSpeedCooling;
    public Label lblSpeedNoCooling;
    public Label lblSpeedNoDrill;
    public Label lblDrillDiameter;

    
    public Rectangle drillSurface;
    
	
	
	
	
	public void btnSettingsRead() { //Setting einlesen und auf Lables übertragen
		ParseHandler ph1 = new ParseHandler();
    	String[] settings = ph1.handleSettings();
    	setSettings(settings);
    }
	
	
	public void btnCommandsRead() { //Alle Commands in die ArrayList commands einlesen
		ArrayList<CommandCode> commands;
		ParseHandler ph2 = new ParseHandler();
		commands = ph2.handleCommand();
		
		//Ausgabe in der Konsole
    	  for(int i = 0; i<commands.size(); i++){
    		  commands.get(i).printValues();
          }
    	  
    }
	
	
    public void btnStart() {
    	System.out.println("3");
    }
    
    
    public void btnStopp() {
    	System.out.println("4");
    }
    
    
    public void btnPause() {
    	System.out.println("5");
    }
    
    
    public void setLabels() {
    	
    }
    
    
    public void setSettings(String[] settings){
    	lblHomePos.setText(settings[0]);
    	lblSpeedCooling.setText(settings[1]);
    	lblSpeedNoCooling.setText(settings[2]);
    	lblSpeedNoDrill.setText(settings[3]);
    	lblDrillDiameter.setText(settings[4]);
    }
	
}
