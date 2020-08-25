package application;

public class Drill {
	public static boolean drillStatus = false;
	
	//false -> Rechtslauf  |  true -> Linkslauf
	public static boolean drillRichtung = false;
	
	
	
	//ALLE METHODEN MÜSSEN SATIC SEIN
	
	//Drill Stoppen
	public static void drillStop() {
		drillStatus = false;
	}
	
	//Drill Starten rechtsherum
	public static void drillStartRight() {
		drillStatus = true;
		drillRichtung = false;
	}
	
	//Drill Starten linksrum
	public static void drillStartLeft() {
		drillStatus = true;
		drillRichtung = true;
	}
	
	//get Drill Status
	public static boolean getDrillStatus() {
		return drillStatus;
	}
	
	//get Drill Richtung 
	public static boolean getDrillRichtung() {
		return drillRichtung;
	}
	
}
