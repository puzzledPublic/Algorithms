package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//파이프 옮기기 1
public class BJ17070 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][][] home = new int[N][N][3];	//home[i][j][k] = k모양(0=가로, 1=대각선, 2=세로)으로 (i,j)를 도착하는 경우의 수
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				if(st.nextToken().charAt(0) == '1') {	//가지못하는 곳은 -1로.
					home[i][j][0] = home[i][j][1] = home[i][j][2] = -1;
				}
			}
		}
		
		home[0][1][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//가로 모양일때, (i, j-1, (가로, 대각선))에서 오는 경우가 있다.
				if(home[i][j][0] != -1 && j - 1 >= 0) {
					if(home[i][j - 1][0] != -1) {
						home[i][j][0] += home[i][j - 1][0];
					}
					if(home[i][j - 1][1] != -1) {
						home[i][j][0] += home[i][j - 1][1];
					}
				}
				//대각선 모양일때, (i,j),(i,j-1),(i-1,j)에 공간이 있어야하고(not -1) (i-1, j-1, (가로, 대각선, 세로))에서 오는 경우가 있다.
				if(i - 1 >= 0 && j - 1 >= 0 && (home[i][j][1] != -1 && home[i - 1][j][1] != -1 && home[i][j - 1][1] != -1)) {
					if(home[i - 1][j - 1][0] != -1) {
						home[i][j][1] += home[i - 1][j - 1][0];
					}
					if(home[i - 1][j - 1][1] != -1) {
						home[i][j][1] += home[i - 1][j - 1][1];
					}
					if(home[i - 1][j - 1][2] != -1) {
						home[i][j][1] += home[i - 1][j - 1][2];
					}
				}
				//세로 모양일때, (i-1, j, (세로, 대각선))에서 오는 경우가 있다.
				if(home[i][j][2] != -1 && i - 1 >= 0) {
					if(home[i - 1][j][1] != -1) {
						home[i][j][2] += home[i - 1][j][1];
					}
					if(home[i - 1][j][2] != -1) {
						home[i][j][2] += home[i - 1][j][2];
					}
				}
			}
		}
		
		//각 3가지 모양으로 (N,N)에 도착하는 경우들을 합한다.
		int result = (home[N - 1][N - 1][0] + home[N - 1][N - 1][1] + home[N - 1][N - 1][2]);
		bw.write((result < 0 ? 0 : result)  + "\n"); //(N,N)이 -1인 경우가 있으니 주의
		bw.flush();
		bw.close();
		br.close();
	}
}
