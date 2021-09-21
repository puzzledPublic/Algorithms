package algorithmsForPS;

import java.util.Scanner;

public class AfcMiningOre {
	static int mine[][] = {
		{1, 1, 0, 1, 1},
		{0, 0, 1, 0, 1},
		{1, 1, 0, 1, 0},
		{1, 0, 1, 0, 1},
		{1, 1, 0, 0, 1}
	};
	static int cache[][] = new int[100][100];
	static int cache2[][] = new int[100][100];
	static int cache3[][] = new int[100][100];
	//static int width, height;
	public static void main(String[] args) {/*
		Scanner input = new Scanner(System.in);
		height = input.nextInt();
		width = input.nextInt();
		
		mine = new int[height][width];
		
		for(int i = 0 ; i < height; i++) {
			for(int j = 0 ; j < width; i++) {
				mine[i][j] = input.nextInt();
			}
		}
		*/
		System.out.println(mining(mine.length - 1, mine[0].length - 1));
		System.out.println(mining2(0,0));
		System.out.println(mining3());
	}
	//하향식 접근 방법 
	static int mining(int x, int y) {
		
		if(x < 0 || y < 0) {
			return Integer.MIN_VALUE;
		}
		
		if(x == 0 && y == 0) {
			return mine[x][y];
		}
		if(cache[x][y] > 0) {
			return cache[x][y];
		}
		return cache[x][y] = Math.max(mining(x - 1,y), mining(x, y - 1)) + mine[x][y];
	}
	//다이나미컬 백트래킹
	static int mining2(int x, int y) {
		if(cache2[x][y] > 0) {
			return cache2[x][y];
		}
		if(x == mine.length - 1 && y == mine[0].length - 1) {
			return mine[x][y];
		}
		if(x > mine.length - 1 || y > mine[0].length - 1) {
			return Integer.MIN_VALUE;
		}
		return cache2[x][y] = Math.max(mining2(x + 1, y), mining2(x, y + 1)) + mine[x][y];
	}
	//상향식 접근 방법
	static int mining3() {
		for(int i = 0 ; i < mine.length ; i++) {
			for(int j = 0 ; j < mine[0].length ; j++) {
				if(i == 0 && j == 0) {
					cache3[i][j] = mine[i][j];
				}
				else if(i == 0) {
					cache3[i][j] = cache3[i][j-1] + mine[i][j];
				}
				else if(j == 0) {
					cache3[i][j] = cache3[i-1][j] + mine[i][j];
				}
				else {
					int a = cache3[i - 1][j];
					int b = cache3[i][j - 1];
					cache3[i][j] = Math.max(a, b) + mine[i][j];
				}
			}
		}
		for(int i = 0 ; i < 5 ; i++) {
			for(int j = 0 ; j < 5 ; j++) {
				System.out.print(cache3[i][j]+" ");
			}
			System.out.println();
		}
		return cache3[mine.length - 1][mine[0].length - 1];
	}
}
