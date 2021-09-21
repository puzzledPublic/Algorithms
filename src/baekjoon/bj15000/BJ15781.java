package baekjoon.bj15000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//헬멧과 조끼
public class BJ15781 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), helmet = 0, vest = 0, t;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			t = Integer.parseInt(st.nextToken());
			if(helmet < t) {
				helmet = t;
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			t = Integer.parseInt(st.nextToken());
			if(vest < t) {
				vest = t;
			}
		}
		bw.write((helmet + vest) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
