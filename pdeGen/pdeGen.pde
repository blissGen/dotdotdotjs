Box[] boxes = new Box[250];

float r1 = random(0, 255);
float r2 = random(0, 255);
float r3 = random(0, 255);

void setup() {

    size(1000, 1000, P3D);
    background(r1, r2, r3);
    for (int i = 0; i < boxes.length; i++) {
        boxes[i] = new Box();
        boxes[i].display();
    }
    save("output.jpg");
    exit();
}

class Box {

    PVector loc;

    Box() {
        loc = new PVector((width * random(0.3, 0.7)), (height * random(0.3, 0.7)));
    }
    void display() {

        translate(loc.x, loc.y);
        rotateX(random(0, 1));
        rotateY(random(0, 1));
        rotateZ(random(20, 30));

        noFill();
        box(random(125, 250));

        translate(loc.x * random(-0.001, 0.001), loc.y * random(-0.001, 0.001));

    }
}
