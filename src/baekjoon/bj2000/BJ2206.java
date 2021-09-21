package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//벽 부수고 이동하기
public class BJ2206 {
	static class Pos {
		int x, y;
		boolean isCracked;
		public Pos(int x, int y, boolean isCracked) {
			this.x = x;
			this.y = y;
			this.isCracked = isCracked;
		}
	}
	static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				if(s.charAt(j) == '1') {
					map[i][j] = -1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		bw.write(solve(map, N, M) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int[][] map, int n, int m) {
		int[][][] visited = new int[n][m][2];
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0, false));
		visited[0][0][0] = 1;
		while(!queue.isEmpty()) {
			Pos p = queue.poll();	
			for(int i = 0; i < d.length; i++) {
				int nx = p.x + d[i][0], ny = p.y + d[i][1];
				if((0 <= nx && nx < map.length) && (0 <= ny && ny < map[0].length)) {
					if(map[nx][ny] == -1 && !p.isCracked && visited[nx][ny][1] == 0) {	//다음 위치가 벽이고 벽을 부순적이 없으면 부숴서 다음 위치로
						visited[nx][ny][1] = visited[p.x][p.y][0] + 1;
						queue.add(new Pos(nx, ny, true));
					}else if(map[nx][ny] == 0 && p.isCracked && visited[nx][ny][1] == 0) {	//다음 위치가 벽이 아니고 벽은 부순적이 있다면				
						visited[nx][ny][1] = visited[p.x][p.y][1] + 1;
						queue.add(new Pos(nx, ny, true));
					}else if(map[nx][ny] == 0 && !p.isCracked && visited[nx][ny][0] == 0){	//다음 위치가 벽이 아니고 벽을 부순적이 없다면
						visited[nx][ny][0] = visited[p.x][p.y][0] + 1;
						queue.add(new Pos(nx, ny, false));
					}
				}
			}
		}
		
		if(visited[n - 1][m - 1][1] > 0) {
			return visited[n - 1][m - 1][1];
		}else if(visited[n - 1][m - 1][0] > 0) {
			return visited[n - 1][m - 1][0];
		}else {
			return -1;
		}
		
	}
}
