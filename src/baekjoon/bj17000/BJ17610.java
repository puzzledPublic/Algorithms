package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//양팔저울
public class BJ17610 {
	static Set<Integer> set = new HashSet<>();
	static int K, total;
	static int[] iron;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		K = Integer.parseInt(br.readLine());
		iron = new int[K];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			iron[i] = Integer.parseInt(st.nextToken());
			total += iron[i];
		}
		
		solve(0, 0);
		
		bw.write((total - set.size()) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int sum) {
		if(n == K) {
			if(sum > 0) {
				set.add(sum);
			}
			return;
		}
		solve(n + 1, sum);	//저울에 올리지 않는 경우
		solve(n + 1, sum - iron[n]);	//왼쪽 저울에 올리는 경우
		solve(n + 1, sum + iron[n]);	//오른쪽 저울에 올리는 경우
	}
}
