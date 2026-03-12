import java.util.Scanner;
import java.util.Random;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long totalPoints = 10000000;
        
        long insideCircle = 0;
        Random rand = new Random();
        for (long i = 0; i < totalPoints; i++) {
            double x = rand.nextDouble() * 2 - 1;
            double y = rand.nextDouble() * 2 - 1;
            if (x * x + y * y <= 1) {
                insideCircle++;
            }
        }
        
        double pi = (double) insideCircle / totalPoints * 4;
        System.out.println("Gia tri pi xap xi: " + pi);
        scanner.close();
    }
}
