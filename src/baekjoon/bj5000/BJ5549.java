package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//행성 탐사
public class BJ5549 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		char[][] planet = new char[M][];	//맵
		int[][][] typeAmount = new int[M][N][3];	//typeAmount[i][j][k] = (0,0) ~ (i,j)까지의 k(0='J', 1='I', 2='O')의 갯수
		
		for(int i = 0; i < M; i++) {
			planet[i] = br.readLine().toCharArray();
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(i - 1 >= 0 && j - 1 >= 0) {
					typeAmount[i][j][0] = typeAmount[i - 1][j][0] + typeAmount[i][j - 1][0] - typeAmount[i - 1][j - 1][0];
					typeAmount[i][j][1] = typeAmount[i - 1][j][1] + typeAmount[i][j - 1][1] - typeAmount[i - 1][j - 1][1];
					typeAmount[i][j][2] = typeAmount[i - 1][j][2] + typeAmount[i][j - 1][2] - typeAmount[i - 1][j - 1][2];
				}else if(i - 1 >= 0) {
					typeAmount[i][j][0] = typeAmount[i - 1][j][0];
					typeAmount[i][j][1] = typeAmount[i - 1][j][1];
					typeAmount[i][j][2] = typeAmount[i - 1][j][2];
				}else if(j - 1 >= 0) {
					typeAmount[i][j][0] = typeAmount[i][j - 1][0];
					typeAmount[i][j][1] = typeAmount[i][j - 1][1];
					typeAmount[i][j][2] = typeAmount[i][j - 1][2];
				}
				if(planet[i][j] == 'J') {
					typeAmount[i][j][0]++;
				}else if(planet[i][j] == 'O') {
					typeAmount[i][j][1]++;
				}else {
					typeAmount[i][j][2]++;
				}
			}
		}
		//(x1,y1) ~ (x2,y2)까지의 'J','I','O'의 갯수 출력
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken()) - 1, y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1, y2 = Integer.parseInt(st.nextToken()) - 1;
			if(x1 - 1 >= 0 && y1 - 1 >= 0) {
				bw.write(typeAmount[x2][y2][0] - (typeAmount[x2][y1 - 1][0] + typeAmount[x1 - 1][y2][0]) + typeAmount[x1 - 1][y1 - 1][0] + " ");
				bw.write(typeAmount[x2][y2][1] - (typeAmount[x2][y1 - 1][1] + typeAmount[x1 - 1][y2][1]) + typeAmount[x1 - 1][y1 - 1][1] + " ");
				bw.write(typeAmount[x2][y2][2] - (typeAmount[x2][y1 - 1][2] + typeAmount[x1 - 1][y2][2]) + typeAmount[x1 - 1][y1 - 1][2] + "\n");
			}else if(x1 - 1 >= 0) {
				bw.write(typeAmount[x2][y2][0] - typeAmount[x1 - 1][y2][0] + " ");
				bw.write(typeAmount[x2][y2][1] - typeAmount[x1 - 1][y2][1] + " ");
				bw.write(typeAmount[x2][y2][2] - typeAmount[x1 - 1][y2][2] + "\n");
			}else if(y1 - 1 >= 0){
				bw.write(typeAmount[x2][y2][0] - typeAmount[x2][y1 - 1][0] + " ");
				bw.write(typeAmount[x2][y2][1] - typeAmount[x2][y1 - 1][1] + " ");
				bw.write(typeAmount[x2][y2][2] - typeAmount[x2][y1 - 1][2] + "\n");
			}else {
				bw.write(typeAmount[x2][y2][0] + " ");
				bw.write(typeAmount[x2][y2][1] + " ");
				bw.write(typeAmount[x2][y2][2] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
