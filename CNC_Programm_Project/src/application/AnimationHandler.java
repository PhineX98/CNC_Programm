package application;

import javafx.application.Platform;
import javafx.scene.shape.Circle;


/**
 * Diese Klasse implementiert die Handhabung der Animation des Fräsvorgangs
 *
 * @author Jannik Orth
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

	
	public void circle (double xRead,double yRead,double xCenter, double yCenter,double targetDeg, double r,SampleController sc, double speed) {
		System.out.println("forfor");
			new Thread(() -> {
				System.out.println("forfor IN");
				System.out.println(targetDeg);
			for (double z = 0; z < targetDeg; z = z + 0.5) {
				System.out.println(z + "   " + targetDeg);
				sc.fraeser.setDeg(z);
				//sc.fraeser.getDeg();
				try {
					//Thread.sleep((long) speed);
					Thread.sleep(100);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {
					
					sc.circDrill.setLayoutX(xCenter +  r*Math.cos(sc.fraeser.getDeg()));//*180/Math.PI);
					System.out.println(r*Math.cos(sc.fraeser.getDeg()));//*180/Math.PI);
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(yCenter + r*Math.sin(sc.fraeser.getDeg()));//*180/Math.PI);
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

//					System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  Winkel:" + sc.fraeser.getDeg()
//							+ "   dx" + r*Math.cos(sc.fraeser.getDeg())*180/Math.PI + "   dy" + r*Math.sin(sc.fraeser.getDeg())*180/Math.PI);

					sc.refreshDrillPos();

					//System.out.println("testeinnen");
					

				});
			}

			if (Thread.interrupted()) {
				return;

			}
		}).start();
	}
	
	public void revcircle (double xRead,double yRead,double xCenter, double yCenter,double targetDeg, double r,SampleController sc, double speed) {
		new Thread(() -> {

			for (double z = targetDeg; z > 0; z = z - 0.5) {

				try {
					Thread.sleep((long) speed);

				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				Platform.runLater(() -> {
					double iterator = targetDeg;
					sc.circDrill.setLayoutX(xCenter +  r*Math.cos(iterator)*180/Math.PI);
					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
					sc.circDrill.setLayoutY(yCenter + r*Math.sin(iterator)*180/Math.PI);
					sc.fraeser.setPosY(sc.circDrill.getLayoutY());

					System.out.println(sc.circDrill.getLayoutX() + "  " + sc.circDrill.getLayoutY() + "  Winkel:" + iterator
							+ "   dx" + r*Math.cos(iterator)*180/Math.PI + "   dy" + r*Math.sin(iterator)*180/Math.PI);

					sc.refreshDrillPos();

					System.out.println("testeinnenRevCircle");
					iterator -= 0.5;
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
