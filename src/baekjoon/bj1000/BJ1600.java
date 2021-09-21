package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//말이 되고픈 원숭이	(문제를 잘보자 W =>가로, H => 세로, 반대로 두고 풀어서 런타임에러 뿜뿜)
public class BJ1600 {
	static class CoordState {
		int x, y, k, step;
		CoordState(int x, int y, int k, int step) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.step = step;
		}
	}
	static int[][] monkey = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	static int[][] horse = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];	//현재 맵
		boolean[][][] step = new boolean[H][W][K + 1];	//H,W위치를 말처럼 K번 이동해서 갔는지 여부
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < W; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}
		
		Queue<CoordState> queue = new LinkedList<>();
		queue.add(new CoordState(0, 0, 0, 0));
		step[0][0][0] = true;
		int result = -1;
		while(!queue.isEmpty()) {
			CoordState cs = queue.poll();
			if(cs.x == H - 1 && cs.y == W - 1) {	//도착지점에 도달했다면 리턴
				result = cs.step;
				break;
			}
			if(cs.k < K) {	//K번만큼 사용하지 않은 경우, 아직 말 처럼 이동할 수 있다.
				for(int i = 0; i < horse.length; i++) {
					int nx = cs.x + horse[i][0], ny = cs.y + horse[i][1];
					if((0 <= nx && nx < H) && (0 <= ny && ny < W) && (map[nx][ny] != '1') && !step[nx][ny][cs.k + 1]) {	//다음 위치를 이미 k+1번 사용하여 이동했다면 더 이상 방문할 필요 없음
						queue.add(new CoordState(nx, ny, cs.k + 1, cs.step + 1));	//다음 위치로 이동
						step[nx][ny][cs.k + 1] = true;	//체크
					}
				}
			}
			//인접좌표로 이동하는 경우, 원숭이처럼 이동한다.
			for(int i = 0; i < monkey.length; i++) {
				int nx = cs.x + monkey[i][0], ny = cs.y + monkey[i][1];
				if((0 <= nx && nx < H) && (0 <= ny && ny < W) && (map[nx][ny] != '1') && !step[nx][ny][cs.k]) {
					queue.add(new CoordState(nx, ny, cs.k, cs.step + 1));
					step[nx][ny][cs.k] = true;
				}
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
