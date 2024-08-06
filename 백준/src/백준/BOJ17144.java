package 백준;

import java.io.*;
import java.util.*;
public class BOJ17144 {
	static int R;
	static int C;
	static int T;
	static int[][] grid;
	static int[][] cleaner = new int[2][2];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] changedAmount;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		grid = new int[R+1][C+1];	
		boolean isCleaner = false;
		for(int r = 1; r <= R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 1; c <= C; c++ ) {
				grid[r][c] = Integer.parseInt(st.nextToken());
				if(grid[r][c] == -1 && isCleaner == false) {
				    cleaner[0] = new int[] {r,c};
				    cleaner[1] = new int[] {r+1,c};
				    isCleaner = true;
				}
			}
		}
		
		while(T > 0 ) {
			spread();
			clean();
			
			T--;
		}
		
		int ans = 0;
		for(int r = 1; r<=R; r++) {
			for(int c = 1; c<=C ;c++){
				if(grid[r][c] == -1) continue;
				ans += grid[r][c];
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void spread() {
		changedAmount = new int[R+1][C+1];
		for(int r = 1; r <= R; r++) {
			for(int c = 1; c<=C; c++) {
				if(grid[r][c] >= 5) {
					int spreadValue = grid[r][c] / 5;
					int count = 0;
					for(int d = 0; d < 4; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(isInGrid(nr, nc) && grid[nr][nc] != -1) {
							changedAmount[nr][nc] += spreadValue;
							count++;
						}
					}
					changedAmount[r][c] -= spreadValue * count;
				}
			}
		}
		
		for(int r = 1; r <= R; r++) {
			for(int c = 1; c<=C; c++) {
				grid[r][c] += changedAmount[r][c];
			}
		}
	}
	
	public static void clean() {
        int upR = cleaner[0][0];
        int downR = cleaner[1][0];

        for (int r = upR - 1; r > 1; r--) grid[r][1] = grid[r - 1][1];
        for (int c = 1; c < C; c++) grid[1][c] = grid[1][c + 1];
        for (int r = 1; r < upR; r++) grid[r][C] = grid[r + 1][C];
        for (int c = C; c > 2; c--) grid[upR][c] = grid[upR][c - 1];
        grid[upR][2] = 0;

        for (int r = downR + 1; r < R; r++) grid[r][1] = grid[r + 1][1];
        for (int c = 1; c < C; c++) grid[R][c] = grid[R][c + 1];
        for (int r = R; r > downR; r--) grid[r][C] = grid[r - 1][C];
        for (int c = C; c > 2; c--) grid[downR][c] = grid[downR][c - 1];
        grid[downR][2] = 0;
    }
	
	public static boolean isInGrid(int r, int c) {
		return r >= 1 && r<= R && c >= 1 && c<=C;
	}
}
