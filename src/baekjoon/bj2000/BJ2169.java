package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//로봇 조종하기
public class BJ2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];	//지역들의 가치
		int[][][] dp = new int[N][M][3];	//(i,j)지역을 위쪽(0),왼쪽(1),오른쪽(2)으로 부터 왔을때의 최고가 되는 가치
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for(int k = 0; k < 3; k++) {
					dp[i][j][k] = Integer.MIN_VALUE;	// 입력되는 가치는 절대값 100이므로 더 낮은 음수로 디폴트 값을 넣는다.
				}
			}
		}
		
		dp[0][0][0] = map[0][0];	//(위로 다시 올라갈 순 없고 지역을 한번만 방문해야하니까) 첫째줄은 오른쪽으로만 이동가능하므로 dp[0][i][0]의 값을 채워 넣는다.
		for(int i = 1; i < M; i++) {
			dp[0][i][0] = dp[0][i - 1][0] + map[0][i];
		}
		
		for(int i = 1; i < N; i++) {	//첫째줄부터 마지막줄까지
			for(int j = 0; j < M; j++) {	//위쪽으로부터 (i,j)를 방문하는 경우 dp[i][j][0]은 dp[i-1][j][0~2] 중 가장 큰 가치 + (i,j)의 방문 가치가 된다.
				dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j][1], dp[i - 1][j][2])) + map[i][j];
			}
			for(int j = 1; j < M; j++) {	//왼쪽으로부터 (i,j)를 방문하는 경우 dp[i][j][1]은 dp[i][j-1][0,1] 중 가장 큰 가치 + (i,j)의 방문 가치가 된다. ((i,0)위치는 왼쪽에서 방문이 불가능함에 주의)
				dp[i][j][1] = Math.max(dp[i][j - 1][0], dp[i][j - 1][1]) + map[i][j];
			}
			for(int j = M - 2; j > -1; j--) {	//오른쪽으로부터 (i,j)를 방문하는 경우 dp[i][j][2]는 dp[i][j+1][0,2] 중 가장 큰 가치 + (i,j)의 방문 가치가 된다. ((i,M-1)위치는 오른쪽에서 방문이 불가능함에 주의, 또한 오른쪽->왼쪽으로 dp배열을 채워야한다. )
				dp[i][j][2] = Math.max(dp[i][j + 1][0], dp[i][j + 1][2]) + map[i][j];
			}
		}
		
		bw.write(Math.max(dp[N - 1][M - 1][0], dp[N - 1][M - 1][1]) + "\n");	//(N,M)위치까지오는데 가장 큰 가치는 위, 왼쪽에서 오는 경우가 있으므로 그 둘 중 가장 큰 가치가 된다.
		
		bw.flush();
		bw.close();
		br.close();
	}
}
