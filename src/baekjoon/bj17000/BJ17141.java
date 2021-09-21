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

//연구소 2
public class BJ17141 {
	static class VirusCoord {
		int x, y;
		VirusCoord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, minTime = Integer.MAX_VALUE;	//N = 연구소 크기, M = 바이러스 갯수, minTime = 바이러스가 다 퍼지는데 최소시간
	static int[][] laboratory;
	static int[][] virusCoord = new int[10][2];	//virus를 놓을 위치
	static List<VirusCoord> list = new ArrayList<>();	//virus를 놓을 수 있는 위치
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
				if(laboratory[i][j] == 2) {	//바이러스를 놓을 수 있는 위치를 저장.
					laboratory[i][j] = 0;	//지나갈 수 있는곳으로 표시한다.
					list.add(new VirusCoord(i, j));
				}else if(laboratory[i][j] == 1) {	//laboratory자체를 방문 표시 배열로도 사용할것이므로 방문할 수 없는 곳(벽)은 -1로 해놓는다.
					laboratory[i][j] = -1;
				}
			}
		}
		
		solve(0, 0);
		
		bw.write((minTime == Integer.MAX_VALUE ? "-1" : (minTime - 1)) + "\n");	//minTime이 Integer.MAX_VALUE라면 바이러스가 연구소 전체에 퍼진적이 없다는 것.
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(int n, int next) {	//바이러스 놓을 위치를 정한다.
		if(n == M) {	//M개의 바이러스 놓을 위치가 정해졌다면
			Queue<VirusCoord> queue = new LinkedList<>();
			for(int i = 0; i < M; i++) {	//M개의 바이러스 시작 위치를 큐에 저장
				laboratory[virusCoord[i][0]][virusCoord[i][1]] = 1;
				queue.add(new VirusCoord(virusCoord[i][0], virusCoord[i][1]));
			}
			
			while(!queue.isEmpty()) {	//BFS
				VirusCoord vc = queue.poll();
				for(int i = 0; i < d.length; i++) {
					int nx = vc.x + d[i][0], ny = vc.y + d[i][1];
					if((0 <= nx && nx < N) && (0 <= ny && ny < N) && laboratory[nx][ny] == 0) {
						laboratory[nx][ny] = laboratory[vc.x][vc.y] + 1;
						queue.add(new VirusCoord(nx, ny));
					}
				}
			}
			
			boolean allSpreaded = true;	//바이러스가 연구소 전체에 퍼졌는지 여부
			int time = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(laboratory[i][j] == 0) {	//0이라면 바이러스가 연구소 전체에 퍼지지 못했다.
						allSpreaded = false;
					}
					if(time < laboratory[i][j]) {	//바이러스가 퍼진 최대 시간을 기록
						time = laboratory[i][j];
					}
					if(laboratory[i][j] > 0) {	//다음 바이러스 위치를 정하고 BFS를 돌리기위해 초기화 해놓는다. (-1(벽)은 그대로 놔두고 양수만 0으로 만들면 된다)
						laboratory[i][j] = 0;
					}
				}
			}
			
			if(allSpreaded && minTime > time) {	//연구소 전체에 바이러스가 퍼졌고 퍼진 시간이 전에 구해놓은 시간보다 작다면 갱신
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
