package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

//거울 설치
public class BJ2151 {
	static class State {
		int x, y, dir, mirror;
		State(int x, int y, int dir, int mirror) {
			this.x = x;	//위치
			this.y = y;
			this.dir = dir;	//현재 방향
			this.mirror = mirror;	//설치된 거울 개수
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};	//우, 하, 좌, 상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[][] home = new char[N][N];		//입력 받을 배열
		int[][][] chk = new int[N][N][4];	//방문 체크 배열, (i, j)위치를 k방향으로 방문했을때 설치할 최소 거울 개수
		
		State start = null, end = null;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				home[i][j] = line.charAt(j);
				if(home[i][j] == '#') {	//문인 경우
					if(start == null) {
						start = new State(i, j, -1, 0);	//시작할 문
					}else {
						end = new State(i, j, -1, 0);	//도착할 문
					}
				}
				for(int k = 0; k < 4; k++) {	//방문 체크 배열 초기화.
					chk[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		Queue<State> queue = new LinkedList<>();

		//BFS를 위해 시작점에서 상,하,좌,우 중 갈 수 있는 곳을 큐에 넣어둔다.
		for(int i = 0; i < d.length; i++) {
			int nx = start.x + d[i][0], ny = start.y + d[i][1];
			if(0 <= nx && nx < N && 0 <= ny && ny < N && home[nx][ny] != '*') {
				queue.add(new State(start.x, start.y, i, 0));
				chk[start.x][start.y][i] = 1;
			}
		}
		
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			State state = queue.poll();
			
			if(state.x == end.x && state.y == end.y) {	//끝 점에 도착시 설치할 최소 거울 개수 갱신.
				if(min > state.mirror) {
					min = state.mirror;
				}
				continue;
			}
			
			if(home[state.x][state.y] == '!') {	//현재 위치가 거울 설치할 위치라면
				//현재 방향이 상 or 하라면 우 or 좌로, 우 or 좌라면 상 or 하로 갈 수 있다.
				//우(0), 하(1), 좌(2), 상(3)이므로 다음 위치 인덱스를 (dir + 1) % 4, (dir + 3) % 4로 알아낼 수 있다.
				//그리고 해당 방향으로 갈때 설치할 거울 개수가 더 적어야 방문하도록 한다.
				int nx1 = state.x + d[(state.dir + 1) % 4][0], ny1 = state.y + d[(state.dir + 1) % 4][1];
				if(0 <= nx1 && nx1 < N && 0 <= ny1 && ny1 < N && home[nx1][ny1] != '*' && chk[nx1][ny1][(state.dir + 1) % 4] > state.mirror) {
					chk[nx1][ny1][(state.dir + 1) % 4] = state.mirror;
					queue.add(new State(nx1, ny1, (state.dir + 1) % 4, state.mirror + 1));
				}
				
				int nx2 = state.x + d[(state.dir + 3) % 4][0], ny2 = state.y + d[(state.dir + 3) % 4][1];
				if(0 <= nx2 && nx2 < N && 0 <= ny2 && ny2 < N &&home[nx2][ny2] != '*' && chk[nx2][ny2][(state.dir + 3) % 4] > state.mirror) {
					chk[nx2][ny2][(state.dir + 3) % 4] = state.mirror;
					queue.add(new State(nx2, ny2, (state.dir + 3) % 4, state.mirror + 1));
				}
			}
			//그냥 방향대로 직진하는 경우.
			int nx = state.x + d[state.dir][0], ny = state.y + d[state.dir][1];
			if((0 <= nx && nx < N) && (0 <= ny && ny < N) && home[nx][ny] != '*' && chk[nx][ny][state.dir] > state.mirror) {
				chk[nx][ny][state.dir] = state.mirror;
				queue.add(new State(nx, ny, state.dir, state.mirror));
			}
		}
		
		bw.write(min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
