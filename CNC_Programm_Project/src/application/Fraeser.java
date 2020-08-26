package application;

public class Fraeser {

	public  double fahrSpeed;
	public  double schnittSpeed;
	public  boolean fraeserStatus = false;
	public  boolean coolingStatus = false;
	public  double posX;
	public  double posY;

	public Fraeser(double x, double y) {
		this.posX = x;
		this.posY = y;
	}

	// ALLE METHODEN MÜSSEN STATIC SEIN

	// Fäser Starten
	public  void startFraeser() {
		fraeserStatus = true;
	}

	// Fräser Stoppen
	public  void stopFraeser() {
		fraeserStatus = false;
	}

	// Fräser Status ausgeben
	public  boolean getFraeserStatus() {
		return fraeserStatus;
	}

	// fräasenstatus setzen
	public  void setFraeserStatus(boolean status) {
		fraeserStatus = status;
	}

	// drivespeed setzten
	public  void setFahrSpeed(double speed) {
		fahrSpeed = speed;
	}

	// getten
	public  double getFahrSpeed() {
		return fahrSpeed;
	}

	// schnittgeschwindigkeit setzen
	public  void setSchnittSpeed(double speed) {
		schnittSpeed = speed;
	}

	// getten
	public  double getSchnittSpeed() {
		return schnittSpeed;
	}

	// posX setzen
	public  void setPosX(double pos) {
		posX = pos;
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
		coolingStatus = stat;
	}

	// cooling getten
	public  boolean getCoolingStatus() {
		return coolingStatus;
	}

}
