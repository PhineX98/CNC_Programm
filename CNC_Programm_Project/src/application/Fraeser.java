package application;

public class Fraeser {

	public static double driveSpeed;
	public static double cutSpeed;
	public static boolean fraeserStatus = false;
	public static boolean coolingStatus = false;
	public static double posX;
	public static double posY;

	public Fraeser(double x, double y) {
		Fraeser.posX = x;
		Fraeser.posY = y;
	}

	// ALLE METHODEN M�SSEN SATIC SEIN

	// F�ser Starten
	public static void startFraeser() {
		fraeserStatus = true;
	}

	// Fr�ser Stoppen
	public static void stopFraeser() {
		fraeserStatus = false;
	}

	// Fr�ser Status ausgeben
	public static boolean getFraeserStatus() {
		return fraeserStatus;
	}

	// fr�asenstatus setzen
	public static void setFraeserStatus(boolean status) {
		fraeserStatus = status;
	}

	// drivespeed setzten
	public static void setDriveSpeed(double speed) {
		driveSpeed = speed;
	}

	// getten
	public static double getDriveSpeed() {
		return driveSpeed;
	}

	// schnittgeschwindigkeit setzen
	public static void setCutSpeed(double speed) {
		cutSpeed = speed;
	}

	// getten
	public static double getCutSpeed() {
		return cutSpeed;
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
