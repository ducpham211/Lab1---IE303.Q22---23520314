import java.util.*;

public class Bai3 {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if (this.x != other.x) {
                return Integer.compare(this.x, other.x);
            }
            return Integer.compare(this.y, other.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static long cross(Point O, Point A, Point B) {
        return (long)(A.x - O.x) * (B.y - O.y) - (long)(A.y - O.y) * (B.x - O.x);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            points.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }

        if (n <= 3) {
            for (Point p : points) {
                System.out.println(p);
            }
            return;
        }

        Collections.sort(points);

        List<Point> upper = new ArrayList<>();
        for (Point p : points) {
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) >= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        List<Point> lower = new ArrayList<>();
        for (int i = points.size() - 1; i >= 0; i--) {
            Point p = points.get(i);
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) >= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> hull = new ArrayList<>(upper);
        for (int i = 1; i < lower.size() - 1; i++) {
            hull.add(lower.get(i));
        }

        for (Point p : hull) {
            System.out.println(p);
        }
        
        scanner.close();
    }
}
