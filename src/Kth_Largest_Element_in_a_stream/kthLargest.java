package Kth_Largest_Element_in_a_stream;

import java.util.PriorityQueue;

 class kthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public kthLargest(int k, int [] nums){
        this.k = k;
        minHeap = new PriorityQueue<>();

        for(int num : nums){
            minHeap.offer(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
    }
        public int add(int val){
            minHeap.offer(val);
            if(minHeap.size() > k){
                minHeap.poll();
            }
            return minHeap.peek();
    }
    public static void main(String[] args) {
        kthLargest kthLargest = new kthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }
}
