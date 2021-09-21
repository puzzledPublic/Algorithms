package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//빙고
public class BJ2578 {
	static boolean chk[][] = new boolean[5][5];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] bingo = new int[26][2];	//빙고에서 숫자 i의 위치
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				bingo[num][0] = i;
				bingo[num][1] = j;
			}
		}
		tal: for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				chk[bingo[num][0]][bingo[num][1]] = true;
				if(isBingo()) {
					bw.write((i * 5 + j) + "\n");
					break tal;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	static boolean isBingo() {
		//가로u, 세로d, 대각선v,v2
		int u = 0, d = 0, v = 0, v2 = 0, bingo = 0;
		for(int i = 0; i < 5; i++) {
			u = 0;
			d = 0;
			for(int j = 0; j < 5; j++) {
				if(chk[i][j]) {
					u++;
				}
				if(chk[j][i]) {
					d++;
				}
			}
			if(u == 5) {
				bingo++;
			}
			if(d == 5) {
				bingo++;
			}
			if(chk[i][i]) {
				v++;
			}
			if(chk[i][4 - i]) {
				v2++;
			}
		}
		if(v == 5) {
			bingo++;
		}
		if(v2 == 5) {
			bingo++;
		}
		if(bingo >= 3) {
			return true;
		}
		return false;
	}
}
