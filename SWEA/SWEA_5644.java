import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class SWEA_5644 {
    static int M, bcCnt; 
    static int[] pathA, pathB, playerA, playerB;
    static int[][] bc;
    
    static int[] dx = {0, 0, 1, 0, -1}; 
    static int[] dy = {0, -1, 0, 1, 0};
    
    public static void main(String[] args) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        playerA = new int[2];
        playerB = new int[2];
        
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); 
            bcCnt = Integer.parseInt(st.nextToken()); 
            
            playerA[0] = playerA[1] = 1;
            playerB[0] = playerB[1] = 10;
            
            pathA = new int[M + 1];
            pathB = new int[M + 1]; 
            bc = new int[bcCnt][4]; 
            
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < M + 1; i++) { 
                pathA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < M + 1; i++) {
                pathB[i] = Integer.parseInt(st.nextToken());
            }
            
            for(int i = 0; i < bcCnt; i++) { 
                st = new StringTokenizer(br.readLine());
                bc[i][0] = Integer.parseInt(st.nextToken()); 
                bc[i][1] = Integer.parseInt(st.nextToken());
                bc[i][2] = Integer.parseInt(st.nextToken());
                bc[i][3] = Integer.parseInt(st.nextToken()); 
            }
            
            sb.append("#").append(tc).append(" ").append(move()).append("\n");
        }

        System.out.print(sb.toString());
    }
    
    public static int move(){
        int totalSum = 0;

        for(int t = 0; t < M + 1; t++) { 

            playerA[0] += dx[pathA[t]];
            playerA[1] += dy[pathA[t]];
            playerB[0] += dx[pathB[t]];
            playerB[1] += dy[pathB[t]];

            totalSum += getMaxCharge();
        }
        return totalSum;
    }
    
    public static int check(int a, int x, int y) {
        return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
    }
    
    public static int getMaxCharge() {
        int max = 0;
        for(int a = 0; a < bcCnt; a++) { 
            for(int b = 0; b < bcCnt; b++) { 
                int sum = 0;
                int amountA = check(a, playerA[0], playerA[1]);
                int amountB = check(b, playerB[0], playerB[1]);
                
                if(a != b) 
                    sum = amountA + amountB;
                else 
                    sum = Math.max(amountA, amountB);
                
                if(max < sum)
                    max = sum;
            }
        }
        return max;
    }
}
