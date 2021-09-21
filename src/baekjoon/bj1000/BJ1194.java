package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//달이 차오른다 가자
public class BJ1194 {
	static class State {
		int x, y, key, t;
		State(int x, int y, int key, int t) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.t = t;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] maze = new int[N][M];
		int[][][] check = new int[N][M][64];	//check[i][j][k] = (i, j)에 key가 k상태일 때 움직인 횟수
		
		for(int i = 0; i < N; i++) {	//check 배열 초기화
			for(int j = 0; j < M; j++) {
				for(int k = 0; k < 64; k++) {
					check[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		State start = null;
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				maze[i][j] = line.charAt(j);
				if(maze[i][j] == '0') {	//시작점 위치
					start = new State(i, j, 0, 0); 
				}
			}
		}
		
		Queue<State> queue = new LinkedList<>();
		queue.add(start);
		
		int result = -1;
		while(!queue.isEmpty()) {
			State state = queue.poll();
			
			if(maze[state.x][state.y] == '1') {	//'1'인 경우 탈출.
				result = state.t;
				break;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nx = state.x + d[i][0], ny = state.y + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && maze[nx][ny] != '#') {	//다음 위치가 미로 범위 내이며, 벽이 아니고..
					int nKey = state.key;
					if('a' <= maze[nx][ny] && maze[nx][ny] <= 'f') {	//다음 위치가 열쇠인 경우 열쇠를 얻었음을 표시.
						nKey = nKey | (1 << (maze[nx][ny] - 'a'));
					}else if('A' <= maze[nx][ny] && maze[nx][ny] <= 'F') {	//문인 경우 해당하는 열쇠가 있는지 확인, 없으면 다음 위치 탐색.
						if((state.key & (1 << (maze[nx][ny] - 'A'))) == 0) {
							continue;
						}
					}
					
					if(check[nx][ny][nKey] > state.t + 1) {	//다음 위치(nx, ny)에 열쇠(nKey)를 들고가는 것이 더 단축되면 탐색을 계속하도록 큐에 넣는다.
						check[nx][ny][nKey] = state.t + 1;
						queue.add(new State(nx, ny, nKey, state.t + 1));
					}
				}
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
