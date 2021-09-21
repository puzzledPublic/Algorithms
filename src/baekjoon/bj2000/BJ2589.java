package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 보물섬
처음에 (각 섬에 대해)아무 정점에서 시작해서 가장 멀리간 다음 그 정점에서 다시 bfs하면 최대 거리가 나올 줄 알았는데 반례가 있었음.

4 4
LLLL
LWLW
LLLW
LWWW

위의 경우 (0, 0)에서 bfs시 (2, 2)가 최대값(4)을 갖는 정점이고 다시 이 정점에서 bfs를 해도 최대거리가 4이다.
하지만 실제로는 (0, 3), (3, 0)의 거리가 최대(6)이다.

그래서 그냥 모든 정점에 대해서 bfs를 돌렸다.
최악의 경우(모두 L인경우) (N^4)가 된다. 하지만 L, W <= 50이므로 50^4 = 625만이라 시간내에 가능하다.
*/
public class BJ2589 {
	static class Coord {
		int x, y, dist;
		Coord(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static char[][] island;
	static int[][] backup;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken());
		
		island = new char[L][];
		backup = new int[L][W];
		
		for(int i = 0; i < L; i++) {
			island[i] = br.readLine().toCharArray();
			for(int j = 0; j < W; j++) {
				backup[i][j] = island[i][j] == 'L' ? 1 : -1;
			}
		}
		int max = 0;
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < W; j++) {
				if(island[i][j] == 'L') {	//모든 점에대해서 bfs
					int dist = bfsFrom(i, j);
					if(max < dist) {
						max = dist;
					}
				}
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	static int bfsFrom(int x, int y) {
		for(int i = 0; i < backup.length; i++) {	//visited 배열 초기화
			for(int j = 0; j < backup[0].length; j++) {
				if(backup[i][j] == 2) {
					backup[i][j] = 1;
				}
			}
		}
		Queue<Coord> queue = new LinkedList<>();
		queue.add(new Coord(x, y, 0));
		backup[x][y]++;	//시작점도 다시 탐색해서 거리가 늘지 않도록 체크 필요.
		int max = -1;	//x, y를 시작점으로한 bfs의 최대값
		while(!queue.isEmpty()) {
			Coord coord = queue.poll();
			max = coord.dist;
			for(int i = 0; i < d.length; i++) {
				int nx = coord.x + d[i][0], ny = coord.y + d[i][1];
				if((0 <= nx && nx < island.length) && (0 <= ny && ny < island[0].length) && backup[nx][ny] == 1) {
					queue.add(new Coord(nx, ny, coord.dist + 1));
					backup[nx][ny]++;
				}
			}
		}
		return max;
	}
}
