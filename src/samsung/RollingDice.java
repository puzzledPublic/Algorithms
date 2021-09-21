package samsung;

import java.util.Scanner;
//주사위 굴리기 (백준 14499)
public class RollingDice {
	static int N, M, K;
	static int startX, startY;
	static int[][] DiceMap;
	static int[] Operation;
	static int[][] Direction = {
		{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}
	};
	static int[] Dice = new int[6];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt();
		startX = input.nextInt();
		startY = input.nextInt();
		K = input.nextInt();
		DiceMap = new int[N][M];
		Operation = new int[K];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				DiceMap[i][j] = input.nextInt();
			}
		}
		for(int i = 0; i < K; i++) {
			Operation[i] = input.nextInt();
		}
		
		solve();
	}
	
	static void solve() {
		int x = startX, y = startY;
		for(int i = 0; i < Operation.length; i++) {
			x += Direction[Operation[i]][0];
			y += Direction[Operation[i]][1];
			
			if(x < 0 || x >= N || y < 0 || y >= M) {
				x -= Direction[Operation[i]][0];
				y -= Direction[Operation[i]][1];
				continue;
			}
			changeDice(Operation[i]);
			
			if(DiceMap[x][y] == 0) {
				DiceMap[x][y] = Dice[3]; 
			} else {
				Dice[3] = DiceMap[x][y];
				DiceMap[x][y] = 0;
			}
			System.out.println(Dice[1]);
		}
	}
	static void changeDice(int direction) {
		int temp;
		switch (direction) {
		case 1:	//동
			temp = Dice[1];
			Dice[1] = Dice[4];
			Dice[4] = Dice[3];
			Dice[3] = Dice[5];
			Dice[5] = temp;
			break;
		case 2:	//서
			temp = Dice[1];
			Dice[1] = Dice[5];
			Dice[5] = Dice[3];
			Dice[3] = Dice[4];
			Dice[4] = temp;
			break;
		case 3:	//북
			temp = Dice[1];
			Dice[1] = Dice[2];
			Dice[2] = Dice[3];
			Dice[3] = Dice[0];
			Dice[0] = temp;
			break;
		case 4:	//남
			temp = Dice[1];
			Dice[1] = Dice[0];
			Dice[0] = Dice[3];
			Dice[3] = Dice[2];
			Dice[2] = temp;
			break;
		default:
			break;
		}
	}
}
