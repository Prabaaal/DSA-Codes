class Solution {
    void fun(int v, ArrayList<ArrayList<Integer>>adj,int[] in_degree,ArrayList<Integer>ans){
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<v;i++) if (in_degree[i]== 0)q.offer(i);
        
        while (!q.isEmpty()){
            int i = q.poll();
            ans.add(i);
            for (int x: adj.get(i)){
                in_degree[x]--;
                if(in_degree[x] == 0) q.offer(x);
            }
            }
        }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0; i<V;i++) adj.add(new ArrayList<Integer>());
        for(int[] x: edges) adj.get(x[0]).add(x[1]);
        
        ArrayList<Integer> ans = new ArrayList<>();
        int[] in_degree = new int[V];
        
        for(int i=0; i<V; i++){
            for(int x: adj.get(i)) in_degree[x]++;
        }
        fun(V,adj,in_degree,ans);
        return ans;
    }
}