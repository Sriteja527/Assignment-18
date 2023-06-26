import java.util.Scanner;

public class SortColors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of colors: ");
        int n = scanner.nextInt();

        int[] colors = new int[n];
        System.out.println("Enter the colors (0, 1, or 2):");
        for (int i = 0; i < n; i++) {
            colors[i] = scanner.nextInt();
        }

        sortColors(colors);

        System.out.println("Sorted colors:");
        for (int color : colors) {
            System.out.print(color + " ");
        }
    }

    public static void sortColors(int[] colors) {
        int n = colors.length;
        int low = 0;
        int high = n - 1;
        int mid = 0;

        while (mid <= high) {
            if (colors[mid] == 0) {
                swap(colors, low, mid);
                low++;
                mid++;
            } else if (colors[mid] == 1) {
                mid++;
            } else if (colors[mid] == 2) {
                swap(colors, mid, high);
                high--;
            }
        }
    }

    public static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
