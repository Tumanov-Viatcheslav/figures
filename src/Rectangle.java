public class Rectangle extends Figure {
    int a, b;

    public int perimeter() {
        return 2 * (a + b);
    }

    public double area() {
        return a * b;
    }

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
