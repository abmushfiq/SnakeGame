package pro;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;

public class Snake {
	private PApplet sketch;
	
	private float x;
	private float y;
	private float xspeed = 1;
	private float yspeed = 0;
	int scl = 10;
	
	int total = 0;
	 ArrayList<PVector> tail = new ArrayList<PVector>(); 
	
	
	public Snake(PApplet sketch) {
		this.sketch = sketch;

		
	}
	
	public void death() {
		for(int i =0; i<tail.size()-1; i++) {
			PVector pos = tail.get(i);
			float dis = sketch.dist(this.x, this.y,pos.x ,pos.y );
			
			if(dis<1) {
				this.total=0;
				this.tail.clear();
			}
		}
	}
	
	public void move() {
		if (total > 0) {
		      if (total == tail.size() && !tail.isEmpty()) {
		        tail.remove(0);
		      }
		      tail.add(new PVector(x, y));
		    }
		
		x = x + xspeed*scl;
		y = y+yspeed*scl;
		
		
		
		
		this.x = sketch.constrain(this.x, 0, sketch.width-scl);
		this.y = sketch.constrain(this.y, 0, sketch.height-scl);
	}
	
	public void show() {
		
		sketch.fill(255);
		 for (PVector v : tail) {
		      sketch.rect(v.x, v.y, scl, scl);
		    }
		
		 sketch.fill(255);
		sketch.rect(this.x, this.y, scl, scl);
	}
	
	
	public void dir(float a,float b) {
		this.xspeed = a;
		this.yspeed = b;
	}

	public boolean eat(PVector food) {
		 float d = sketch.dist(this.x, this.y, food.x, food.y); 
		 
		 if(d<1) {
			 this.total++;
			 return true;
		 }else {
			 return false;
		 }
		
	}
	
	

}
