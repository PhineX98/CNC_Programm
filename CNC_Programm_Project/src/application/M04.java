package application;

/**
 *
 * @author Jannik Orth
 */
public class M04 extends Befehl {

	// Spindel ein gegen den Uhrzeigersinn (Linkslauf)

	public void exec(Spindel s, Fraeser f, SampleController c) {
		s.startLeft();
		f.setSchnittSpeed(2);

		resetStatus(s, f, c);
	}

	// Spindel ein
	// Vorschub ein?
	// Drehrichtung links
	// Bohrspeed = 2
}
