package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//택시거리
public class BJ17247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				if(st.nextToken().charAt(0) == '1') {
					if(x1 == -1) {
						x1 = i;
						y1 = j;
					}else {
						x2 = i;
						y2 = j;
					}
				}
			}
		}
		bw.write((Math.abs(x1 - x2) + Math.abs(y1 - y2)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
