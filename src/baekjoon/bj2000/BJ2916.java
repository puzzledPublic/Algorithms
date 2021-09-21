package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//자와 각도기
public class BJ2916 {
	static int N, K;
	static int[] chang;
	static int[] hyun;
	static Set<Integer> set = new HashSet<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		chang = new int[N];
		hyun = new int[K];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			chang[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) {
			hyun[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(0);
		
		for(int i = 0; i < K; i++) {
			if(!set.contains(hyun[i])) {
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//각도들로 만들 수 있는 모든 각도들을 만들어본다.
	static void solve(int sum) {
		
		if(set.contains(sum)) return;	//이미 만든 각도라면 리턴.
		set.add(sum);
		
		for(int i = 0; i < N; i++) {
			//더하는 경우 (0~360 사이의 각도가 되도록 만든다)
			int next = (0 <= sum + chang[i] && sum + chang[i] < 360) ? sum + chang[i] : sum + chang[i] - 360;
				solve(next);
			//빼는 경우
			int next2 = (0 <= sum - chang[i] && sum - chang[i] < 360) ? sum - chang[i] : 360 + (sum - chang[i]);
				solve(next2);
		}
	}
}
