package L01WorkingWithAbstraction.Lab.P02PointInRectangle;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterOrEqualThan(Point p) {
        return x >= p.x && y >= p.y;
    }

    public boolean isLessThanOrEqual (Point p) {
        return x <= p.x && y <= p.y;

    }
}
