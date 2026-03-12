import java.util.Scanner;
import java.util.Random;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Xap xi dien tich hinh tron ---");
        System.out.print("Nhap ban kinh r: ");
        if (scanner.hasNextDouble()) {
            double r = scanner.nextDouble();
            long totalPoints = 10000000; // So luong diem de mo phong Monte Carlo
            long insideCircle = 0;
            Random rand = new Random();
            
            for (long i = 0; i < totalPoints; i++) {
                double x = (rand.nextDouble() * 2 * r) - r;
                double y = (rand.nextDouble() * 2 * r) - r;
                if (x * x + y * y <= r * r) {
                    insideCircle++;
                }
            }
            
            double area = (double) insideCircle / totalPoints * (4 * r * r);
            System.out.println("Dien tich hinh tron xap xi: " + area);
            System.out.println("Dien tich thuc te (pi * r^2): " + (Math.PI * r * r));
        }
        scanner.close();
    }
}
