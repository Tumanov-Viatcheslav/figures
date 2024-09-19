import java.util.Comparator;

public class FiguresAreaComparator implements Comparator<Figure> {
    @Override
    public int compare(Figure o1, Figure o2) {
        if (o1.area() == o2.area())
            return 0;
        return o1.area() < o2.area() ? -1 : 1;
    }
}
