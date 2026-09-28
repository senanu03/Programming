package InterviewRelatedAssignment.tier3;

import java.util.Arrays;

public class Array_Rotation {
    public static void rotate(int[] nums, int k) {

        int n = nums.length;

        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int left, int right) {

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println("Before rotation: " + Arrays.toString(nums));

        rotate(nums, k);

        System.out.println("After rotation:  " + Arrays.toString(nums));
    }
}
