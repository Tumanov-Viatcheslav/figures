public class Rectangle extends Figure {
    double a, b;

    public double perimeter() {
        return 2 * (a + b);
    }

    public double area() {
        return a * b;
    }

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0)
            throw new RuntimeException("Rectangle's side should be positive");
        this.a = a;
        this.b = b;
    }
}
