package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//주난의 난
public class BJ14497 {
	static class State {
		int x, y, num;
		State(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int[][] check = new int[N][M];	//방문체크배열
		check[x1 - 1][y1 - 1] = 1;	//시작점 체크
		
		PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> a.num - b.num);	//시도 횟수가 낮은 것부터 탐색하기위해 우선순위 큐 사용
		pq.add(new State(x1 - 1, y1 - 1, 1));
		while(!pq.isEmpty()) {
			State curr = pq.poll();
			
			if(curr.x == x2 - 1 && curr.y == y2 - 1) {	//도착점에 도달하면 종료
				bw.write(curr.num + "\n");
				break;
			}
			
			for(int i = 0; i < d.length; i++) {
				int nx = curr.x + d[i][0], ny = curr.y + d[i][1];
				if((0 <= nx && nx < N) && (0 <= ny && ny < M) && check[nx][ny] == 0) {
					if(map[nx][ny] == '1') {	//다음 위치가 '1'인 경우 횟수가 1증가.
						check[nx][ny] = curr.num + 1;
					}else {	//'0'인 경우 횟수는 그대로
						check[nx][ny] = curr.num;
					}
					pq.add(new State(nx, ny, check[nx][ny]));
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
