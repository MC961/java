interface DrawingAPI {
    public void drawCircle(double x, double y, double radius);
}

class DrawingAPI1 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %.2f:%.2f radius %.2f\n", x, y, radius);
    }
}

class DrawingAPI2 implements DrawingAPI {
    public void drawCircle(double x, double y, double radius) {
        System.out.printf("API2.circle at %.2f:%.2f radius %.2f\n", x, y, radius);
    }
}

interface Shape {
    public void draw();
    public void resizeByPercentage(double pct);
}

class CircleShape implements Shape {
    private double x, y, radius;
    private DrawingAPI drawingAPI;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.drawingAPI = drawingAPI;
    }

    public void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }

    public void resizeByPercentage(double pct) {
        radius *= (1.0 + pct / 100.0);
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];
        shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI1());
        shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI2());

        for (Shape shape : shapes) {
            shape.resizeByPercentage(25);
            shape.draw();
        }
    }
}