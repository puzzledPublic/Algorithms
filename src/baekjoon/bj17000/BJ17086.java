package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//아기상어 2
public class BJ17086 {
	static int[][] d = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] pool = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				pool[i][j] = Integer.parseInt(st.nextToken());
				if(pool[i][j] == 1) {	//아기 상어 위치를 다 저장한다.
					queue.add(new int[] {i, j});
				}
			}
		}
		
		//아기상어 위치에서 BFS시작.
		while(!queue.isEmpty()) {
			int[] shark = queue.poll();
			
			for(int i = 0; i < d.length; i++) {	//인접한 위치를 모두 탐색
				int nx = shark[0] + d[i][0], ny = shark[1] + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && pool[nx][ny] == 0) {	//아직 방문 안한곳이라면
					pool[nx][ny] = pool[shark[0]][shark[1]] + 1;	//이전의 도달거리에 + 1을 표시.
					queue.add(new int[] {nx, ny});	//정점 탐색
				}
			}
		}
		
		//배열을 모두 탐색하며 최대 거리 저장.
		int result = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(result < pool[i][j]) {
					result = pool[i][j];
				}
			}
		}
		
		//1을 상어 위치이면서 거리로 사용했기에 실제 거리는 1이 더 작아야한다.
		bw.write((result - 1) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
