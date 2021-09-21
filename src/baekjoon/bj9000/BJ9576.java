package baekjoon.bj9000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//책 나눠주기
public class BJ9576 {
	static class State {
		int s, e;
		State(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<State> list = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new State(s, e));
			}
			
			list.sort((a, b) -> {	//마지막 번호 -> 처음 번호 순으로 오름차순 정렬.
				if(a.e == b.e) return a.s - b.s;
				else return a.e - b.e;
			});
			
			boolean[] check = new boolean[N + 1];
			int count = 0;
			for(int i = 0; i < M; i++) {
				State s = list.get(i);
				for(int j = s.s; j <= s.e; j++) {	//s~e구간에서
					if(!check[j]) {	//아직 나눠주지 않은 책이면 나눠주기.
						check[j] = true;
						count++;
						break;
					}
				}
			}
			
			bw.write(count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
