package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//전깃줄 (LIS)
public class BJ2565 {
	static class Wire implements Comparable<Wire>{
		int s, e;
		Wire(int s, int e) {
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Wire o) {
			return this.s - o.s;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		List<Wire> wires = new ArrayList<>();
		int[] dp = new int[N];
//		int[] table = new int[502];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
//			table[A] = B; 이런식으로 받으면 정렬하지 않아도 된다.
			wires.add(new Wire(A, B));	//A ~ B로 이어지는 전깃줄
			dp[i] = 1;
		}
		
		Collections.sort(wires);	//시작점 순서로 정렬
		
		int max = 1;	//겹치지 않는 전깃줄의 최대 개수 = 가장 긴 증가하는 부분 수열
		for(int i = 1; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(wires.get(i).e > wires.get(j).e) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		bw.write((N - max) + "\n");	//끊어야하는 전깃줄의 최소 개수
		
		bw.flush();
		bw.close();
		br.close();
	}
}
