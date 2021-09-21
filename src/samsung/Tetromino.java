package samsung;

import java.util.Scanner;
//테트로미노 (백준 14500)
public class Tetromino {
	static int N, M;
	static int[][] paper;
	static int[][][][] tetromino = {
		{ 
			{ {0, 1}, {0, 2}, {0, 3} },  
			{ {1, 0}, {2, 0}, {3, 0} }
		}, 
		{
			{ {0, 1}, {1, 0}, {1, 1} }
		}, 
		{
			{ {0, 1}, {0, 2}, {1, 0} },
			{ {1, 0}, {1, 1}, {1, 2} },
			{ {0, 1}, {0, 2}, {1, 2} },
			{ {0, 1}, {0, 2}, {-1, 2} },
			{ {0, 1}, {-1, 1}, {-2, 1} },
			{ {0, 1}, {1, 1}, {2, 1} },
			{ {0, 1}, {-1, 0}, {-2, 0} },
			{ {0, 1}, {1, 0}, {2, 0} },
		},
		{
			{ {1, 0}, {1, 1}, {2, 1} },
			{ {1, 0}, {1, -1}, {2, -1} },
			{ {0, 1}, {-1, 1}, {-1, 2} },
			{ {0, 1}, {1, 1}, {1, 2} },
			
		},
		{
			{ {0, 1}, {0, 2}, {1, 1} },
			{ {1, 0}, {2, 0}, {1, 1} },
			{ {0, 1}, {0, 2}, {-1, 1} },
			{ {0, 1}, {-1, 1}, {1, 1} }
		}
	};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		paper = new int[N + 5][M + 5];
		int result = 0;
		for(int i = 2; i < N + 2; i++) {
			for(int j = 2; j < M + 2; j++) {
				paper[i][j] = input.nextInt();
			}
		}
		for(int i = 2; i < N + 2; i++) {
			for(int j = 2; j < M + 2; j++) {
				for(int k = 0; k < tetromino.length; k++) {
					for(int u = 0; u < tetromino[k].length; u++) {
						int temp = paper[i][j];
						for(int p = 0; p < tetromino[k][u].length; p++) {
							temp += paper[i + tetromino[k][u][p][0]][j + tetromino[k][u][p][1]];
						}
						if(temp > result) {
							result = temp;
						}
					}
				}
			}
		}
		System.out.println(result);
	}
}
