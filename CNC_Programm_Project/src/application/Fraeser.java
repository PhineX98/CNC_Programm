package application;

public class Fraeser {

	public static double fahrSpeed;
	public static double schnittSpeed;
	public static boolean fraeserStatus = false;
	public static boolean coolingStatus = false;
	public static double posX;
	public static double posY;

	public Fraeser(double x, double y) {
		Fraeser.posX = x;
		Fraeser.posY = y;
	}

	// ALLE METHODEN MÜSSEN STATIC SEIN

	// Fäser Starten
	public static void startFraeser() {
		fraeserStatus = true;
	}

	// Fräser Stoppen
	public static void stopFraeser() {
		fraeserStatus = false;
	}

	// Fräser Status ausgeben
	public static boolean getFraeserStatus() {
		return fraeserStatus;
	}

	// fräasenstatus setzen
	public static void setFraeserStatus(boolean status) {
		fraeserStatus = status;
	}

	// drivespeed setzten
	public static void setFahrSpeed(double speed) {
		fahrSpeed = speed;
	}

	// getten
	public static double getFahrSpeed() {
		return fahrSpeed;
	}

	// schnittgeschwindigkeit setzen
	public static void setSchnittSpeed(double speed) {
		schnittSpeed = speed;
	}

	// getten
	public static double getSchnittSpeed() {
		return schnittSpeed;
	}

	// posX setzen
	public static void setPosX(double pos) {
		posX = pos;
	}

	// getten
	public static double getPosX() {
		return posX;
	}

	// posY setzten
	public static void setPosY(double pos) {
		posY = pos;
	}

	// getten
	public static double getPosY() {
		return posY;
	}

	// cooling setzen
	public static void setCoolingStatus(boolean stat) {
		coolingStatus = stat;
	}

	// cooling getten
	public static boolean getCoolingStatus() {
		return coolingStatus;
	}

}
