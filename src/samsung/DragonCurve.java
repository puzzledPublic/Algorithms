package samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DragonCurve {
	static int N;
	static int[][] DragonCurveInfo;
	static int[][] Board = new int[101][101];
	static int[][] Directions= {
		{1, 0}, {0, -1}, {-1, 0}, {0, 1}
	};
	static int[][] sq= {
		{0, 1}, {1, 0}, {1,1}
	};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		N = input.nextInt();
		DragonCurveInfo = new int[N][4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 4; j++) {
				DragonCurveInfo[i][j] = input.nextInt();
			}
		}
		
		solve();
		
		for(int i = 0; i < 20; i++) {
			for(int j = 0; j < 20; j++) {
				System.out.print(Board[i][j] + " ");
			}
			System.out.println();
		}
	}
	static void solve() {
		Queue<Position> preQueue = new LinkedList<>();
		Queue<Position> waitQueue = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			int startX, startY;
			startX = DragonCurveInfo[i][0];
			startY = DragonCurveInfo[i][1];
		    Position base = new Position(startX + Directions[DragonCurveInfo[i][2]][0], startY + Directions[DragonCurveInfo[i][2]][1]);
			
			Board[startX][startY] = Board[base.x][base.y] = 1;
			
			preQueue.add(new Position(base.x, base.y));
			
			for(int j = 0; j < DragonCurveInfo[i][3]; j++) {
				base = rotate90Degree(startX, startY, base.x, base.y);
				if(base.x < 0 || base.x >= 101 || base.y < 0 || base.y >= 101) {
					 break;
				}
				while(!preQueue.isEmpty()) {
					Position p = preQueue.poll();
					waitQueue.add(p);
					
					if(p.x >= 0 && p.x < 101 && p.y >= 0 && p.y < 101) {
						Board[p.x][p.y] = 1;
					}
					Position tp = rotate90Degree(p.x, p.y, base.x, base.y);
					waitQueue.add(tp);
				}
				while(!waitQueue.isEmpty()) {
					Position p = waitQueue.poll();
					preQueue.add(p);
				}
				preQueue.add(new Position(base.x, base.y));
				if(base.x >= 0 && base.x < 101 && base.y >= 0 && base.y < 101) {
					Board[base.x][base.y] = 1; 
				}
			}
			preQueue.clear();
			waitQueue.clear();
		}
		int count = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(Board[i][j] == 1 && isSquare(i,j)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static boolean isSquare(int x, int y) {
		for(int i = 0; i < sq.length; i++) {
			if(Board[x + sq[i][0]][y + sq[i][1]] == 0) {
				return false;
			}
		}
		return true;
	}
	static Position rotate90Degree(int x, int y, int baseX, int baseY) {
		int relativeX = -baseX, relativeY = -baseY;
		x += relativeX;
		y += relativeY;
		
		int temp = x;
		x = -y;
		y = temp;
		
		x -= relativeX;
		y -= relativeY;

		return new Position(x, y);
	}
}
class Position {
	int x, y;
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
