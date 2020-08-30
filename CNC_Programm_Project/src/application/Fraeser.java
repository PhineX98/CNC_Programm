package application;



/**
*Diese Klasse abstrahiert den Fräser mit seinen Eigenschaften um diesen steuern zu können.
*
* @author Jannik Orth
*/
public class Fraeser {

	private double fahrSpeed;
	private double schnittSpeedCooling;
	private double schnittSpeedNoCooling;
	private boolean fraeserStatus = false;
	private boolean coolingStatus = false;
	private double posX;
	private double posY;
	private double homePosX;
	private double homePosY;
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
		return Math.round(posX);
	}

	// posY setzten
	public void setPosY(double pos) {
		posY = pos;
	}

	// getten
	public double getPosY() {
		return Math.round(posY);
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
	
	public void printValues() {

		System.out.println(fahrSpeed);
		System.out.println(schnittSpeedCooling);
		System.out.println(schnittSpeedNoCooling);
		System.out.println(homePosX+ posX);
		System.out.println(homePosY+ posY);
		System.out.println(this.drillDiameter);

	}

}

