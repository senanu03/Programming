package InterviewRelatedAssignment.tier3;

public class Minimum_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {

                minLength = Math.min(
                        minLength,
                        right - left + 1
                );

                sum -= nums[left++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};

        int target2 = 4;
        int[] nums2 = {1, 4, 4};

        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("Minimum length: " + minSubArrayLen(target1, nums1));

        System.out.println("Minimum length: " + minSubArrayLen(target2, nums2));

        System.out.println("Minimum length: " + minSubArrayLen(target3, nums3));
    }
}
