import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Min-heap to store the top k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            // Maintain heap size of k
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}