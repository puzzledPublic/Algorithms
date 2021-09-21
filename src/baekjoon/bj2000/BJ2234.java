package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//성곽
public class BJ2234 {
	static int N, M;
	static int[][] map; 
	static int[][] check;
	static int[] size;
	static int[] dir = {8, 4, 2, 1};	//1-서, 2-북, 4-동, 8-남
	static int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		check= new int[M][N];
		size = new int[M * N + 1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int count = 1;	//지역 개수
		int max1 = 1;	//가장 큰 지역 크기
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(check[i][j] == 0) {
					dfs(i, j, count++);	//dfs
					if(max1 < size[count - 1]) {	//가장 큰 지역 크기 갱신
						max1 = size[count - 1];
					}
				}
			}
		}
		
		int max2 = 1;	//벽을 하나 허물었을때 얻는 가장 큰 지역 크기
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				int com = map[i][j];
				for(int k = 0; k < 2; k++) {	//해당 칸의 남, 동 방향의 벽을 한번씩 허물어보고 서로 다른 지역이라면 크기를 합쳐본다. 가장 큰 크기로 갱신
					if(com >= dir[k]) {
						com -= dir[k];
						int nx = i + d[k][0], ny = j + d[k][1];
						if((0 <= nx && nx < M) && (0 <= ny && ny < N) && (check[i][j] != check[nx][ny])) {
							if(max2 < size[check[i][j]] + size[check[nx][ny]]) {
								max2 = size[check[i][j]] + size[check[nx][ny]];
							}
						}
					}
				}
			}
		}
		
		bw.write((count - 1) + "\n" + max1 + "\n" + max2 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y, int num) {	//dfs를 돌며 num에 해당하는 칸이 몇개인지 센다(size[num]).
		check[x][y] = num;	//방문 체크
		size[num]++;
		int com = map[x][y];
		for(int i = 0; i < 4; i++) {
			if(com >= dir[i]) {
				com -= dir[i];
			}else {	//해당 방향에 벽이 없다면 계속 탐색
				int nx = x + d[i][0], ny = y + d[i][1];
				if((0 <= nx && nx < M) && (0 <= ny && ny < N) && check[nx][ny] == 0) {
					dfs(nx, ny, num);
				}
			}
		}
	}
}
