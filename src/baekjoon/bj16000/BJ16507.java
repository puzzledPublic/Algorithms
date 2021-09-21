package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//어두운 건 무서워
public class BJ16507 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		
		int[][] picture = new int[R + 1][C + 1];	//picture[i][j] = (1, 1) ~ (i, j)까지 사각형을 이룰때의 합
		
		for(int i = 1; i < R + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < C + 1; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//i행 1열의 합
		for(int i = 1; i < R + 1; i++) {
			picture[i][1] += picture[i - 1][1];
		}
		
		//1행 i열의 합
		for(int i = 1; i < C + 1; i++) {
			picture[1][i] += picture[1][i - 1];
		}
		
		//i, j열의 합(i, j >= 2)
		for(int i = 2; i < R + 1; i++) {
			for(int j = 2; j < C + 1; j++) {
				//picture[i][j] = 현재 (i, j)의 수 + ((1, 1) ~ (i-1, j) 까지 이루는 사각형 합 + (1, 1) ~ (i, j-1) 까지 이루는 사각형 합 - (1, 1) ~ (i-1,j-1)까지 이루는 사각형 합)
				picture[i][j] += (picture[i - 1][j] + picture[i][j - 1] - picture[i - 1][j - 1]);
			}
		}
		
		//쿼리
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken()), c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken()), c2 = Integer.parseInt(st.nextToken());
			//(r1, c1) ~ (r2, c2)까지 이루는 사각형의 합 
			// = (1, 1) ~ (r2, c2) 까지의 사각형 합 - ( (1, 1) ~ (r2, c1-1) 까지의 사각형 합  + (1, 1) ~ (r1-1, c2) 까지의 사각형 합 ) + (1, 1) ~ (r1-1, c1-1) 까지의 사각형 합과 같다.
			int sum = picture[r2][c2] - (picture[r2][c1 - 1] + picture[r1 - 1][c2]) + picture[r1 - 1][c1 - 1];
			int avg = sum / ((r2 - r1 + 1) * (c2 - c1 + 1));	//평균 값
			bw.write(avg + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
