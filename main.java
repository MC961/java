interface Shape {
    void draw();
}

class Rectangle {
    private int width, height;

    public void drawLegacy() {
        // Use width and height to draw the rectangle
        System.out.println("Drawing a rectangle with width " + width + " and height " + height);
        // ... other drawing logic using width and height
    }
}

class Circle {
    private int radius;

    public void drawLegacy() {
        // Use radius to draw the circle
        System.out.println("Drawing a circle with radius " + radius);
        // ... other drawing logic using radius
    }
}

class RectangleAdapter implements Shape {
    private Rectangle rectangle;

    public RectangleAdapter(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void draw() {
        rectangle.drawLegacy();
    }
}

class CircleAdapter implements Shape {
    private Circle circle;

    public CircleAdapter(Circle circle) {
        this.circle = circle;
    }

    @Override
    public void draw() {
        circle.drawLegacy();
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Circle circle = new Circle();

        Shape rectangleShape = new RectangleAdapter(rectangle);
        Shape circleShape = new CircleAdapter(circle);

        // Now you can use the Shape interface to draw both rectangles and circles
        rectangleShape.draw();
        circleShape.draw();
    }
}