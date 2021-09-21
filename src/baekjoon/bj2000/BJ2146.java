package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//다리 만들기
//지도를 dfs 탐색하여 각 섬들에 번호를 매기고 각 섬들의 위치에서 동시에 bfs 탐색한다.
//이때 섬들끼리 만나는 경우 중에 가장 짧은 거리가 답이 된다.
public class BJ2146 {
	static class Advent {
		int x, y, step, num;
		Advent(int x, int y, int step, int num) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.num = num;
		}
	}
	static int[][] map, chk, d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int N;
	static Queue<Advent> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];	//지도이면서 각 섬들의 최소 움직임 표시
		chk = new int[N][N];	//각 섬들의 진출영역 표시
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;	//각 섬의 번호 라벨링
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					dfs(i, j, num++);
				}
			}
		}
		
		int min = 987654321;
		while(!queue.isEmpty()) {
			Advent adv = queue.poll();
			for(int i = 0; i < d.length; i++) {
				int nx = adv.x + d[i][0], ny = adv.y + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
					if(map[nx][ny] == 0) {
						chk[nx][ny] = adv.num;
						map[nx][ny] = adv.step + 1;
						queue.add(new Advent(nx, ny, adv.step + 1, adv.num));
					}else if(map[nx][ny] > 0 && chk[nx][ny] != adv.num) {	//섬끼리 만나는 경우
						int result = 987654321;
						if(map[adv.x][adv.y] < map[nx][ny]) {	//총 거리가 짝수인 경우 [ex, 1 2 ->  <- 2 1]
							result = map[nx][ny] + map[nx][ny] - 1;
						}else if(map[adv.x][adv.y] == map[nx][ny]){	//홀수인 경우	 [ex, 1 -> 2 <- 1]
							result = map[nx][ny] + map[adv.x][adv.y];
						}
						//섬이 만나자마자 그 거리를 최소값이라고 생각하면 안된다.
						//dfs할때 큐에 좌표가 어떻게 들어가냐에 따라 섬끼리 만나는 순서가 다르기에 
						//섬들이 만나는 곳을 다 알아내서 그 중 최소값을 출력해야한다.
						//ex)input = 5, 1 0 0 0 1, 0 0 0 0 0, 0 0 0 0 0, 0 0 0 0 0, 1 1 0 0 1 
						if(min > result) {
							min = result;
						}
					}
				}
			}
		}
		//debug용
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(chk[i][j] + " ");
//			}
//			System.out.println();
//		}
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static void dfs(int sx, int sy, int num) {
		map[sx][sy] = -1;
		chk[sx][sy] = num;
		queue.add(new Advent(sx, sy, 0, num));
		for(int i = 0; i < d.length; i++) {
			int nx = sx + d[i][0], ny = sy + d[i][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < N) && map[nx][ny] == 1) {
				dfs(nx, ny, num);
			}
		}
	}
}
