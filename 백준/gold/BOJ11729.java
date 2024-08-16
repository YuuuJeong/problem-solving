import java.io.*;
public class BOJ11729 {


		static StringBuilder sb = new StringBuilder();
		static Integer ans = 0;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
			int N = Integer.parseInt(br.readLine());
	 
	 
			Hanoi(N, 1, 2, 3);
			System.out.println(ans);
			System.out.println(sb.toString());
		}
	 
		public static void Hanoi(int N, int src, int mid, int dest) {
			ans++;
			if (N == 1) {
				sb.append(src+ " " + dest+ "\n");
				return;
			}
	 
			Hanoi(N - 1, src, dest, mid);

			sb.append(src + " " + dest + "\n");

			Hanoi(N - 1, mid, src, dest);
		}
	
}

