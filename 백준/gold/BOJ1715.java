import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>();
		for(int i = 0 ; i < N ; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		int ans = 0;
		int cnt = 0;
		int sum = 0;
		while(!pq.isEmpty()) {
		
			sum += pq.poll();
			cnt ++;
			if(cnt == 2) {
				pq.add(sum);
				ans+= sum;
				sum = 0; 
				cnt = 0;
			}
			
		}
		
		System.out.println(ans);
	}

}
