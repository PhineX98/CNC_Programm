package application;

/**
 * Diese Klasse abstrahiert den FrÃ¤ser mit seinen Eigenschaften um diesen
 * steuern zu kÃ¶nnen.
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
	private double deg;

	// HomePosition X
	public double getHomePosX() {
		return homePosX;
	}

	public void setHomePosX(double homePosX) {
		this.homePosX = homePosX;
	}

	// HomePostion Y
	public double getHomePosY() {
		return homePosY;
	}

	public void setHomePosY(double homePosY) {
		this.homePosY = homePosY;
	}

	// Aktuelle absolute Fhargeschwindikeit
	public void setAktSpeed(Spindel s) {
		if (coolingStatus && fraeserStatus) {
			this.aktSpeed = schnittSpeedCooling;
		} else if (!coolingStatus && fraeserStatus) {
			this.aktSpeed = schnittSpeedNoCooling;
		} else if (fraeserStatus && !s.getStatus()) {
			this.aktSpeed = fahrSpeed;
		} else {
			this.aktSpeed = 0;
		}
	}

	public double getAktSpeed() {
		return aktSpeed;
	}

	// Aktueller Fräserstatus
	public boolean getFraeserStatus() {
		return fraeserStatus;
	}

	public void setFraeserStatus(boolean status) {
		this.fraeserStatus = status;
	}

	// Geschwindigkeit für Eilgang
	public void setFahrSpeed(double speed) {
		this.fahrSpeed = speed;
	}

	public double getFahrSpeed() {
		return fahrSpeed;
	}

	// Eingestellte Geschwindigkeit mit Kühlung
	public void setSchnittSpeedCooling(double speed) {
		this.schnittSpeedCooling = speed;
	}

	public double getSchnittSpeedCooling() {
		return schnittSpeedCooling;
	}

	// Eingestellte Geschwindigkeit ohne Kühlung
	public double getSchnittSpeedNoCooling() {
		return schnittSpeedNoCooling;
	}

	public void setSchnittSpeedNoCooling(double schnittSpeedNoCooling) {
		this.schnittSpeedNoCooling = schnittSpeedNoCooling;
	}

	// Aktuelle x-Position
	public void setPosX(double pos) {
		this.posX = pos;
	}

	public double getPosX() {
		return Math.round(posX);
	}

	// Aktuelle y-Position
	public void setPosY(double pos) {
		posY = pos;
	}

	public double getPosY() {
		return Math.round(posY);
	}

	// Kühlung
	public void setCoolingStatus(boolean stat) {
		this.coolingStatus = stat;
	}

	public boolean getCoolingStatus() {
		return coolingStatus;
	}

	// Bohrdurchmesser
	public void setDrillDiameter(double diameter) {
		this.drillDiameter = diameter;
	}

	public double getDrillDiameter() {
		return drillDiameter;
	}

	// Gradzahl
	public double getDeg() {
		return deg;
	}

	public void setDeg(double deg) {
		this.deg = deg;
	}

	public void printValues() {

		System.out.println(fahrSpeed);
		System.out.println(schnittSpeedCooling);
		System.out.println(schnittSpeedNoCooling);
		System.out.println(homePosX + posX);
		System.out.println(homePosY + posY);
		System.out.println(this.drillDiameter);

	}

}