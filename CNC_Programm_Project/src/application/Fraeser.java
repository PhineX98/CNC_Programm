package application;

/**
*Diese Klasse abstrahiert den Fräser mit seinen Eigenschaften um diesen steuern zu können.
*
* @author Jannik Orth
*/
public class Fraeser {

	public double fahrSpeed;
	public double schnittSpeedCooling;
	public double schnittSpeedNoCooling;
	public boolean fraeserStatus = false;
	public boolean coolingStatus = false;
	public double posX;
	public double posY;
	public double homePosX;
	public double homePosY;

	private double drillDiameter;
	private double aktSpeed;

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


	
	public void setAktSpeed(Spindel s) {
		if (coolingStatus && fraeserStatus) {
			this.aktSpeed = schnittSpeedCooling;
		}else if (!coolingStatus && fraeserStatus) {
			this.aktSpeed = schnittSpeedNoCooling;
		}else if (fraeserStatus && !s.getStatus()) {
			this.aktSpeed = fahrSpeed;
		}else {
			this.aktSpeed = 0;
		}
	}
	
	public double getAktSpeed(){
		return aktSpeed;
	}
	

	// Fräser Status ausgeben
	public boolean getFraeserStatus() {
		return fraeserStatus;
	}

	// fräasenstatus setzen
	public void setFraeserStatus(boolean status) {
		this.fraeserStatus = status;
	}

	// drivespeed setzten
	public void setFahrSpeed(double speed) {
		this.fahrSpeed = speed;
	}

	// getten
	public double getFahrSpeed() {
		return fahrSpeed;
	}

	// schnittgeschwindigkeit setzen
	public void setSchnittSpeedCooling(double speed) {
		this.schnittSpeedCooling = speed;
	}

	// getten
	public double getSchnittSpeedCooling() {
		return schnittSpeedCooling;
	}
	
	public double getSchnittSpeedNoCooling() {
		return schnittSpeedNoCooling;
	}

	public void setSchnittSpeedNoCooling(double schnittSpeedNoCooling) {
		this.schnittSpeedNoCooling = schnittSpeedNoCooling;
	}

	// posX setzen
	public void setPosX(double pos) {
		this.posX = pos;
	}

	// getten
	public double getPosX() {
		return posX;
	}

	// posY setzten
	public void setPosY(double pos) {
		posY = pos;
	}

	// getten
	public double getPosY() {
		return posY;
	}

	// cooling setzen
	public void setCoolingStatus(boolean stat) {
		this.coolingStatus = stat;
	}

	// cooling getten
	public boolean getCoolingStatus() {
		return coolingStatus;
	}


	public void setDrillDiameter(double diameter) {
		this.drillDiameter = diameter;
	}
	
	public double getDrillDiameter() {
		return drillDiameter;
	}

}

