package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//I AM IRONMAN
public class BJ17264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		
		Set<String> winner = new HashSet<>();
		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			char winOrLose = st.nextToken().charAt(0);
			if(winOrLose == 'W') {
				winner.add(name);
			}
		}
		
		boolean isHeIronMan = true;
		int score = 0;
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			if(winner.contains(name)) {
				score += W;
			}else if(score >= L){
				score -= L;
			}else {
				score = 0;
			}
			if(score >= G) {
				isHeIronMan = false;
				break;
			}
		}
		
		bw.write((isHeIronMan ? "I AM IRONMAN!!\n" : "I AM NOT IRONMAN!!\n"));
		bw.flush();
		bw.close();
		br.close();
	}
}
