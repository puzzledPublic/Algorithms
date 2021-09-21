package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//격자상의 경로
public class BJ10164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
		int[][] lattice = new int[N + 1][M + 1];
		int H = N, W = M;
		if(K > 0) {		//반드시 통과해야하는 좌표(H, W)를 알아낸다.
			int count = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(count++ == K) {
						H = i;
						W = j;
						break;
					}
				}
			}
		}
		
		//(0,0) ~ (H,W)까지 가는 경로의 수 계산
		lattice[0][0] = 1;
		for(int i = 0; i <= H; i++) {
			for(int j = 0; j <= W; j++) {
				if(i - 1 >= 0 && j - 1 >= 0) {
					lattice[i][j] = lattice[i - 1][j] + lattice[i][j - 1];
				}else if(i - 1 >= 0) {
					lattice[i][j] = lattice[i - 1][j];
				}else if(j - 1 >= 0) {
					lattice[i][j] = lattice[i][j - 1];
				}
			}
		}
		
		//(H,W) ~ (N,M)까지 가는 경로의 수 계산
		for(int i = H; i < N; i++) {
			for(int j = W; j < M; j++) {
				if(i - 1 >= 0 && j - 1 >= 0) {
					lattice[i][j] = lattice[i - 1][j] + lattice[i][j - 1];
				}else if(i - 1 >= 0) {
					lattice[i][j] = lattice[i - 1][j];
				}else if(j - 1 >= 0) {
					lattice[i][j] = lattice[i][j - 1];
				}
			}
		}
		
		//(0,0) ~ (N,M)까지 가는 경로의 수 출력
		bw.write(lattice[N - 1][M - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
