
import java.io.*;
import java.util.*;

public class SWEA_2117 {
	static int N;
	static int M;
	static int[][] grid;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		for(int i = 1; i<= T; i++) {
			answer = 0;
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grid = new int[N][N];
			
			for(int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int c = 0 ; c < N; c++) {
					grid[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			solution();
			sb.append("#").append(i).append(" ").append(answer);
			System.out.println(sb.toString());
		}
	}
	
	public static void solution() {

		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				for(int k = 1; k <= N+1; k++) {
					int count = 0 ;
					int index = 0 ;
					for(int i = k - 1; i >= 0 ; i--) {
						int upR = r - index;
						int downR = r + index;
						
						for(int rightC = c; rightC <= i+c ; rightC++) {
							if(!isInGrid(upR, rightC)) break;
							if(grid[upR][rightC] == 1) count++;
						}
						
						for(int leftC = c-1; leftC >= c-i ; leftC--) {
							if(!isInGrid(upR, leftC)) break;
							if(grid[upR][leftC] == 1) count++;
						}
						
						if(upR != downR) {
							for(int rightC = c; rightC <= i+c ; rightC++) {
								if(!isInGrid(downR, rightC)) break;
								if(grid[downR][rightC] == 1) count++;
							}
							
							for(int leftC = c-1; leftC >= c-i ; leftC--) {
								if(!isInGrid(downR, leftC)) break;
								if(grid[downR][leftC] == 1) count++;
							}
						}
						index++;
					}
					
					calculateMax(count, k, r,c);
					
				} 
			}
		}
	}
	
	public static void calculateMax(int count, int k, int r, int c) {
//		System.out.println(r + " " + c + " " + count + " " + k);
		if(M * count - (k * k + (k-1) * (k-1)) >= 0) {
			answer = Math.max(answer,  count);
		}

		
	}
	
	public static boolean isInGrid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
