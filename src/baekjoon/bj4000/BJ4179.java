package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//불!
public class BJ4179 {
	static class Coord {
		int x, y, time;
		char state;
		public Coord(int x, int y, int time, char state) {
			this.x = x;
			this.y = y;
			this.time = time;
			this.state = state;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		Queue<Coord> queue = new LinkedList<>();
		Coord start = null;
		
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'F') {	//불 초기 위치
					queue.add(new Coord(i, j, 0, 'F'));
				}else if(map[i][j] == 'J') {	//시작 위치
					start = new Coord(i, j, 0, 'J');
				}
			}
		}
		
		queue.add(start);	//불이 먼저 번지도록 불 위치를 넣은 뒤 시작 위치를 넣는다.
		int result = -1;
		while(!queue.isEmpty()) {
			Coord c = queue.poll();
			if(c.state == 'J' && (c.x == 0 || c.y == 0 || c.x == R - 1 || c.y == C - 1)) {	//'J'가 가장자리에 도착한 경우 탈출.
				result = c.time + 1;
				break;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nx = c.x + d[i][0], ny = c.y + d[i][1];	//다음위치
				if((0 <= nx && nx < R) && (0 <= ny && ny < C)) {
					if(c.state == 'J' && map[nx][ny] == '.') {	//'J'이고 다음위치가 갈 수 있는 곳이면 이동
						map[nx][ny] = 'J';
						queue.add(new Coord(nx, ny, c.time + 1, 'J'));
					}else if(c.state == 'F' && map[nx][ny] != 'F' && map[nx][ny] != '#'){	//'F'이고 다음위치가 갈 수 있는 곳이면 이동
						map[nx][ny] = 'F';
						queue.add(new Coord(nx, ny, c.time + 1, 'F'));
					}
				}
			}
		}
		
		if(result == -1) {	//-1인 경우 탈출 불가.
			bw.write("IMPOSSIBLE\n");
		}else {
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
