package InterviewRelatedAssignment.tier2;

public class Max_Product_Subarray {

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            if (num < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(num, max * num);
            min = Math.min(num, min * num);

            answer = Math.max(answer, max);
        }

        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
