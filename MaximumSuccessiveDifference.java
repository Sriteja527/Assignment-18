import java.util.Arrays;
import java.util.Scanner;

public class MaximumSuccessiveDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int maxDifference = maximumSuccessiveDifference(nums);
        System.out.println("The maximum difference between two successive elements is: " + maxDifference);
    }

    public static int maximumSuccessiveDifference(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int maxDifference = 0;
        int n = nums.length;

        // Find the maximum element to determine the number of digits
        int maxElement = Arrays.stream(nums).max().getAsInt();

        // Perform radix sort
        for (int exp = 1; maxElement / exp > 0; exp *= 10) {
            int[] count = new int[10];
            int[] output = new int[n];

            // Counting sort based on the current digit
            for (int num : nums) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }

            // Update count array to contain actual positions
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            // Build the sorted array
            for (int i = n - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                output[count[digit] - 1] = nums[i];
                count[digit]--;
            }

            // Update the input array for the next iteration
            System.arraycopy(output, 0, nums, 0, n);
        }

        // Calculate the maximum difference
        for (int i = 1; i < n; i++) {
            maxDifference = Math.max(maxDifference, nums[i] - nums[i - 1]);
        }

        return maxDifference;
    }
}
