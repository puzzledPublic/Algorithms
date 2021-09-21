package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//등수 구하기
public class BJ1205 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), newScore = Integer.parseInt(st.nextToken()), P = Integer.parseInt(st.nextToken());
		if(N == 0) {
			bw.write("1\n");
		}else {
			st = new StringTokenizer(br.readLine(), " ");
			List<Integer> score = new ArrayList<>(N);
			for(int i = 0; i < N; i++) {
				score.add(Integer.parseInt(st.nextToken()));
			}
			bw.write(solve(score, newScore, P) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(List<Integer> score, int newScore, int P) {
		Collections.sort(score, (a, b) -> b - a);
		int count = 1, grade = 1;
		for(int i = 0; i < Math.min(score.size(), P); i++) {
			if(score.get(i) < newScore) {
				return grade;
			}
			count++;
			if(score.get(i) != newScore) {
				grade = count;
			}
		}
		if(count <= P) {
			return grade;
		}
		return -1;
	}
}
