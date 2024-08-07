import java.io.*;

public class BOJ9663 {
    static int answer = 0;
    static int N;
    static boolean[] col; 
    static boolean[] leftTop; 
    static boolean[] rightTop; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        leftTop = new boolean[2 * N - 1]; 
        rightTop = new boolean[2 * N - 1]; 

        backtracking(0);
        System.out.println(answer);
    }

    public static void backtracking(int r) {
        if (r == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            int d1 = r - c + N - 1; 
            int d2 = r + c; 

            if (!col[c] && !leftTop[d1] && !rightTop[d2]) {

                col[c] = true;
                leftTop[d1] = true;
                rightTop[d2] = true;

                backtracking(r + 1);

                col[c] = false;
                leftTop[d1] = false;
                rightTop[d2] = false;
            }
        }
    }
}
