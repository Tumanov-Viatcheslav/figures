public class Triangle extends Figure {
    double a, b, c;

    public double perimeter() {
        return a + b + c;
    }

    public double area() {
        double semiPerimeter = perimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c));
    }

    public Triangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new RuntimeException("Triangle's side should be positive");
        double max = a, rest = b + c;
        if (a < b)
            if (b < c) {
                max = c;
                rest = a + b;
            }
            else {
                max = b;
                rest = a + c;
            }
        if (max >= rest)
            throw new RuntimeException("Triangle's side should be smaller than other two");
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
