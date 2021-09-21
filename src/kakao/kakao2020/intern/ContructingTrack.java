package kakao.kakao2020.intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//경주로 건설
public class ContructingTrack {
	public static void main(String[] args) {
		int[][][] boards = { 
				{ 
					{ 0, 0, 0 }, 
					{ 0, 0, 0 }, 
					{ 0, 0, 0 } 
				},
				{ 
					{ 0, 0, 0, 0, 0, 0, 0, 1 }, 
					{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
					{ 0, 0, 0, 0, 0, 1, 0, 0 },
					{ 0, 0, 0, 0, 1, 0, 0, 0 }, 
					{ 0, 0, 0, 1, 0, 0, 0, 1 }, 
					{ 0, 0, 1, 0, 0, 0, 1, 0 },
					{ 0, 1, 0, 0, 0, 1, 0, 0 }, 
					{ 1, 0, 0, 0, 0, 0, 0, 0 } },
				{ 
					{ 0, 0, 1, 0 }, 
					{ 0, 0, 0, 0 }, 
					{ 0, 1, 0, 1 }, 
					{ 1, 0, 0, 0 } 
				},
				{ 
					{ 0, 0, 0, 0, 0, 0 }, 
					{ 0, 1, 1, 1, 1, 0 }, 
					{ 0, 0, 1, 0, 0, 0 }, 
					{ 1, 0, 0, 1, 0, 1 },
					{ 0, 1, 0, 0, 0, 1 }, 
					{ 0, 0, 0, 0, 0, 0 } 
				}, 
			};
		
		for(int i = 0; i < boards.length; i++) {
			System.out.println(solution(boards[i]));
		}
	}

	static class State {
		int x, y, cost, dir;
		public State(int x, int y, int cost, int dir) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dir = dir;
		}
	}
	static int[][] d = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
	static int solution(int[][] board) {
		int answer = 0;
		
		int N = board.length;
		int[][] check = new int[N][N];
		for(int i = 0; i < N; i++) {
			Arrays.fill(check[i], Integer.MAX_VALUE);
		}
		
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(0, 0, 0, 0));
		queue.add(new State(0, 0, 0, 1));
		check[0][0] = 0;
		while(!queue.isEmpty()) {
			State curr = queue.poll();
			
			for(int i = 0; i < d.length; i++) {
				int nx = curr.x + d[i][0], ny = curr.y + d[i][1];
				int cost = curr.dir == i ? 100 : 600;
				if((0 <= nx && nx < N) && (0 <= ny && ny < N) && board[nx][ny] != 1 && check[nx][ny] >= curr.cost + cost) {
//					System.out.println("(" + curr.x + " " + curr.y + ") -> (" + nx + " " + ny + ")" + " " + (curr.cost + cost));
					check[nx][ny] = curr.cost + cost;
					queue.add(new State(nx, ny, curr.cost + cost, i));
				}
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.print(check[i][j] + " ");
//			}System.out.println();
//		}
		
		return answer = check[N - 1][N - 1];
	}
}
