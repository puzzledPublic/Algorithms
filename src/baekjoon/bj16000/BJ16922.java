package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

//로마 숫자 만들기
public class BJ16922 {
	static int N, count = 0, overlay = 0;
	static int[] roma = {1, 5, 10, 50};
	static int[] result;
	static Set<Integer> set = new TreeSet<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		result = new int[N];
		solve(0, 0);
		
		bw.write((count - overlay) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	//로마 숫자 4개{1, 5, 10, 50}를 중복있고 오름차순으로 N개를 고르는 경우
	static void solve(int n, int next) {
		if(n == N) {
			count++;
			int gg = 0;
			for(int i = 0; i < N; i++) {
				gg += roma[result[i]];
			}
			if(set.contains(gg)) {
				overlay++;	//중복되는 갯수
			}else {
				set.add(gg);
			}
			return;
		}
		for(int i = next; i < 4; i++) {
			result[n] = i;
			solve(n + 1, i);
		}
	}
}
