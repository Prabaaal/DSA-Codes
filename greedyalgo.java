import java.util.PriorityQueue; 

public class greedyalgo { 
    public int minCost(int[] arr) {

        if (arr == null || arr.length < 2) return 0;

        int cost = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int num : arr) {
            pq.add(num);
        }
        
        while (pq.size() > 1) {
            // Extract the two smallest elements
            int first = pq.poll();
            int second = pq.poll();
            
            // Combine them and add to the total cost
            int combined = first + second;
            cost += combined;
            
            // Add the combined length back to the heap
            pq.add(combined);
        }
        
        return cost;
    }
}