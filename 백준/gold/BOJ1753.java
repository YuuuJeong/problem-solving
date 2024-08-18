import java.io.*;
import java.util.*;


public class Main {
	static int V;
	static int E;
	static class Edge{
		int src;
		int dest;
		int distance;
		
		public Edge(int src, int dest, int distance) {
			this.src = src;
			this.dest = dest;
			this.distance = distance;
		}
	}
	
	static HashMap<Integer, List<Edge>> graph;
	
	
	static class Node implements Comparable<Node>{
		int nodeIdx;
		int distance;
		
		public Node(int id, int distance) {
			this.nodeIdx = id;
			this.distance = distance;
		}

		public int compareTo(Node o ) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		graph = new HashMap<>();
		
	
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }
        
		for(int v = 1; v <= E; v++) {
		    st = new StringTokenizer(br.readLine(), " ");
		    int src = Integer.parseInt(st.nextToken());
		    int dest = Integer.parseInt(st.nextToken());
		    int distance = Integer.parseInt(st.nextToken());
		    List<Edge> tmp;
		    if (!graph.containsKey(src)) {
		        tmp = new ArrayList<>();
		        tmp.add(new Edge(src, dest, distance));
		        graph.put(src, tmp);  
		    } else {
		        tmp = graph.get(src);
		        tmp.add(new Edge(src, dest, distance));
		        graph.put(src, tmp); 
		    }
		}

	    int[] distances = dijkstra(start);
	    
	    for (int i = 1; i <= V; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(distances[i]).append("\n");
            }
        }
		System.out.print(sb);
	}
	
	static int[] dijkstra(int start) {
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.distance > distance[current.nodeIdx]) continue;
 
            for (Edge edge : graph.get(current.nodeIdx)) {
                int newDist = current.distance + edge.distance;
                if (newDist < distance[edge.dest]) {
                    distance[edge.dest] = newDist;
                    pq.add(new Node(edge.dest, newDist));
                }
            }
        }

        return distance;
    }

}

