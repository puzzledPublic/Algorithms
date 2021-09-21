package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈출
public class BJ3055 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static class Pos {
		int x, y, time;
		Pos(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		Queue<Pos> water = new LinkedList<>();	//물의 이동
		Queue<Pos> dudgi = new LinkedList<>();	//두더지의 이동
		char[][] map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String row = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = row.charAt(j);
				if(map[i][j] == 'S') {	//두더지의 위치를 큐에 저장
					dudgi.add(new Pos(i, j, 0));
				}
				if(map[i][j] == '*') {	//물의 위치를 큐에 저장
					water.add(new Pos(i, j, 0));
				}
			}
		}
		int result = solve(map, water, dudgi);
		System.out.println(result > 0 ? result : "KAKTUS");
	}
	
	static int solve(char[][] map, Queue<Pos> water, Queue<Pos> dudgi) {
		int count = 0;	//시간의 흐름
		while(true) {
			if(dudgi.isEmpty()) {	//두더지가 더 이상 움직일 수 없고 집에 도착하지 못했다면 -> 실패
				return 0;
			}
			while(!water.isEmpty() && water.peek().time == count) {	//1초 뒤의 물의 위치를 map에 갱신한다. (bfs)
				Pos p = water.poll();
				for(int i = 0; i < d.length; i++) {
					int xx = p.x + d[i][0], yy = p.y + d[i][1];
					if(0 <= xx && xx < map.length && 0 <= yy && yy < map[0].length && (map[xx][yy] == '.' || map[xx][yy] == 'S')) {
						map[xx][yy] = '*';
						water.add(new Pos(xx, yy, p.time + 1));
					}
				}
			}
			while(!dudgi.isEmpty() && dudgi.peek().time == count) {	//물이 차고 난뒤 두더지가 갈 수 있는 위치를 갱신한다.(bfs)
				Pos p = dudgi.poll();
				for(int i = 0; i < d.length; i++) {
					int xx = p.x + d[i][0], yy = p.y + d[i][1];
					if(0 <= xx && xx < map.length && 0 <= yy && yy < map[0].length) {
						if(map[xx][yy] == 'D') {	//만일 다음 시간에 집에 도착할 수 있다면 -> 성공
							return p.time + 1;
						}
						else if(map[xx][yy] == '.') {
							map[xx][yy] = 'S';
							dudgi.add(new Pos(xx, yy, p.time + 1));
						}
					}
				}
			}
			count++;
		}
	}
}
