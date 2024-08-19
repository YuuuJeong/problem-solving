import java.io.*;
import java.util.*;

public class BOJ2589 {
	static int R,C;
    static int moveY[] = {-1,0,1,0};
    static int moveX[] = {0,1,0,-1};
    static char arr[][];
    static boolean visit[][];
    
    static class Pos{
        int x;
        int y;
        int cnt;
        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        visit = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int result = 0;
        
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 'L') {
                    visit = new boolean[R][C];
                    int val = bfs(i,j);
                    result = Math.max(result, val);
                    
                }
            }
        }
        
        System.out.println(result);
        
    }
    static int bfs(int i, int j) {
        Queue<Pos> queue = new LinkedList<>();
        int val = 0;
        visit[i][j] = true;
        queue.add(new Pos(j,i,0));
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            for(int d=0; d<4; d++) {
                int newX = p.x + moveX[d];
                int newY = p.y + moveY[d];
                if(0<=newX && newX<C && 0<=newY && newY<R && !visit[newY][newX] && arr[newY][newX]=='L') {
                    visit[newY][newX] = true;
                    queue.add(new Pos(newX, newY, p.cnt+1));
                    val = Math.max(val, p.cnt+1);
                }
            }
        }
        return val;
    }
   

}

