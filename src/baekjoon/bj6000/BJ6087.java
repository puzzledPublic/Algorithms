package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//레이저 통신
public class BJ6087 {
	static class State {
		int x, y, mirror, prevDir;
		State(int x, int y, int prevDir, int mirror) {
			this.x = x;
			this.y = y;
			this.prevDir = prevDir;
			this.mirror = mirror;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int sx = -1, sy = -1, dx = -1, dy = -1;
		int[][] map = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < W; j++) {
				char ch = tmp.charAt(j);
				if(ch == 'C') {
					if(sx == -1) {	//시작 위치
						sx = i;
						sy = j;
					}else {			//도착 위치
						dx = i;
						dy = j;
					}
				}
				if(ch == 'C') {
					map[i][j] = 987654321;	//'C'인 경우
				}else if(ch == '.') {
					map[i][j] = 987654320;	//'.'인 경우
				}else {
					map[i][j] = Integer.MAX_VALUE;	//'*'인 경우
				}
			}
		}
		
		int result = Integer.MAX_VALUE;
		
		Queue<State> pq = new LinkedList<>();
		pq.add(new State(sx, sy, -1, 0));
		map[sx][sy] = 987654322;
		while(!pq.isEmpty()) {
			State s = pq.poll();
			
			for(int i = 0; i < d.length; i++) {
				int nx = s.x + d[i][0], ny = s.y + d[i][1];
				if((0 <= nx && nx < H) && (0 <= ny && ny < W)) {
					int mirror = s.mirror;
					if(s.prevDir != -1 && s.prevDir != i) {	//이전 방향하고 다음 나아갈 방향이 다르다면 거울 설치.
						mirror++;
					}
					//다음 나아갈 위치가 처음 방문하는 곳(987654320)이거나 이미 방문했으나 mirror 설치 수가 더 많다면 다시 탐색한다.
					if(map[nx][ny] == 987654320 || (map[nx][ny] < 987654320 && map[nx][ny] >= mirror)) {
						pq.add(new State(nx, ny, i, mirror));
						map[nx][ny] = mirror;
					}else if(map[nx][ny] == 987654321) {	//'C'에 도착한 경우.
						if(result > mirror) {	//갱신
							result = mirror;
						}
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
