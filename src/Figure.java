public abstract class Figure implements Comparable<Figure> {

    public abstract double perimeter();

    public abstract double area();

    @Override
    public int compareTo(Figure f) {
        if (area() == f.area())
            return 0;
        return area() < f.area() ? -1 : 1;
    }
}
