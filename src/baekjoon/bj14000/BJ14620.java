package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//꽃길
public class BJ14620 {
	static int min = 987654321;
	static int[][] d = {{0, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(map, check, 0, 1, 0);
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][] map, boolean[][] check, int n, int x, int sum) {
		if(sum > min) return;	//가지치기

		if(n == 3) {	//꽃을 3개 다 놓았으면
			if(sum < min) {		//현재 구한 값이 전에 구한 최소값보다 더 적으면 갱신
				min = sum;
			}
			return;
		}
		
		for(int i = x; i < map.length - 1; i++) {
			for(int j = 1; j < map.length - 1; j++) {
				boolean test = false;
				for(int k = 0; k < d.length; k++) {		//꽃을 놓을 수 있는 곳인지 확인
					if(check[i + d[k][0]][j + d[k][1]]) {
						test = true;
						break;
					}
				}
				if(!test) {		//놓을 수 있다면
					int add = 0;
					for(int k = 0; k < d.length; k++) {		//꽃 심은 영역 표시
						check[i + d[k][0]][j + d[k][1]] = true;
						add += map[i + d[k][0]][j + d[k][1]];
					}
					solve(map, check, n + 1, i, sum + add);
					for(int k = 0; k < d.length; k++) {	//백트랙 (꽃 심은 영역 표시 제거)
						check[i + d[k][0]][j + d[k][1]] = false;
					}
				}
			}
		}
	}
}
