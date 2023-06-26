import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();

        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time for interval " + (i + 1) + ": ");
            int start = scanner.nextInt();
            System.out.print("Enter end time for interval " + (i + 1) + ": ");
            int end = scanner.nextInt();
            intervals[i] = new Interval(start, end);
        }

        Interval[] mergedIntervals = mergeIntervals(intervals);
        System.out.println("Merged intervals:");
        for (Interval interval : mergedIntervals) {
            System.out.println("[" + interval.start + ", " + interval.end + "]");
        }
    }

    public static Interval[] mergeIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        List<Interval> merged = new ArrayList<>();
        Interval current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start <= current.end) {
                current.end = Math.max(current.end, intervals[i].end);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }

        merged.add(current);

        return merged.toArray(new Interval[merged.size()]);
    }
}
