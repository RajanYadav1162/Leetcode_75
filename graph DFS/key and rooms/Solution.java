class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        this.list = rooms;
        boolean[] visited = new boolean[n];
        dfs(0, visited);
        for(var v : visited) if(!v) return false;
        return true;
    }


    public void dfs(int src, boolean[] visited){
        visited[src] = true;    
        for(int nbh : list.get(src)){
            if(!visited[nbh])
             dfs(nbh, visited);
        }

    }
}
