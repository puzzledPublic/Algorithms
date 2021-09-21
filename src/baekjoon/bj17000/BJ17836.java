package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//공주님을 구해라!
public class BJ17836 {
	static class State {
		int x, y, t;
		State(int x, int y, int t) {
			this.x = x;
			this.y = y;
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
		int T = Integer.parseInt(st.nextToken());
		
		int[][] castle = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				castle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<State> queue = new LinkedList<>();
		
		queue.add(new State(0, 0, 0));
		castle[0][0] = 1;
		int rescue = -1;	//검 없이 구할때 최소 시간
		int sword = -1;		//검을 구하게 되는 최소 시간
		int swordX = -1;	//검의 위치
		int swordY = -1;
		
		while(!queue.isEmpty()) {	//최소 시간을 위한 BFS.
			
			State state = queue.poll();
			if(state.x == N - 1 && state.y == M - 1 && rescue == -1) {	//공주의 위치에 다다르면 최소 시간 저장.
				rescue = state.t;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nx = state.x + d[i][0], ny = state.y + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && castle[nx][ny] != 1) {
					if(castle[nx][ny] == 2) {	//검의 위치에 다다르면 최소 시간 및 위치 저장
						sword = state.t + 1;
						swordX = nx;
						swordY = ny;
					}
					castle[nx][ny] = 1;
					queue.add(new State(nx, ny, state.t + 1));
				}
			}
		}
		
		int result = -1;
		if(rescue == -1 && sword == -1) {	//공주, 검 위치에 도달할 수 없는 경우.
			result = -1;
		}else if(rescue == -1){	//공주의 위치에 도달할 수 없는 경우.
			sword += Math.abs(N - swordX - 1) + Math.abs(M - swordY - 1);
			result = sword;
		}else if(sword == -1) {	//검의 위치에 도달할 수 없는 경우.
			result = rescue;
		}else {	//공주, 검 위치에 도달할 수 있는 경우.
			sword += Math.abs(N - swordX - 1) + Math.abs(M - swordY - 1);
			result = Math.min(rescue, sword);
		}
		
		if(result == -1 || result > T) {	//도달하지 못하거나(-1) 도달할 수 있어도 T시간이 지나는 경우 실패.
			bw.write("Fail\n");
		}else {	//T시간 이내 도달할 수 있으면 최소 시간 출력
			bw.write(result + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
