import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class pdeGen extends PApplet {

Box[] boxes = new Box[250];

float r1 = random(0, 255);
float r2 = random(0, 255);
float r3 = random(0, 255);

public void setup() {

    
    background(r1, r2, r3);
    for (int i = 0; i < boxes.length; i++) {
        boxes[i] = new Box();
        boxes[i].display();
    }
}

class Box {

    PVector loc;

    Box() {
        loc = new PVector((width * random(0.4f, 0.6f)), (height * random(0.4f, 0.6f)));
    }
    public void display() {

        translate(loc.x, loc.y);
        rotateX(random(0, 1));
        rotateY(random(0, 1));
        rotateZ(random(20, 30));

        noFill();
        box(random(125, 250));

        translate(loc.x * random(-0.001f, 0.001f), loc.y * random(-0.001f, 0.001f));

    }
}
  public void settings() {  size(1000, 1000, P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "pdeGen" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
