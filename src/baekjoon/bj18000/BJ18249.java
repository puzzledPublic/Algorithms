package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//근손실
public class BJ18249 {
	static int[] kit;
	static boolean[] chk;
	static int[] seqKit;
	static int N, K;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		kit = new int[N];
		chk = new boolean[N];
		seqKit = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			kit[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0);
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n) {
		if(n == N) {	//N개의 숫자들의 순열이 완성 된 경우.
			int weight = 500;
			boolean isOK = true;
			for(int i = 0; i < N; i++) {	//N일 동안 매일 중량 500 이상인지 검사.
				if(weight - K + seqKit[i] < 500) {
					isOK = false;
					break;
				}
				weight = weight - K + seqKit[i];
			}
			if(isOK) {	//매일 500이상이라면 경우의 수 증가.
				count++;
			}
			return;
		}
		
		for(int i = 0; i < N; i++) {	//순열을 만든다.
			if(!chk[i]) {
				chk[i] = true;
				seqKit[n] = kit[i];
				solve(n + 1);
				chk[i] = false;
			}
		}
	}
}
