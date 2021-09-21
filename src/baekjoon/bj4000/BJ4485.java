package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//녹색 옷 입은 애가 젤다지? (다익스트라)
public class BJ4485 {
	
	static class Coord {
		int x, y, weight;
		Coord(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N, problem = 1;
		while((N =Integer.parseInt(br.readLine())) != 0) {
			int[][] map = new int[N][N];
			int[][] dist = new int[N][N];	//(0,0) ~ (i,j)까지 갈때 최소로 잃는 돈
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				Arrays.fill(dist[i], 987654321);
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dist[0][0] = map[0][0];	//처음 잃는 돈
			PriorityQueue<Coord> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
			pq.add(new Coord(0, 0, map[0][0]));
			while(!pq.isEmpty()) {
				Coord current = pq.poll();
				
				if(dist[current.x][current.y] < current.weight) {
					continue;
				}
				
				for(int i = 0; i < d.length; i++) {
					int nx = current.x + d[i][0], ny = current.y + d[i][1];
					if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
						if(dist[nx][ny] > current.weight + map[nx][ny]) {
							dist[nx][ny] = current.weight + map[nx][ny];
							pq.add(new Coord(nx, ny, dist[nx][ny]));
						}
					}
				}
			}
			bw.write("Problem " + (problem++) + ": " + dist[N - 1][N - 1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
