package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//네 번째 점
public class BJ3009 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] coord = new int[3][2];
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			coord[i][0] = Integer.parseInt(st.nextToken());
			coord[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] r = new int[2];
		for(int i = 0; i < 2; i++) {
			if(coord[0][i] == coord[1][i]) {
				r[i] = coord[2][i];
			}else if(coord[0][i] == coord[2][i]) {
				r[i] = coord[1][i];
			}else {
				r[i] = coord[0][i];
			}
		}
		
		bw.write(r[0] + " " + r[1]);
		
		bw.flush();
		bw.close();
		br.close();
	}
}
