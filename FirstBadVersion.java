import java.util.Scanner;

public class FirstBadVersion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the total number of versions: ");
        int n = scanner.nextInt();

        int firstBadVersion = findFirstBadVersion(n);

        System.out.println("The first bad version is: " + firstBadVersion);
    }

    public static int findFirstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Example implementation of the isBadVersion API (mocked)
    public static boolean isBadVersion(int version) {
        // Implement the actual API logic here
        // This is a mocked implementation for demonstration purposes
        // In a real scenario, this method would be provided externally
        // and would check the version against the product's quality criteria
        return version >= 4; // Assuming version 4 and onwards are bad
    }
}
