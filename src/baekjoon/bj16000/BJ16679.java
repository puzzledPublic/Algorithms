package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//Back to the Bones
public class BJ16679 {
	static long[][] DP = new long[21][121];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		//DP[i][j] = i개의 주사위를 던졌을때 주사위 눈들의 합이 j인 경우의 수
		for(int j = 1; j <= 6; j++) {
			DP[1][j] = 1;
		}
		for(int j = 2; j < DP.length; j++) {
			for(int u = 1; u < DP[0].length; u++) {
				long minus = u - 7 >= 0 ? DP[j - 1][u - 7] : 0; 
				DP[j][u] = DP[j - 1][u - 1] + DP[j][u - 1] - minus;
			}
		}
		
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			int[][] arr = new int[N][2];
			for(int j = 0; j < N; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = j;	//주사위 눈수로 정렬할것이므로 현재 위치를 저장
			}
			solve(arr, K, bw);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int[][] arr, int k, Writer w) throws IOException {
		long p = 1;
		
		int[] pSum = new int[arr.length + 1];
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);	//주사위 눈 수 오름차순 정렬(제일 낮은 수부터 선택하는게 확률을 더 높일 수 있다.)

		for(int i = 1; i < pSum.length; i++) {		//1 ~ i번째 주사위까지 눈 수의 합
			pSum[i] = pSum[i - 1] + arr[i - 1][0];
		}
		
		int sum = pSum[pSum.length - 1];	//모든 주사위 눈 수의 합
		double maxP = 0;
		long u = 0;
		int maxIndex = 0;
		for(int i = 0; i < pSum.length; i++) {	//0 ~ i번째 주사위까지 다시 던진다고 할때
			int gap = k - (sum - pSum[i]);		//0 ~ i번째를 다시 던졌을때 주사위들의 눈 수 합이 gap이상만큼 나와야 k이상이 된다.
			if(gap <= 6 * i) {	//gap이 i개 주사위를 던져서 나올 수 있는 수라면
				//i개의 주사위를 던져 gap 이상의 숫자를 만들 수 있는 확률을 구하자.
				if(gap > 0) {
					long up = 0;
					double down = 1;
					for(int j = gap; j < DP[0].length; j++) {	//미리 구해놓은 DP배열서 i개 주사위로 gap 이상을 만드는 경우의 수를 구한다.
						up += DP[i][j];
					}
					for(int j = 0; j < i; j++) {
						down *= 6;
					}
					if(maxP < up / down) {	//최고 확률 저장
						maxIndex = i;
						maxP = up / down;
						u = up;
					}
				}else {
					u = 1;
					break;
				}
			}
		}
		for(int i = 0; i < arr.length - maxIndex; i++) {	//6^n * p = 6^n * (경우의 수 / 6^던진 주사위 수(maxIndex))이므로 6^(n - maxIndex) * 경우의 수를 구하면 된다.
			p *= 6;
		}
		p *= u;
		w.write(p + "\n");
		boolean[] chk = new boolean[arr.length];
		for(int i = 0; i < maxIndex; i++) {
			chk[arr[i][1]] = true;
		}
		for(int i = 0; i < chk.length; i++) {
			if(chk[i]) {
				w.write("1 ");
			}else {
				w.write("0 ");
			}
		}
		w.write("\n");
	}
}
