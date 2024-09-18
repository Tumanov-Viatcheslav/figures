public class Rectangle extends Figure {
    int a, b;

    public int perimeter() {
        return 2 * (a + b);
    }

    public double area() {
        return a * b;
    }

    public Rectangle(int a, int b) {
        if (a <= 0 || b <= 0)
            throw new RuntimeException("Rectangle's side should be positive");
        this.a = a;
        this.b = b;
    }
}
