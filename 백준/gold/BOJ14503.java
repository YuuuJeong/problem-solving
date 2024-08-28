import java.io.*;
import java.util.*;
public class BOJ14503 {
	static int N, M;
	static int[][] grid;
	static int[][] direction = {{-1,0}, {0,1}, {1,0}, {0,-1}};
	static int[] convertDirection = {3,0,1,2};
	static int[] reverseDirection = {2,3,0,1};
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream(""))
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		grid = new int[N][M];
		st = new StringTokenizer(br.readLine());
		int startR = Integer.parseInt(st.nextToken());
		int startC = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());
		
		//0 청소되지않음, 1은 
		
		for(int r = 0; r < N ; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < M ; c++) {
				grid[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = solution(startR, startC, direction);
		System.out.println(ans);
        br.close();
	}
	
	public static int solution(int startR, int startC, int startD) {
		int cnt = 0;
		while(true) {
			if(grid[startR][startC] == 0) {
				cnt ++;
				grid[startR][startC] = 2;
			}
			else {
//				System.out.println("asd!!@@@");
				boolean isCleaned = checkFourDirection(startR, startC);
//				System.out.println(isCleaned);
				if(!isCleaned) {
					if(!canMoveBack(startR, startC, startD)) break;
					else {
						int convertedD = reverseDirection[startD];
						int[] curDirection = direction[convertedD];
						startR = startR + curDirection[0];
						startC = startC + curDirection[1];
					}
				} else {
					startD = convertDirection[startD];
					int nr = startR+direction[startD][0];
					int nc = startC +direction[startD][1];
//					System.out.println(nr+" " +nc);
					if(isInGrid(nr,nc) && grid[nr][nc] == 0) {
						startR = nr;
						startC = nc;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean checkFourDirection(int curR, int curC) {
		for(int d = 0; d < 4 ; d++) {
			int nr = curR + direction[d][0];
			int nc = curC + direction[d][1];
			if(isInGrid(nr,nc) && grid[nr][nc] == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean canMoveBack(int r, int c, int d) {
		int convertedD = reverseDirection[d];
		int[] curDirection = direction[convertedD];
		int nr = r + curDirection[0];
		int nc = c+ curDirection[1];
		if(isInGrid(nr,nc) && grid[nr][nc] != 1) return true;
		return false;
	}
	
	public static boolean isInGrid(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
