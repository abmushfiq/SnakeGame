package pro;

import processing.core.PApplet;
import processing.core.PVector;

public class MySketch extends PApplet {
	
	private Snake s;
	
	
	PVector food;

	public static void main(String[] args) {
		String[] processingArgs = {"MySketch"};
		MySketch mySketch = new MySketch();
		PApplet.runSketch(processingArgs, mySketch);

	}
	
	
	public void pickLocation() {
		int cols = width/s.scl;
		int rows = height/s.scl;
		
		food = new PVector(floor(random(cols)), floor(random(rows)));
		food.mult(s.scl);
		
	}
	
	
	public void settings(){
		size(600, 600);
		s = new Snake(this);
		
		pickLocation();
		
		
		
		
	}
	
	public void setup() {
		frameRate(10);
	}
	
	public void draw(){
		background(51);
		s.death();
		s.move(); 
		s.show();
		if(s.eat(food)) {
			pickLocation();
		}
		
		
		fill(255,0,100);
		rect(food.x, food.y, s.scl, s.scl);
	}
	
	public void mousePressed() {
		s.total++;
	}
	
	public void keyPressed() {
		if (keyCode == UP) {
			s.dir(0, -1);
		}else if(keyCode == DOWN){
			s.dir(0, 1);
		}else if(keyCode == RIGHT) {
			s.dir(1, 0);
		}else if(keyCode == LEFT) {
			s.dir(-1, 0);
		}
	}
	
	


}
