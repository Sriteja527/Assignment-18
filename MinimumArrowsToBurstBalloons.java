import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MinimumArrowsToBurstBalloons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of balloons: ");
        int n = scanner.nextInt();

        int[][] points = new int[n][2];
        System.out.println("Enter the coordinates of the balloons:");
        for (int i = 0; i < n; i++) {
            System.out.print("Balloon " + (i + 1) + ": ");
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        int minArrows = findMinArrows(points);
        System.out.println("Minimum number of arrows required: " + minArrows);
    }

    public static int findMinArrows(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the balloons based on their end coordinates
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int arrows = 1; // Initialize with one arrow
        int end = points[0][1]; // Set the end coordinate of the first balloon

        // Iterate through the remaining balloons
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                // Balloon is not overlapping with the previous balloon
                arrows++; // Increment the arrow count
                end = points[i][1]; // Update the end coordinate
            }
        }

        return arrows;
    }
}
