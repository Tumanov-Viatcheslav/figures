public class Triangle extends Figure {
    int a, b, c;

    public int perimeter() {
        return a + b + c;
    }

    public double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
