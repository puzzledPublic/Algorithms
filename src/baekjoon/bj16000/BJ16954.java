package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//움직이는 미로 탈출
public class BJ16954 {
	static class Coord {
		int x, y, step;
		Coord(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	static int[][] d = {{0, 0}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[][] maze = new char[8][];
		for(int i = 0; i < 8; i++) {
			maze[i] = br.readLine().toCharArray();
		}
		boolean escaped = false;
		Queue<Coord> queue = new LinkedList<>();
		queue.add(new Coord(7, 0, 0));
		int step = 0;	//현재 미로 상태를 유지하기 위한 변수
		boolean stay = false;	//같은 step이 여러개일 수 있으므로 여러번 갱신하지 않도록 하는 변수
		while(!queue.isEmpty()) {
			Coord coord = queue.poll();
			
			boolean canEscape = true;
			for(int i = coord.x; i >= 0; i--) {	//현재 위치에서 위로 아무 벽도 없다면 탈출가능
				if(maze[i][coord.y] != '.') {
					canEscape = false;
					break;
				}
			}
			if(canEscape) {
				escaped = canEscape;
				break;
			}
			
			if(step != coord.step) {	//다음 상태로 바꿔야하면
				for(int i = 0; i < 8; i++) {	//벽 내려가는 시뮬레이션
					for(int j = 0; j < 8; j++) {
						if(maze[i][j] == '#') {
							maze[i][j] = '.';
						}else if(maze[i][j] == 'X') {
							maze[i][j] = '#';
						}
					}
				}
				step = coord.step;	//다음 벽의 위치를 체크하도록
				stay = false;
			}
			
			if(step == coord.step && !stay) {
				for(int i = 7; i >= 0; i--) {	//다음 벽이 내려가는곳을 체크한다.
					for(int j = 7; j >= 0; j--) {
						if(maze[i][j] == '#' && i + 1 < 8) {
							maze[i + 1][j] = 'X';
						}
					}
				}
				stay = true;
			}
			
			//상하좌우,대각,현위치에 대해 갈 수 있다면 탐색을 위해 큐에 넣는다.
			for(int i = 0; i < d.length; i++) {
				int nx = coord.x + d[i][0], ny = coord.y + d[i][1];
				if((0 <= nx && nx < 8) && (0 <= ny && ny < 8) && maze[nx][ny] == '.') {
					queue.add(new Coord(nx, ny, coord.step + 1));
				}
			}
		}
		
		bw.write((escaped ? "1\n" : "0\n"));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
