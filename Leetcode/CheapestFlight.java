/*
787. Cheapest Flights Within K Stops

There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost price'i'.
You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.

Example 1:
Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
Output: 200
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.

Example 2:
Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
Output: 700
Explanation:
The graph is shown above.
The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
*/

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int []>> adj = new HashMap<>();
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[src] = 0;

        for(int [] flight : flights) {
            // System.out.println(Arrays.toString(flight));
            adj.computeIfAbsent(flight[0], key -> new ArrayList<>()).add(new int [] {flight[1], flight[2]});
        }

        // System.out.println(adj);

        Queue<int []> q = new LinkedList<>();
        q.offer(new int [] {src, 0});
        K++;

        while(!q.isEmpty() && K-- > 0) {
            int size = q.size();
            while(size-- > 0){
                int [] curr = q.poll();
                int curNode = curr[0];
                int curPrice = curr[1];
                
                if(adj.containsKey(curNode)) {
                    for(int [] neighbor : adj.get(curNode)) {
                        int newPrice = curPrice + neighbor[1];
                        if(newPrice < visited[neighbor[0]]) {
                            visited[neighbor[0]] = newPrice;
                            q.offer(new int [] {neighbor[0], newPrice});
                        }
                    }
                }                
            }
        }

        return visited[dst] == Integer.MAX_VALUE ? -1 : visited[dst];
    }
}