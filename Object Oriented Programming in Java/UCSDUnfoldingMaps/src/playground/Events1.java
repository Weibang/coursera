package playground;
import processing.core.*;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

public class Events1 extends PApplet {
	private UnfoldingMap map;
	
	public void setup() {
		size(800, 600, OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
		MapUtils.createDefaultEventDispatcher(this,  map);
	}
	
	public void draw() {
		map.draw();
		
		fill(255, 255, 255);
		rect(100, 100, 25, 25);
		
		fill(100, 100, 100);
		rect(100, 150, 25, 25);
	}
	
	// Change color of background 
	public void keyPressed() {
		if (key == 'w')
			background(255, 255, 255);
		else if (key == 'b')
			background(0, 0, 0);
		else
			background(125, 125, 125);
	}
	
	// Action when mouse left click is released
	public void mouseReleased() {
		if (mouseX > 100 && mouseX < 125 && mouseY > 100 && mouseY < 125)
			background(255, 255, 255);
		else if (mouseX > 100 && mouseX < 125 && mouseY > 150 && mouseY < 175)
			background(100, 100, 100);
	}
}
