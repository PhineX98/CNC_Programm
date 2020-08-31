package handler;

import application.SampleController;
import javafx.application.Platform;
import javafx.scene.shape.Circle;

/**
 * Diese Klasse implementiert die Handhabung der Animation des Fräsvorgangs
 *
 * @author Jannik Orth
 * @author Simon Bohner
 */
public class AnimationHandler {

	public void lineX(double xRead, double yRead, SampleController sc, double dx, double dy, double xToDrill,
			double speed) {

		new Thread(() -> {

			for (double i = 0; i < Math.round(xToDrill); i = i + Math.abs(dx)) {

				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {

					Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),
							sc.fraeser.getDrillDiameter() / 2, sc.drillColor);
					sc.drawPane.getChildren().add(circle);
					sc.circDrill.toFront();

					sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

					System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead
							+ "   " + yRead + "   " + dx + "  " + dy);

					sc.refreshDrillPos();

					System.out.println("testeinnen");

				});
			}

			if (Thread.interrupted()) {
				System.out.println("interrupted");
				return;
			}
		}).start();

	}

	public void lineY(double xRead, double yRead, SampleController sc, double dx, double dy, double yToDrill,
			double speed) {

		try {
			new Thread(() -> {

				for (double i = 0; i < Math.round(yToDrill); i = i + Math.abs(dy)) {

					try {
						Thread.sleep((long) speed);

					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Platform.runLater(() -> {

						Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),
								sc.fraeser.getDrillDiameter() / 2, sc.drillColor);
						sc.drawPane.getChildren().add(circle);
						sc.circDrill.toFront();

						sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
						sc.fraeser.setPosX(sc.circDrill.getLayoutX());
						sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
						sc.fraeser.setPosY(sc.circDrill.getLayoutY());

						System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead
								+ "   " + yRead + "   " + dx + "  " + dy);

						sc.refreshDrillPos();

						System.out.println("testeinnen");

					});
				}

				if (Thread.interrupted()) {
					return;
				}

			}).start();
		} catch (Exception ignore) {

		}

	}

	public void circle(double xRead, double yRead, double xCenter, double yCenter, double sDeg, double eDeg, double r,
			SampleController sc, double speed) {

		new Thread(() -> {

			System.out.println(eDeg);

			for (double z = sDeg * Math.PI / 180; z <= Math.PI / 180 * eDeg; z = z + 1 * Math.PI / 180) {
				System.out.println(z + "   " + eDeg);
				sc.fraeser.setDeg(z);

				try {

					Thread.sleep(12);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {

					Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),
							sc.fraeser.getDrillDiameter() / 2, sc.drillColor);
					sc.drawPane.getChildren().add(circle);
					sc.circDrill.toFront();

					sc.circDrill.setLayoutX(xCenter + r * Math.cos(sc.fraeser.getDeg()));
					System.out.println(r * Math.cos(sc.fraeser.getDeg()));
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(yCenter + r * Math.sin(sc.fraeser.getDeg()));
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

					sc.refreshDrillPos();

				});
			}

			if (Thread.interrupted()) {
				return;

			}
		}).start();
	}

	public void revcircle(double xRead, double yRead, double xCenter, double yCenter, double sDeg, double eDeg,
			double r, SampleController sc, double speed) {

		new Thread(() -> {

			for (double z = sDeg * Math.PI / 180; z >= eDeg * Math.PI / 180; z = z - Math.PI / 180) {

				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {

					Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),
							sc.fraeser.getDrillDiameter() / 2, sc.drillColor);
					sc.drawPane.getChildren().add(circle);
					sc.circDrill.toFront();

					sc.circDrill.setLayoutX(xCenter - r * Math.cos(sc.fraeser.getDeg()));
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(yCenter - r * Math.sin(sc.fraeser.getDeg()));
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

					sc.refreshDrillPos();

					System.out.println("testeinnenRevCircle");

				});
			}

			if (Thread.interrupted()) {
				return;

			}
		}).start();
	}

	public void lineXFast(double xRead, double yRead, SampleController sc, double dx, double dy, double xToMove,
			double speed) {
		new Thread(() -> {

			for (double i = 0; i < Math.round(xToMove); i = i + Math.abs(dx)) {

				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {

					sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

					System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead
							+ "   " + yRead + "   " + dx + "  " + dy);

					sc.refreshDrillPos();

					System.out.println("testeinnen");
				});
			}

			if (Thread.interrupted()) {
				System.out.println("interrupted");
				return;
			}
		}).start();

	}

	public void lineYFast(double xRead, double yRead, SampleController sc, double dx, double dy, double yToMove,
			double speed) {
		try {
			new Thread(() -> {

				for (double i = 0; i < Math.round(yToMove); i = i + Math.abs(dy)) {

					try {
						Thread.sleep((long) speed);

					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Platform.runLater(() -> {

						sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
						sc.fraeser.setPosX(sc.circDrill.getLayoutX());
						sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
						sc.fraeser.setPosY(sc.circDrill.getLayoutY());

						System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  " + xRead
								+ "   " + yRead + "   " + dx + "  " + dy);

						sc.refreshDrillPos();

						System.out.println("testeinnen");

					});
				}

				if (Thread.interrupted()) {
					return;

				}
			}).start();
		} catch (Exception ignore) {

		}

	}

}
