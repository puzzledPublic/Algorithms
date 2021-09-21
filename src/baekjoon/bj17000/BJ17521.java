package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//Byte Coin
public class BJ17521 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		long W = Long.parseLong(st.nextToken());	//15일동안 코인 가격이 1, 50, 1, 50... 반복되고 보유한 현금(W)가 10만이라면 int범위로 계산할 수 없다. (50^7 * 10^5)
		
		int[] price = new int[N + 1];
		for(int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		long coin = 0;	//보유한 코인 개수
		for(int i = 0; i < N; i++) {
			if(price[i] < price[i + 1]) {	//다음날 오르면 오늘 모두 산다.
				coin += W / price[i];
				W %= price[i];	//최대한 사고 남은 돈
			}else {	//다음날 떨어지면 모두 판다
				W += price[i] * coin;
				coin = 0;
			}
		}
		
		bw.write(W + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
