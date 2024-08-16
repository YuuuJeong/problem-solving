import java.io.*;
import java.util.*;


public class BOJ1759 {
	static int L;
	static int C;
	static StringBuilder sb;
	static char[] chs;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		chs = new char[C];
		for(int i = 0 ; i < C ; i++) {
			chs[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chs);
		char[] cur = new char[L];
		combi(0, 0, cur, 0, 0);
		
		System.out.println(sb.toString());
		
	}
	
	static void combi(int cnt, int start, char[] cur, int aeiou, int other)  {
		if(cnt == L ) {
			if(aeiou >= 1 && other >=2)  sb.append(String.valueOf(cur)).append("\n");
			return;
		}
		
		
		for(int i = start; i < C; i++) {
			cur[cnt] = chs[i];
			boolean flag = "aeiou".contains(String.valueOf(chs[i]));
			combi(cnt+1, i+1, cur, flag == true ? aeiou + 1 : aeiou, flag == true? other: other+1);
		}
	}

}

