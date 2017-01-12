package org.fxapps.drawingfx;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
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

	public static int width = 600;
	public static int height = 400;

	public int frames = 10;
	public String title = "My App";
	public Color background = Color.LIGHTGRAY;
	public double mouseY;
	public double mouseX;

	public static Random random = new Random();

	public Canvas canvas = new Canvas();
	public GraphicsContext ctx = canvas.getGraphicsContext2D();
	
	
	private BorderPane raiz;
	private Scene scene;

	@Override
	public void start(Stage stage) throws Exception {
		raiz = new BorderPane();
		scene =  new Scene(raiz);
		setup();
		canvas.setHeight(height);
		canvas.setWidth(width);

		canvas.setOnMouseClicked(this::mouseCliked);
		canvas.setOnMouseDragged(this::mouseDragged);
		canvas.setOnMouseMoved(this::internalMouseMoved);
		canvas.setOnMouseEntered(this::mouseEntered);
		canvas.setOnMouseExited(this::mouseExited);
		canvas.setOnKeyPressed(this::keyPressed);
		canvas.setOnKeyTyped(this::keyTyped);
		canvas.setOnKeyReleased(this::keyReleased);

		raiz.setCenter(canvas);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();

		canvas.requestFocus();
		KeyFrame frame = new KeyFrame(Duration.millis(1000 / frames), e -> draw());
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		ctx.setFill(background);
		ctx.fillRect(0, 0, width, height);
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
	
	private void internalMouseMoved(MouseEvent e) {
		this.mouseX = abs(canvas.getLayoutX() - e.getSceneX());
		this.mouseY = abs(canvas.getLayoutY() - e.getSceneY());
		mouseMoved(e);
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
	
	// css for the whole scene
	public void applyCSS(String css) {
		scene.getStylesheets().add(css);
	}
	
	// space for users who want to add UI controls
	
	public void setBottom(Node n) {
		raiz.setBottom(n);
	}
	
	public void setTop(Node n) {
		raiz.setTop(n);
	}

	/*
	 * Utility methods
	 */
	public double distance(double x, double y, double x2, double y2) {
		return sqrt(pow(x2 - x, 2) + pow(y2 - y, 2));
	}
	
}