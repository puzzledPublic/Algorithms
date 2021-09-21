package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//행복한 소수
public class BJ10434 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[10001];
		prime[1] = true;
		for(int i = 2; i * i <= 10000; i++) {	//에라토스테네스 체
			if(!prime[i]) {
				for(int j = i + i; j <= 10000; j += i) {
					prime[j] = true;
				}
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int C = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			bw.write(C + " " + N + " ");
			if(!prime[N]) {	//소수인 경우.
				Set<Integer> set = new HashSet<>();
				while(true) {
					N = calc(N);	//각 자리수를 제곱하여 모두 더한 수
					if(N == 1) {	//1이 되면 행복한 소수
						bw.write("YES\n");
						break;
					}
					if(set.contains(N)) {	//1이 되지 않고 사이클을 이루면 행복한 소수가 아님.
						bw.write("NO\n");
						break;
					}
					set.add(N);
				}
			}else {	//소수가 아니면 행복한 소수가 아님.
				bw.write("NO\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	//주어진 수의 각 자리수를 제곱하여 더한다.
	static int calc(int n) {
		int r = 0;
		while(n > 0) {
			int tmp = (n % 10);
			r += (tmp * tmp);
			n /= 10;
		}
		return r;
	}
}
