package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//연구소 3
public class BJ17142 {
	static class VirusCoord {
		int x, y;
		VirusCoord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, minTime = Integer.MAX_VALUE;
	static int[][] laboratory;
	static int[][] virusCoord;
	static List<VirusCoord> list = new ArrayList<>();
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		laboratory = new int[N][N];
		virusCoord = new int[M][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				laboratory[i][j] = Integer.parseInt(st.nextToken());
				if(laboratory[i][j] == 2) {
					list.add(new VirusCoord(i, j));
					laboratory[i][j] = 0;
				}else if(laboratory[i][j] == 1) {
					laboratory[i][j] = -1;
				}
			}
		}
		
		solve(0, 0);
		
		bw.write((minTime == Integer.MAX_VALUE ? "-1" : (minTime - 1)) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, int next) {
		if(n == M) {
			Queue<VirusCoord> queue = new LinkedList<>();
			for(int i = 0; i < M; i++) {
				laboratory[virusCoord[i][0]][virusCoord[i][1]] = 1;
				queue.add(new VirusCoord(virusCoord[i][0], virusCoord[i][1]));
			}
			
			while(!queue.isEmpty()) {
				VirusCoord vc = queue.poll();
				for(int i = 0; i < d.length; i++) {
					int nx = vc.x + d[i][0], ny = vc.y + d[i][1];
					if((0 <= nx && nx < N) && (0 <= ny && ny < N) && laboratory[nx][ny] == 0) {
						laboratory[nx][ny] = laboratory[vc.x][vc.y] + 1;
						queue.add(new VirusCoord(nx, ny));
					}
				}
			}
			
			boolean allSpreaded = true;
			int time = 0;
			//나머지 부분은 연구소 2(BJ17141)과 동일하나 활성화되는 바이러스를 1로 바꿔 시간계산에 쓰지 않도록 한다.
			for(int i = 0; i < list.size(); i++) {
				laboratory[list.get(i).x][list.get(i).y] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(laboratory[i][j] == 0) {
						allSpreaded = false;
					}
					if(time < laboratory[i][j]) {
						time = laboratory[i][j];
					}
					if(laboratory[i][j] != -1) {
						laboratory[i][j] = 0;
					}
				}
			}
			
			if(allSpreaded && minTime > time) {
				minTime = time;
			}
			
			return;
		}
		
		for(int i = next; i < list.size(); i++) {
			VirusCoord vc = list.get(i);
			virusCoord[n][0] = vc.x;
			virusCoord[n][1] = vc.y;
			solve(n + 1, i + 1);
		}
	}
}
