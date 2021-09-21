package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상범 빌딩
public class BJ6593 {
	static class Coord {
		int l, r, c, step;
		Coord(int l, int r, int c, int step) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.step = step;
		}
		@Override
		public boolean equals(Object obj) {
			Coord coord = (Coord)obj;
			return this.l == coord.l && this.r == coord.r && this.c == coord.c;
		}
	}
	static int[][] d = {{0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}};	//현재 위치 기준 우, 하, 좌, 상, 위, 아래
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int L = Integer.parseInt(st.nextToken()); 
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			if(L == 0 && R == 0 && C == 0) {	//입력 끝
				break;
			}
			
			char[][][] building = new char[L][R][];
			Coord start = null;	//S지점
			Coord end = null;	//E지점
			
			for(int i = 0; i < L; i++) {
				for(int j = 0; j < R; j++) {
					building[i][j] = br.readLine().toCharArray();
					for(int k = 0; k < C; k++) {
						if(building[i][j][k] == 'S') {
							start = new Coord(i, j, k, 0);
						}else if(building[i][j][k] == 'E') {
							end = new Coord(i, j, k, -1);
						}
					}
				}
				br.readLine();
			}
			
			Queue<Coord> queue = new LinkedList<>();
			queue.add(start);
			
			while(!queue.isEmpty()) {
				Coord current = queue.poll();
				
				if(current.equals(end)) {	//끝 지점에 도달하면 종료
					end.step = current.step;
					break;
				}
				
				for(int i = 0; i < d.length; i++) {	//현재위치에서(current) 상,하,좌,우,위,아래를 검사하며 갈 수 있다면 큐에 넣는다.
					int nl = current.l + d[i][0], nr = current.r + d[i][1], nc = current.c + d[i][2];
					if((0 <= nl && nl < L) && (0 <= nr && nr < R) && (0 <= nc && nc < C)) {
						if(building[nl][nr][nc] == '.' || building[nl][nr][nc] == 'E') {
							building[nl][nr][nc] = 'X';	//재방문 방지를 위해 표시를 한다.
							queue.add(new Coord(nl, nr, nc, current.step + 1));
						}
					}
				}
			}
			
			if(end.step == -1) {	//끝 지점에 도달하지 못했다면 Trapped!
				bw.write("Trapped!\n");
			}else {					//도착했다면 Escaped!
				bw.write("Escaped in " + end.step + " minute(s).\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
