package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//로봇 청소기
public class BJ4991 {
	static class Coord {
		int x, y, dist;

		Coord(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	static int[][] d = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			if(W == 0 && H == 0) {
				break;
			}
			
			int[][] room = new int[H][W];
			List<Coord> points = new ArrayList<>();

			int dirty = 1;
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					char ch = line.charAt(j);
					if (ch == '*') {
						room[i][j] = dirty++;	//먼지에 1번부터 번호를 매긴다.
						points.add(new Coord(i, j, 0));	//먼지 위치 저장.
					} else if (ch == 'o') {
						room[i][j] = 0;	//청소기는 0번.
						points.add(0, new Coord(i, j, 0));	//청소기 위치 저장.
					} else if (ch == '.') {
						room[i][j] = -1;
					} else {
						room[i][j] = -2;
					}
				}
			}

			int[][] dist = new int[points.size() + 1][points.size() + 1];	//dist[i][j] = 청소기 or 먼지 i번 -> j번으로의 최단거리.
			int[][] chk = new int[H][W];	//체크 배열.
			for (int p = 0; p < points.size(); p++) {	//각 먼지의 위치를 시작점으로 BFS를 돌며 각 정점간 거리를 잰다.
				for (int i = 0; i < H; i++) {
					for (int j = 0; j < W; j++) {
						chk[i][j] = room[i][j];
					}
				}

				int sx = points.get(p).x, sy = points.get(p).y;
				Queue<Coord> queue = new LinkedList<>();
				queue.add(new Coord(sx, sy, 0));
				chk[sx][sy] = 100;	//체크할때 100으로 큰 숫자를 둬서 번호를 매긴 0~10번이 깨지지 않도록한다.
				while (!queue.isEmpty()) {	
					Coord c = queue.poll();

					for (int i = 0; i < d.length; i++) {
						int nx = c.x + d[i][0], ny = c.y + d[i][1];
						if ((0 <= nx && nx < H) && (0 <= ny && ny < W)) {
							if (chk[nx][ny] == -1) {	//갈 수 있는 곳이면 전진.
								chk[nx][ny] = 100;
								queue.add(new Coord(nx, ny, c.dist + 1));
							} else if (0 <= chk[nx][ny] && chk[nx][ny] < points.size()) {	//다음 위치가 먼지 또는 청소기라면
								dist[p][chk[nx][ny]] = c.dist + 1;	//해당 거리를 설정.
								chk[nx][ny] = 100;
								queue.add(new Coord(nx, ny, c.dist + 1));
							}
						}
					}
				}
			}
			
			int[] arr = new int[points.size()];	//순열을 만들기 위한 배열.
			for(int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			
			int result = Integer.MAX_VALUE;
			boolean fail = false;
			do {	//각 순열대로 움직였을때 최소거리를 구한다.
				int totalDist = 0;
				for(int i = 0; i < arr.length - 1; i++) {
					if(dist[arr[i]][arr[i + 1]] == 0) {	//거리가 0인 경우 도달 불가능을 나타냄.
						fail = true;
						break;
					}
					totalDist += dist[arr[i]][arr[i + 1]];
				}
				if(fail) {	//도달 불가능인 경우 바로 종료.
					break;
				}
				if(result > totalDist) {
					result = totalDist;
				}
			}while(permutation(arr));
			
			if(fail) {
				bw.write("-1\n");
			}else {
				bw.write(result + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean permutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;
		
		while(i - 1 >= 1 && arr[i - 1] > arr[i]) {
			i--;
		}
		
		if(i == 1) {
			return false;
		}
		
		while(j >= 1 && arr[i - 1] > arr[j]) {
			j--;
		}
		
		int t = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = t;
		
		j = arr.length - 1;
		
		while(i < j) {
			t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
			i++;
			j--;
		}
		
		return true;
	}
}
