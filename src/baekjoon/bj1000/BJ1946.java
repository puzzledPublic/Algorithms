package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//신입사원	(다른 모든 사람들(탈락자와 상관없이)과의 비교에서 적어도 하나의 순위가 높아야한다는 점을 유의)
public class BJ1946 {
	static class Score {
		int paper, interview;
		Score(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			List<Score> score = new ArrayList<>(N);
			StringTokenizer st;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				score.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			score.sort((a, b) -> a.paper - b.paper); //서류 순위를 기준으로 오름차순 정렬
			
			int top = score.get(0).interview;	//인터뷰 순위
			int sum = 1;
			for(int j = 1; j < score.size(); j++) {
				if(score.get(j).interview < top) {	//현재 비교하는 인터뷰 순위가 더 높으면 합격 (서류순위는 이미 뒤쳐지기에 인터뷰 순위가 높아야 합격)
					top = score.get(j).interview;	//비교할 인터뷰 순위를 갱신
					sum++;
				}
			}
			
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
