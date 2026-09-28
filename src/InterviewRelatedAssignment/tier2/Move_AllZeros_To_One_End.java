package InterviewRelatedAssignment.tier2;

import java.util.Arrays;

public class Move_AllZeros_To_One_End {
    public static void moveZeros(int[] arr) {
        int index = 0;

        for (int num : arr) {
            if (num != 0) {
                arr[index++] = num;
            }
        }

        while (index < arr.length) {
            arr[index++] = 0;
        }
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 0, 1, 0, 1, 2, 0, 6};

        moveZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
