package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//빙산
public class BJ2573 {
	static int[][] map;
	static boolean[][] check;
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		check = new boolean[N][M];

		boolean aparted = false;
		int count = 0;
		tal: while(true) {
			int iceberg = 0;
			for(int i = 1; i < N - 1; i++) {
				for(int j = 1; j < M - 1; j++) {
					if(!check[i][j] && map[i][j] > 0) {
						check[i][j] = true;
						dfs(i, j);
						iceberg++;
					}
					if(iceberg == 2) {
						aparted = true;
						break tal;
					}
				}
			}
			count++;
			if(iceberg == 0) {	//dfs를 돌았는데 빙하가 없다면 쪼개지지 않고 하나로 유지되다가 사라졌음을 뜻함.
				break;
			}
			
			for(int i = 1; i < N - 1; i++) {	//체크 배열 초기화
				for(int j = 1; j < M - 1; j++) {
					check[i][j] = false;
				}
			}
//			for(int i = 1; i < N; i++) {
//				for(int j = 1; j < M; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		if(aparted) {	//빙하가 2개로 쪼개졌다면 걸린 년수 출력
			bw.write(count + "\n");
		}else {			//끝까지 쪼개지지 않았다면 0 출력
			bw.write("0\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	//dfs
	static void dfs(int x, int y) {
		int melt = 0;
		for(int i = 0; i < d.length; i++) {	//현재 위치에서 녹는 양 = 상하좌우의 0의 개수
			if(map[x + d[i][0]][y + d[i][1]] == 0) {
				melt++;
			}
		}
		for(int i = 0; i < d.length; i++) {
			int nx = x + d[i][0], ny = y + d[i][1];
			if(!check[nx][ny] && map[nx][ny] > 0) {
				check[nx][ny] = true;
				dfs(nx, ny);
			}
		}
		//돌아오면서 빙하 높이 갱신.
		if(map[x][y] < melt) {
			map[x][y] = 0;
		}else {
			map[x][y] -= melt;
		}
	}
}
