import java.io.*;
import java.util.*;

public class BOJ18428 {
	static char[][] grid;
    static int N;
    static List<int[]> teacherPos;
    static List<int[]> wallCandidates;
    static int teacherCount;
    static int[][] direction = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        grid = new char[N][N];
        teacherCount = 0;
        wallCandidates = new ArrayList<>();
        teacherPos = new ArrayList<>();
        
        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                char ch = st.nextToken().charAt(0);
                grid[r][c] = ch;
                if(ch == 'T') teacherPos.add(new int[]{r,c});
                else if(ch == 'X') wallCandidates.add(new int[] {r,c});
            }
        }
        
        boolean result = dfs(0,0);
        if(result) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        
        System.out.println(sb.toString());
    }
    
    public static boolean dfs(int idx, int cnt) {
        if(cnt == 3) return check();
        
        for(int i = idx; i < wallCandidates.size(); i++) {
            int[] wall = wallCandidates.get(i);
            int wallR = wall[0];
            int wallC = wall[1];
            grid[wallR][wallC] = 'O';
            if(dfs(i+1, cnt+1)) return true;
            grid[wallR][wallC] = 'X';
        }
        
        return false;
    }
    
    public static boolean check() {
        for(int[] tPos : teacherPos) {
            int r = tPos[0];
            int c = tPos[1];
            for(int[] d : direction) {
                int nr = r + d[0];
                int nc = c + d[1];
                while(isInGrid(nr, nc)) {
                    if(grid[nr][nc] == 'S') return false;
                    if(grid[nr][nc] == 'O') break;
                    nr += d[0];
                    nc += d[1];
                }
            }
        }
        return true;
    }
    
    public static boolean isInGrid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}
