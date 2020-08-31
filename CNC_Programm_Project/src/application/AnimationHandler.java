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

//	public void circle(double xEnd, double yEnd, SampleController sc, double dx, double dy) {
//
//		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() {
//
//			public void handle(ActionEvent t) {
//
//				if (sc.fraeser.getPosX() < (xEnd / 2) || sc.fraeser.getPosY() < (yEnd / 2)) {
//					if (sc.fraeser.getPosX() >= xEnd / 2) {
//						final double dx = 0;
//					}
//
//					else if (sc.fraeser.getPosY() >= yEnd / 2) {
//						final double dy = 0;
//					}
//					Circle circle = new Circle(sc.fraeser.getPosX(), sc.fraeser.getPosY(),
//							sc.fraeser.getDrillDiameter() / 2, sc.drillColor);
//					sc.drawPane.getChildren().add(circle);
//					sc.circDrill.toFront();
//
//					sc.circDrill.setLayoutX(sc.circDrill.getLayoutX() + dx);
//					sc.fraeser.setPosX(sc.circDrill.getLayoutX());
//					sc.circDrill.setLayoutY(sc.circDrill.getLayoutY() + dy);
//					sc.fraeser.setPosY(sc.circDrill.getLayoutY());
//				}
//				sc.refreshDrillPos();
//
//			}
//		}));
//
//		timeline.setCycleCount(Timeline.INDEFINITE);
//		timeline.play();
//	}

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
