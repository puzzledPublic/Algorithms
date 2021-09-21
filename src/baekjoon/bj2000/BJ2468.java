package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//안전영역
public class BJ2468 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] district = new int[N][N];	//지역 정보
		int lowest = 100, highest = 1;		//비가 내리는 범위
		boolean[][] chk = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				district[i][j] = Integer.parseInt(st.nextToken());
				if(district[i][j] > highest) {	//비가 내릴 최대값
					highest = district[i][j];
				}
				if(district[i][j] < lowest) {	//비가 내릴 최소값
					lowest = district[i][j];
				}
			}
		}
		int max = 0;
		for(int i = lowest - 1; i <= highest; i++) {	//모든 내릴 빗물의 양에 대해(lowest - 1부터 시작해야 모든 경우를 구할 수 있다.)
			int current = 0;
			for(int j = 0; j < N; j++) {	//지역을 돌며
				for(int k = 0; k < N; k++) {
					if(!chk[j][k] && district[j][k] > i) {	//빗물이 안차는 지역이라면 dfs 시작
						current++;	//지역 +1
						solve(district, chk, j, k, i);
					}else {
						chk[j][k] = true;
					}
				}
			}
			for(int j = 0; j < N; j++) {	//방문 체크 배열 초기화
				for(int k = 0; k < N; k++) {
					chk[j][k] = false;
				}
			}
			if(current > max) {
				max = current;
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][] arr, boolean[][] chk, int x, int y, int height) {
		chk[x][y] = true;
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if((0 <= nx && nx < arr.length) && (0 <= ny && ny < arr.length) && !chk[nx][ny] && arr[nx][ny] > height) {	//아직 방문을 안했고 빗물이 차지 못하는 경우
				solve(arr, chk, nx, ny, height);
			}
		}
	}
}
