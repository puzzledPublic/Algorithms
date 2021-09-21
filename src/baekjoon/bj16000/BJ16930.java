package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//달리기
public class BJ16930 {
	static class Coord {
		int x, y;
		Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] ground = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				if(str.charAt(j) == '.') {	//'.'인 경우 0으로
					ground[i][j] = 0;
				}else {	//'#'인 경우 -1로
					ground[i][j] = -1;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int sx = Integer.parseInt(st.nextToken()) - 1;
		int sy = Integer.parseInt(st.nextToken()) - 1;
		int ex = Integer.parseInt(st.nextToken()) - 1;
		int ey = Integer.parseInt(st.nextToken()) - 1;
		
		int result = -1;
		Queue<Coord> queue = new LinkedList<>();
		queue.add(new Coord(sx, sy));
		ground[sx][sy] = 1;	//시작지점을 1으로
		while(!queue.isEmpty()) {
			Coord coord = queue.poll();

			if(coord.x == ex && coord.y == ey) {	//도착했다면 종료.
				result = ground[ex][ey] - 1;	//시작지점을 1부터 시작했으로 -1한 값이 정답.
				break;
			}
			
			for(int i = 0; i < d.length; i++) {	//4방향에 대해
				for(int j = 1; j <= K; j++) {	//1 ~ K번 만큼 달려갈 수 있다.
					int nx = coord.x + (d[i][0] * j), ny = coord.y + (d[i][1] * j);
					if((0 <= nx && nx < N) && (0 <= ny && ny < M) && ground[nx][ny] == 0) {	//다음 위치가 범위내이고 '.'(0)이라면 이동 가능.
							ground[nx][ny] = ground[coord.x][coord.y] + 1;
							queue.add(new Coord(nx, ny));
					}else if((0 <= nx && nx < N) && (0 <= ny && ny < M) && ground[nx][ny] == ground[coord.x][coord.y] + 1){
						//만약 같은 시간을 탐색할때 수직으로 움직이는 경우를 먼저 탐색하고 그다음에 수평으로 움직이는 경우 수직으로 움직인 표시때문에 수평 탐색을 중간에 멈추는 경우를 방지해야한다.
						//그래서 다음 위치의 시간이 이미 현재 탐색하는 시간과 같은 경우에 계속 진행하도록 한다.
						continue;
					}else { //그 외는 더이상 탐색할 필요 없음.
						break;
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
