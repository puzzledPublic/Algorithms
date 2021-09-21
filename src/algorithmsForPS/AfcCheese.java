package algorithmsForPS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AfcCheese {
	static Queue<Position> queue = new LinkedList<>();
	static int arr[][] = {
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 1, 1, 0},
		{0, 0, 1, 1, 1, 1, 1, 1, 0},
		{0, 0, 1, 1, 1, 1, 1, 0, 0},
		{0, 0, 1, 1, 0, 1, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	static int arr2[][] = {
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 0, 0, 0},
		{0, 0, 0, 1, 1, 0, 1, 1, 0},
		{0, 0, 1, 1, 1, 1, 1, 1, 0},
		{0, 0, 1, 1, 1, 1, 1, 0, 0},
		{0, 0, 1, 1, 0, 1, 1, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0},
		{0, 0, 0, 0, 0, 0, 0, 0, 0}
	};
	static int n = 8, m = 9;
	public static void main(String[] args) {
		
		/*Scanner input = new Scanner(System.in);
		
		int n, m;
		n = input.nextInt();
		m = input.nextInt();
		arr = new int[n+1][m+1];
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < m; i++) {
				arr[i][j] = input.nextInt();
			}
		}*/
		
		//solve1();
		solve2();
		
	}
	static void solve1() { 
		int count;
		int hour = 0;
		while(true) {
			fill(0, 0);
			count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j] == 1 && check(i, j) >= 2) {
						arr2[i][j] = 0;
						count++;
					}
				}
			}
			if(count == 0) {
				System.out.println(hour);
				break;
			}
			hour++;
			for(int i = 0; i < arr.length; i++) {
				arr[i] = Arrays.copyOf(arr2[i], arr[i].length);
			}
		}
	}
	static void solve2() {
		int count;
		int hour = 0;
		fill(0,0);
		while(true) {
			count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m ; j++) {
					if(arr[i][j] == 1 && check(i,j) >= 2) {
						queue.add(new Position(i,j));
						count++;
					}
				}
			}
			if(count == 0) {
				System.out.println(hour);
				break;
			}
			hour++;
			while(!queue.isEmpty()) {
				Position pos = queue.poll();
				arr[pos.x][pos.y] = 0; 
				fill(pos.x, pos.y);
			}
		}
	}
	static void fill(int x, int y) {
		if(x < 0 || x > n - 1 || y < 0 || y > m - 1) {
			return;
		}
		if(arr[x][y] == 0) {
			arr[x][y] = 2;
			fill(x + 1, y);
			fill(x, y + 1);
			fill(x - 1, y);
			fill(x, y - 1);
		}
	}
	static int check(int x, int y) {
		int t = 0;
		if(arr[x + 1][y] == 2) t++;
		if(arr[x][y + 1] == 2) t++;
		if(arr[x - 1][y] == 2) t++;
		if(arr[x][y - 1] == 2) t++;
		return t;
	}
}
class Position {
	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int x, y;
	
}
