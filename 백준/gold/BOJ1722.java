public class BOJ1722 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        boolean[] v = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = i + 1;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            long K = Long.parseLong(st.nextToken()) - 1; 
            int cnt = N;
            while (cnt > 0) {
                long result = fact(cnt - 1);
                int mod = (int) (K / result);
                K -= result * mod;
                int idx = 0;
                for (int i = 0; i < N; i++) { 
                    if (v[i]) continue;
                    if (idx == mod) {
                        v[i] = true;
                        sb.append(nums[i] + " ");
                        break;
                    }
                    idx++;
                }
                cnt--;
            }
           
        } else if (type == 2) {
            int[] perm = new int[N];
            for (int i = 0; i < N; i++) {
                perm[i] = Integer.parseInt(st.nextToken());
            }

            long index = 0;
            boolean[] used = new boolean[N];
            for (int i = 0; i < N; i++) {
                int num = perm[i];
                int cnt = 0;
                for (int j = 0; j < num - 1; j++) {
                    if (!used[j]) cnt++;
                }
                index += cnt * fact(N - i - 1);
                used[num - 1] = true;
            }
            sb.append(index+1);
        }
        System.out.println(sb.toString());
    }

    static long fact(int n) {
        if (n <= 1) return 1;
        return n * fact(n - 1);
    }
}
