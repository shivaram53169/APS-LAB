class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int leftSum = 0;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            result[i] = (i * nums[i] - leftSum) + (rightSum - (n - 1 - i) * nums[i]);
            leftSum += nums[i];
        }

        return result;
    }
}