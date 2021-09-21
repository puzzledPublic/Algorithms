package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//태권왕
public class BJ14562 {
	static class Score {
		int s, t, k;
		Score(int s, int t, int k) {
			this.s = s;
			this.t = t;
			this.k = k;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int C = Integer.parseInt(br.readLine());
		for(int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			Queue<Score> queue = new LinkedList<>();
			queue.add(new Score(S, T, 0));
			while(!queue.isEmpty()) {
				Score score = queue.poll();
				
				if(score.s == score.t) {	//점수 s, t가 같으면 종료
					bw.write(score.k + "\n");
					break;
				}
				if(score.s < score.t) {	//s < t인 경우에 대해 
					queue.add(new Score(score.s * 2, score.t + 3, score.k + 1));	//(s + s, t + 3)
					queue.add(new Score(score.s + 1, score.t, score.k + 1));		//(s + 1, t)
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
