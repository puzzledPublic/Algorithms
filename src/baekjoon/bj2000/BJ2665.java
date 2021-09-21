package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//미로만들기
public class BJ2665 {
	static class State {
		int x, y, b;
		State(int x, int y, int b) {
			this.x = x;
			this.y = y;
			this.b = b;	//지나온 검은방 개수
		}
	}
	static char[][] map;
	static int[][] chk;	//체크배열 및 (i, j)까지 오는데 지나온 검은방 최소 개수
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new char[N][];
		chk = new int[N][N];
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			Arrays.fill(chk[i], -1);
		}
		
		int result = Integer.MAX_VALUE;
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(0, 0, 0));
		chk[0][0] = 0;
		while(!queue.isEmpty()) {	//BFS
			State curr = queue.poll();
			
			if(curr.x == N - 1 && curr.y == N - 1) {
				result = Math.min(result, curr.b);
			}
			
			for(int i = 0; i < d.length; i++) {
				int nx = curr.x + d[i][0], ny = curr.y + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < N)) {
					if(map[nx][ny] == '1' && (chk[nx][ny] == -1 || chk[nx][ny] > curr.b)) {	//이동할 방이 흰색방이고, 방문하지 않았거나 검은방을 덜 지나서 도착하는 경우.
						chk[nx][ny] = curr.b;
						queue.add(new State(nx, ny, curr.b));
					}else if(map[nx][ny] == '0' && (chk[nx][ny] == -1 || chk[nx][ny] > curr.b + 1)){	//이동할 방이 검은색이고, 방문하지 않았거나 검은방을 덜 지나서 도착하는 경우.
						chk[nx][ny] = curr.b + 1;
						queue.add(new State(nx, ny, curr.b + 1));
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
