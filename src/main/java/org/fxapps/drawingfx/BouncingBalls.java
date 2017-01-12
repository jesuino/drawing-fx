package org.fxapps.drawingfx;

import javafx.scene.paint.Color;

/**
 * 
 * Just an example of how to use the DrawingApp
 * 
 * @author wsiqueir
 *
 */
public class BouncingBalls extends DrawingApp {

	Ball[] balls = new Ball[20];
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void setup() {
		title = "Bouncing Ball Example";
		width = 800;
		height = 600;
		for (int i = 0; i < balls.length; i++) {
			balls[i] = new Ball(width / 2, height / 2);
		}
	}

	@Override
	public void draw() {
		ctx.setFill(Color.LIGHTGRAY);
		ctx.fillRect(0, 0, width, height);
		for (Ball ball : balls) {
			ball.update();
			ball.show();
		}
	}
	
	class Ball {
		int x, y, r, speedX, speedY;
		Color c;
		
		public Ball(int x, int y) {
			this.x = x;
			this.y = y;
			this.c = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
			r = random.nextInt(100);
			speedX = 40 - random.nextInt(40) - 20;
			speedY = random.nextInt(40) - 20;
		}
		
		void update() {
			this.x+= speedX;
			this.y+= speedY;
			if(x < 0 || x > width - this.r) {
				speedX *= -1;
			}
			if(y < 0 || y > height -this.r) {
				speedY *= -1;
			}
		}
		
		void show() {
			ctx.setFill(c);
			ctx.fillOval(x, y, r, r);
		}
	}
}
