package InterviewRelatedAssignment.tier3;

public class Find_Missing_Number {
    public static int missingNumber(int[] nums) {

        int xor = 0;

        for (int i = 1; i <= nums.length + 1; i++) {
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 5};
        int[] nums2 = {1, 2, 4, 5};
        int[] nums3 = {2, 3, 4, 5};

        System.out.println("Missing number: " + missingNumber(nums1));
        System.out.println("Missing number: " + missingNumber(nums2));
        System.out.println("Missing number: " + missingNumber(nums3));
    }
}
