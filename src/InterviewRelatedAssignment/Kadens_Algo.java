package InterviewRelatedAssignment;

public class Kadens_Algo {

    public static int maxSubarraySum(int[] arr) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            ans = Math.max(ans, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};

        System.out.println(maxSubarraySum(arr));
    }
}
