package InterviewRelatedAssignment.tier3;

import java.util.Arrays;

public class Merge_Two_Sorted_Array {
    public static void merge(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;

        int gap = nextGap(n + m);

        while (gap > 0) {

            int i = 0;
            int j = gap;

            while (j < n + m) {

                int first = get(a, b, i);
                int second = get(a, b, j);

                if (first > second) {
                    set(a, b, i, second);
                    set(a, b, j, first);
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    private static int get(int[] a, int[] b, int index) {
        if (index < a.length)
            return a[index];

        return b[index - a.length];
    }

    private static void set(int[] a, int[] b, int index, int value) {
        if (index < a.length)
            a[index] = value;
        else
            b[index - a.length] = value;
    }

    public static void main(String[] args) {

        int[] a = {1, 4, 7, 8, 10};
        int[] b = {2, 3, 9};

        System.out.println("Before merging:");
        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));

        merge(a, b);

        System.out.println("\nAfter merging:");
        System.out.println("Array A: " + Arrays.toString(a));
        System.out.println("Array B: " + Arrays.toString(b));

    }
}
