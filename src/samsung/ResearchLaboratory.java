package samsung;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import samsung.ChickenDelivery.Position;
//연구소 (백준 14502)
public class ResearchLaboratory {
	static int N, M, result = -1;
	static int[][] Laboratory;
	static int[][] Direction = {{0,1},{-1,0},{0,-1},{1,0}};
	static List<Position> VirusPosition = new LinkedList<>();
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		Laboratory = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				Laboratory[i][j] = input.nextInt();
				if(Laboratory[i][j] == 2) {
					VirusPosition.add(new Position(i, j));
				}
			}
		}
		solve(3, 0);	//3개의 벽
		System.out.println(result);
	}
	
	static void solve(int n, int x) {
		if(n == 0) {	//벽을 다 세웠다면
			for(Position p : VirusPosition) {	//모든 바이러스 위치에 대해 dfs
				dfs(p.x, p.y);
			}
			int temp = 0;
			for(int i = 0; i < N; i++) {	//감염 안된 지역 합산
				for(int j = 0; j < M; j++) {
					if(Laboratory[i][j] == 0) {
						temp++;
					}
					if(Laboratory[i][j] == 2) {	//다른 벽을 세운 경우를 위해 바이러스를 원 상태로
						Laboratory[i][j] = 0;
					}
				}
			}
			for(Position p : VirusPosition) {
				Laboratory[p.x][p.y] = 2;
			}
			if(result < temp) {	//이전에 구한 합산이 현재 구한 합산보다 작으면
				result = temp;
			}
			return;
		}
		for(int i = x; i < N; i++) {	//벽을 세워 나간다.
			for(int j = 0; j < M; j++) {
				if(Laboratory[i][j] == 0) {
					Laboratory[i][j] = 1;
					solve(n - 1, x);
					Laboratory[i][j] = 0;
				}
			}
		}
	}
	
	static void dfs(int x, int y) {	//감염 dfs
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x,y));
		while(!queue.isEmpty()) {
			Position p = queue.poll();
			for(int i = 0; i < Direction.length; i++) {
				x = p.x + Direction[i][0];
				y = p.y + Direction[i][1];
				if(x >= 0 && x < N && y >= 0 && y < M && Laboratory[x][y] == 0) {
					Laboratory[x][y] = 2;
					queue.add(new Position(x, y));
				}
			}
		}
	}
}