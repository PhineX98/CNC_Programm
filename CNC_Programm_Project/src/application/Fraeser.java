package application;



public class Fraeser {

	public  double fahrSpeed;
	public  double schnittSpeed;
	public  boolean fraeserStatus = false;
	public  boolean coolingStatus = false;
	public  double posX;
	public  double posY;
	public  double homePosX;
	public  double homePosY;
	
	
	public double getHomePosX() {
		return homePosX;
	}

	public void setHomePosX(double homePosX) {
		this.homePosX = homePosX;
	}

	public double getHomePosY() {
		return homePosY;
	}

	public void setHomePosY(double homePosY) {
		this.homePosY = homePosY;
	}


	

	// ALLE METHODEN MÜSSEN STATIC SEIN

	// Fäser Starten
	public  void startFraeser() {
		this.fraeserStatus = true;
	}

	// Fräser Stoppen
	public  void stopFraeser() {
		this.fraeserStatus = false;
	}

	// Fräser Status ausgeben
	public  boolean getFraeserStatus() {
		return fraeserStatus;
	}

	// fräasenstatus setzen
	public  void setFraeserStatus(boolean status) {
		this.fraeserStatus = status;
	}

	// drivespeed setzten
	public  void setFahrSpeed(double speed) {
		this.fahrSpeed = speed;
	}

	// getten
	public  double getFahrSpeed() {
		return fahrSpeed;
	}

	// schnittgeschwindigkeit setzen
	public  void setSchnittSpeed(double speed) {
		this.schnittSpeed = speed;
	}

	// getten
	public  double getSchnittSpeed() {
		return schnittSpeed;
	}

	// posX setzen
	public  void setPosX(double pos) {
		this.posX = pos;
	}

	// getten
	public  double getPosX() {
		return posX;
	}

	// posY setzten
	public  void setPosY(double pos) {
		posY = pos;
	}

	// getten
	public  double getPosY() {
		return posY;
	}

	// cooling setzen
	public  void setCoolingStatus(boolean stat) {
		this.coolingStatus = stat;
	}

	// cooling getten
	public  boolean getCoolingStatus() {
		return coolingStatus;
	}

}
