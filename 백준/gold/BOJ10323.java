import java.io.*;
import java.util.*;

public class BOJ13023 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] friend = new ArrayList[N];
		for(int i = 0; i < N ; i++) {
			friend[i] = new ArrayList<>();
		}
		
		
		for(int i = 0 ; i < M ;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			friend[first].add(second);
			friend[second].add(first);
		}
		
		int ans = 0;
		boolean[] visited = new boolean[N];
		for(int i = 0; i < N ; i++) {
			if(dfs(i, 1, friend, visited)) {
				ans = 1;
				break;
			};
		}
		
		System.out.println(ans);
	}
	
	static boolean dfs(int start, int cnt, ArrayList<Integer>[] friend, boolean[] visited) {
		visited[start] = true;
		if(cnt == 5) {
			return true;
		}
		
		for(int friendNum: friend[start]) {
			if(visited[friendNum]) continue;
			if(dfs(friendNum, cnt+1, friend, visited)) return true;
		}
		
		visited[start] = false;
		return false;
	}

}
