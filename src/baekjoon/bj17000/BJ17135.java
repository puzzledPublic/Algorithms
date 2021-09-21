package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//캐슬 디펜스
public class BJ17135 {
	static int N, M, D, Maximum;
	static int[] castle;
	static int[][] battleField, temp;
	static boolean[][] visited;
	static int[][] d = {{0, -1}, {-1, 0}, {0, 1}};
	static class Coord {
		int x, y, step;
		Coord(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	static Queue<Coord> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		castle = new int[3];
		temp = new int[N][M];
		battleField = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				battleField[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0, 0);
		
		bw.write(Maximum + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void solve(int n, int next) {
		if(n == 3) {	//3명을 배정한 상태에서
			int dead = 0, check = 2;
			for(int i = 0; i < N; i++) {	//적들 상태 복사.
				for(int j = 0; j < M; j++) {
					temp[i][j] = battleField[i][j];
				}
			}
			for(int u = N - 1; u >= 0; u--) {	//적이 내려오기보다 성이 올라간다고 생각하자.
				for(int k = 0; k < 3; k++) {	//각 궁수들에 대해
					for(int i = 0; i < N; i++) {	//bfs를 위한 방문 배열 초기화
						for(int j = 0; j < M; j++) {
							visited[i][j] = false;
						}
					}
					queue.clear();
					queue.add(new Coord(u, castle[k], 1));	//bfs시작.
					visited[u][castle[k]] = true;
					while(!queue.isEmpty()) {
						Coord coord = queue.poll();
						if(0 < temp[coord.x][coord.y] && temp[coord.x][coord.y] <= check && coord.step <= D) {	//적이 있고 사거리 내라면
							if(temp[coord.x][coord.y] == 1) {	//한턴에 궁수들이 하나의 적에 동시공격이 가능하므로 1인 경우만 죽은 적의 수 증가.
								temp[coord.x][coord.y] = check;	//죽었다고 표시
								dead++;
							}
							break;
						}
						
						if(coord.step > D) {	//거리가 D를 넘어가면 더 탐색할 필요없음.
							break;
						}
						
						for(int i = 0; i < d.length; i++) {	//왼쪽, 위, 오른쪽 순으로 탐색
							int nx = coord.x + d[i][0], ny = coord.y + d[i][1];
							if((0 <= nx && nx <= u) && (0 <= ny && ny < M) && !visited[nx][ny]) {
								visited[nx][ny] = true;
								queue.add(new Coord(nx, ny, coord.step + 1));
							}
						}
					}
				}
				for(int i = 0; i < N; i++) {	//죽었다고 표시한 적을 제거
					for(int j = 0; j < M; j++) {
						if(temp[i][j] == 2) {
							temp[i][j] = 0;
						}
					}
				}
			}
			if(Maximum < dead) {	//죽은 적의 수 갱신
				Maximum = dead;
			}
			return;
		}
		
		for(int i = next; i < M; i++) {	//궁수 3명을 배정한다.
			castle[n] = i;
			solve(n + 1, i + 1);
		}
	}
}
