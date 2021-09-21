package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//알고스팟
public class BJ1261 {
	static class Vertex {
		int x, y, weight;
		public Vertex(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bw.write(solve(map, N, M) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int[][] map, int N, int M) {	//다익스트라 최단거리
		PriorityQueue<Vertex> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		int[][] dist = new int[M][N];	//map[0][0]에서 map[i][j]까지의 최단거리
		for(int i = 0; i < dist.length; i++) {	//처음엔 모든 정점이 도달 불가능으로 초기화
			Arrays.fill(dist[i], 987654321);
		}
		dist[0][0] = 0;	//자기 자신의 거리는 0
		pq.add(new Vertex(0, 0, 0));	//탐색 시작점.
		
		while(!pq.isEmpty()) {
			Vertex v = pq.poll();
			
			if(dist[v.x][v.y] < v.weight) {	//현재 v까지 왔을때의 거리(v.weight)보다 전에 구한 v까지의 거리(dist[v])가 더 짧다면 더 탐색할 필요가 없다.
				continue;
			}
			
			for(int i = 0; i < d.length; i++) {		//상 하 좌 우로 탐색
				int xx = v.x + d[i][0], yy = v.y + d[i][1];		//다음 탐색 좌표
				if((0 <= xx && xx < M) && (0 <= yy && yy < N)) {	//map 범위를 벗어나는지 검사.
					if(v.weight + map[xx][yy] < dist[xx][yy]) {		//현재 좌표까지 온 거리(v.weight) + 다음 좌표까지의 거리(map[xx][yy])가 전에 구해놓은 다음 좌표까지의 거리(dist[xx][yy]) 보다 작으면 갱신한다.
						dist[xx][yy] = v.weight + map[xx][yy];
						pq.add(new Vertex(xx, yy, v.weight + map[xx][yy]));
					}
				}
			}
		}
		return dist[M - 1][N - 1];	//map[0][0] ~ map[m - 1][n - 1]까지 최단거리
	}
}
