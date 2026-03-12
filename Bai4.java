import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            scanner.close();
            if (line.isEmpty())
                return;
            String[] parts = line.split("[,\\s]+");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                try {
                    nums[i] = Integer.parseInt(parts[i]);
                } catch (NumberFormatException e) {
                    return;
                }
            }

            int maxSum = nums[0];
            int currentSum = nums[0];
            int start = 0, currentStart = 0, end = 0;

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > currentSum + nums[i]) {
                    currentSum = nums[i];
                    currentStart = i;
                } else {
                    currentSum += nums[i];
                }

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    start = currentStart;
                    end = i;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = start; i <= end; i++) {
                sb.append(nums[i]);
                if (i < end) {
                    sb.append(", ");
                }
            }
            System.out.println(sb.toString());
        }
        scanner.close();
    }
}
