package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//불
public class BJ5427 {
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static class Coord {
		boolean isFire;	//현재 좌표가 불인가, 사람인가
		int x, y, step;	//현재 좌표, 흐른 시간
		Coord(int x, int y, int step, boolean isFire) {
			this.x = x;
			this.y = y;
			this.step = step;
			this.isFire = isFire;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		char[][] building = new char[1000][1000];
		PriorityQueue<Coord> queue = new PriorityQueue<BJ5427.Coord>((a, b) -> {	//사람-> 불 순서로 탐색하기 위해 priorityQueue를 쓴다.
			if(a.step == b.step) {
				if(a.isFire == b.isFire) {
					return 0;
				}else if(a.isFire == true && b.isFire == false) {
					return 1;
				}else {
					return -1;
				}
			}
			return Integer.compare(a.step, b.step);
		});
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
			for(int j = 0; j < H; j++) {
				String str = br.readLine();
				for(int k = 0; k < W; k++) {
					building[j][k] = str.charAt(k);
					if(building[j][k] == '*') {	//초기 불의 위치를 큐에 저장
						queue.add(new Coord(j, k, 0, true));
					}else if(building[j][k] == '@') {	//초기 사람 위치를 큐에 저장
						queue.add(new Coord(j, k, 0, false));
					}
				}
			}
			int result = -1;
			while(!queue.isEmpty()) {
				Coord current = queue.poll();
				if(!current.isFire && building[current.x][current.y] == '*') {	//이미 불이 붙었다면 계속탐색
					continue;
				}
				if(!current.isFire && (current.x == 0 || current.x == H - 1 || current.y == 0 || current.y == W - 1)) {	//외곽까지 나갔다면 탈출.
					result = current.step + 1;
					break;
				}
				
				for(int j = 0; j < d.length; j++) {
					int nx = current.x + d[j][0], ny = current.y + d[j][1];
					if((0 <= nx && nx < H) && (0 <= ny && ny < W)) {
						if(current.isFire) {	//불인 경우 번지게 만든다.
							if(building[nx][ny] == '.' || building[nx][ny] == '@') {
								queue.add(new Coord(nx, ny, current.step + 1, current.isFire));
								building[nx][ny] = '*';
							}
						}else {	//사람인 경우 움직이게 만든다.
							if(building[nx][ny] == '.') {
								queue.add(new Coord(nx, ny, current.step + 1, current.isFire));
								building[nx][ny] = '@';
							}
						}
					}
				}
			}
			
			if(result == -1) {
				bw.write("IMPOSSIBLE\n");
			}else {
				bw.write(result + "\n");
			}
			queue.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
