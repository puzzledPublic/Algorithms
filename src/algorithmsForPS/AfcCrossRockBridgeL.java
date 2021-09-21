package algorithmsForPS;

import java.io.File;
import java.util.Scanner;
//돌다리 건너기 L
public class AfcCrossRockBridgeL {
	static char[] spell;
	static char[][] bridge;
	static int[][][] dp;
	static int[][] dp2;
	public static void main(String[] args) {
		String path = System.getProperty("user.dir") + "\\src\\test\\AfcCrossRockBridgeL";
		
		try(Scanner input = new Scanner(new File(path))) {
			while(input.hasNext()) {
				bridge = new char[2][];
				dp = new int[2][30][120];
				spell = input.nextLine().toCharArray();
				bridge[0] = input.nextLine().toCharArray();
				bridge[1] = input.nextLine().toCharArray();
//				System.out.println(solve(0, 0, 0) + solve(1, 0, 0));
				System.out.println(solve2());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int solve(int bridgeNum, int spellPosition, int bridgePosition) {	//bridgeNum 다리, 두루마리위치는 spellPosition이고 다리 위 위치는 bridgePosition일때 건널 수 있는 경우의 수
		if(dp[bridgeNum][spellPosition][bridgePosition] == 0) {
			if(spellPosition == spell.length) {	//두루마리를 다 썼다면 경우의 수 추가
				dp[bridgeNum][spellPosition][bridgePosition] = 1;
			}else {
				for(int i = bridgePosition; i < bridge[0].length; i++) {	//현재 위치 다음에 반대편 다리에서 다음 두루마리 문자가 일치하면 그대로 점프
					if(bridge[1 - bridgeNum][i] == spell[spellPosition]) {
						dp[bridgeNum][spellPosition][bridgePosition] += solve(1 - bridgeNum, spellPosition + 1, i + 1);
					}
				}
			}
		}
		return dp[bridgeNum][spellPosition][bridgePosition];
	}
	
	//아직 이해 부족
	static int solve2() {
		dp2 = new int[2][30];	//i다리에서 j번 문자로 끝나는 모든 경우의 수
		dp2[0][0] = dp2[1][0] = 1;
		for(int i = 0; i < bridge[0].length; i++) {
			for(int j = spell.length - 1; j >= 0; j--) {
				if(bridge[0][i] == spell[j]) {
					dp2[1][j + 1] += dp2[0][j];	//dp2[i][j] += dp2[1 - i][j - 1] (i = 0 or 1)
				}
				if(bridge[1][i] == spell[j]) {
					dp2[0][j + 1] += dp2[1][j];
				}
			}
		}
		return dp2[0][spell.length] + dp2[1][spell.length];
	}
}
