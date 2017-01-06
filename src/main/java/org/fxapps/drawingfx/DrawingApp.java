package org.fxapps.drawingfx;

import static java.lang.Math.*;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * 
 * Class to quick start drawing with JavaFX. Just extend this class and create your application!
 * 
 * @author wsiqueir
 *
 */
public abstract class DrawingApp extends Application {

	public int frames = 10;
	public String title = "My App";

	public static int width = 600;
	public static int height = 400;

	public static Random random = new Random();

	Canvas canvas = new Canvas();
	GraphicsContext ctx = canvas.getGraphicsContext2D();

	@Override
	public void start(Stage stage) throws Exception {
		setup();
		canvas.setHeight(height);
		canvas.setWidth(width);

		canvas.setOnMouseClicked(this::mouseCliked);
		canvas.setOnMouseDragged(this::mouseDragged);
		canvas.setOnMouseMoved(this::mouseMoved);
		canvas.setOnMouseEntered(this::mouseEntered);
		canvas.setOnMouseExited(this::mouseExited);
		canvas.setOnKeyPressed(this::keyPressed);
		canvas.setOnKeyTyped(this::keyTyped);
		canvas.setOnKeyReleased(this::keyReleased);

		StackPane raiz = new StackPane(canvas);
		stage.setTitle(title);
		stage.setScene(new Scene(raiz, width, height));
		stage.show();

		canvas.requestFocus();
		KeyFrame frame = new KeyFrame(Duration.millis(1000 / frames), e -> draw());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	// classical setup and draw methods from Processing

	public void setup() {
	}

	public void draw() {
	}

	// event listeners - if user override the method with event, the method
	// without event won't be called
	public void mouseCliked(MouseEvent e) {
		mouseCliked();
	}

	public void mouseDragged(MouseEvent e) {
		mouseDragged();
	}

	public void mouseMoved(MouseEvent e) {
		mouseMoved();
	}

	public void mouseEntered(MouseEvent e) {
		mouseEntered();
	}

	public void mouseExited(MouseEvent e) {
		mouseExited();
	}

	public void keyPressed(KeyEvent e) {
		keyPressed();
	}

	public void keyTyped(KeyEvent e) {
		keyTyped();
	}

	public void keyReleased(KeyEvent e) {
		keyReleased();
	}

	public void mouseCliked() {
	}

	public void mouseDragged() {
	}

	public void mouseMoved() {
	}

	public void mouseEntered() {
	}

	public void mouseExited() {
	}

	public void keyPressed() {
	}

	public void keyTyped() {
	}

	public void keyReleased() {
	}

	/*
	 * Utility methods
	 */
	public double distance(double x, double y, double x2, double y2) {
		return sqrt(pow(x2 - x, 2) + pow(y2 - y, 2));
	}

}