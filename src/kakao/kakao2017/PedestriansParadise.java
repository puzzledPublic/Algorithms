package kakao.kakao2017;
//2017 카카오코드 예선 
//보행자 천국
public class PedestriansParadise {
	static int MOD = 20170805;
	public static void main(String[] args) {
		int[] m = {3, 3};
		int[] n = {3, 6};
		int cityMap[][][] = {
			{
				{0,0,0},
				{0,0,0},
				{0,0,0},
			},
			{
				{0,2,0,0,0,2},
				{0,0,2,0,1,0},
				{1,0,0,2,2,0},
			}
		};
		
		for(int i = 0; i < m.length; i++) {
			System.out.println(solution(m[i], n[i], cityMap[i]));
		}
	}
	
	static int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		int[][] DP = new int[m][n];
		for(int i = 0; i < m; i++) {
			if(cityMap[i][0] == 1) {
				break;
			}
			DP[i][0] = 1;
		}
		for(int i = 0; i < n; i++) {
			if(cityMap[0][i] == 1) {
				break;
			}
			DP[0][i] = 1;
		}
		//DP[i][j] = (i, j) 위치까지 도달하는 경우의 수
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(cityMap[i][j] == 1) {	//지금 위치가 1이라면 통과가 안되므로 오는 경우의 수는 0
					continue;
				}
				
				if(cityMap[i - 1][j] != 1) {	//위에서 오는 경우
					if(cityMap[i - 1][j] == 0) {	//자유 통행인 경우 dp[i][j] += dp[i - 1][j]
						DP[i][j] = (DP[i][j] + DP[i - 1][j]) % MOD;
					}else if(cityMap[i - 1][j] == 2) {	//직진 통행인 경우 위쪽으로 탐색하며 2가 아닌 곳에서의 경우의 수를 찾는다.
						int k = i - 2;
						while(k >= 0 && cityMap[k][j] == 2) {
							k--;
						}
						if(k >= 0) {
							DP[i][j] = (DP[i][j] + DP[k][j]) % MOD;
						}
					}
				}
				
				if(cityMap[i][j - 1] != 1) {	//왼쪽에서 오는 경우
					if(cityMap[i][j - 1] == 0) {	//자유 통행인 경우 dp[i][j] += dp[i][j - 1]
						DP[i][j] = (DP[i][j] + DP[i][j - 1]) % MOD;
					}else if(cityMap[i][j - 1] == 2) {	//직진 통앤인 경우 왼쪽으로 탐색하며 2가 아닌 곳에서의 경우의 수를 찾는다.
						int k = j - 2;
						while(k >= 0 && cityMap[i][k] == 2) {
							k--;
						}
						if(k >= 0) {
							DP[i][j] = (DP[i][j] + DP[i][k]) % MOD;
						}
					}
				}
			}
		}
		return answer = DP[m - 1][n - 1];
	}
}
