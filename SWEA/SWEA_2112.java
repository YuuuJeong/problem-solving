import java.io.*;
import java.util.*;

class Solution
{
	static int[][] grid;
    
    static int D;
    static int W;
    static int K;
    static ArrayList<int[]> candidates;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T ;t++) {

            st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            grid = new int[D][W];
            answer = 0;
            for(int r = 0 ; r < D; r++ ) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < W ; c++) {
                    grid[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            if(solution() != 0) {
	            exit:for(int i = 1; i < D; i++) {
	                candidates = new ArrayList<>();
	                
	           
	                backtracking(i, new int[i], 0, 0);
	
	                for(int target = 0 ; target < candidates.size(); target++) {
	                	if(changeGrid(candidates.get(target))) {
	                		answer = i;
	                		break exit;
	                	}
	                }
	
	            }
            }
            sb.append("#").append(t).append(" ").append(answer);
            System.out.println(sb.toString());
        }    
        
  
  
   
    }
    
    public static void backtracking(int size, int[] temp, int tempCount, int start){

        if(size == tempCount) {
            candidates.add(temp.clone());
            return;
        }
        
        for(int r = start; r <  D ; r++) {
            temp[tempCount] = r;
            backtracking(size, temp, tempCount+1, r+1 );
        }
    }
    
    public static boolean changeGrid(int[] targetRow) {
        int[][] originRow = new int[targetRow.length][W];
        
        for(int r = 0 ; r < targetRow.length; r++) {
        	for(int c = 0 ; c < grid[targetRow[r]].length; c++) {
        		originRow[r][c] = grid[targetRow[r]][c];
        	}
        }
        
        if(changeRow(targetRow, 0)) {
        	return true;
        }
        
        for(int r = 0 ; r < targetRow.length; r++) {
        	for(int c = 0 ; c < grid[targetRow[r]].length; c++) {
        		grid[targetRow[r]][c] = originRow[r][c];
        	}
        }

        return false;
        
    }
    
    public static boolean changeRow(int[] targetRow, int index) {
        if (index == targetRow.length) {
            return solution() == 0;
        }

        for (int i = 0; i < 2; i++) {
            Arrays.fill(grid[targetRow[index]], i);
            if (changeRow(targetRow, index + 1)) {
                return true;
            }
        }
        return false;
    }
    
    public static int solution() {
        int count = 0;
        
        for(int c = 0 ; c < W ; c++) {
            int sequenceCount = 1;
            for(int r = 1 ; r < D ;r++) {
                if(grid[r][c] == grid[r-1][c]) sequenceCount += 1;
                else sequenceCount = 1;
                
                if(sequenceCount >= K) break;
            }
            if(sequenceCount < K) count++;
        }
        

        return count;
    }
}
