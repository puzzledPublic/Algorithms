package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//자동차가 차주 김표준의 편을 들면?
public class BJ17357 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long[] num = new long[N + 1];	//숫자의 부분합
		long[] powNum = new long[N + 1];	//숫자 제곱의 부분합
		for(int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(st.nextToken());
			powNum[i] = num[i] * num[i];
			num[i] = num[i] + num[i - 1];
			powNum[i] = powNum[i] + powNum[i - 1];
		}
		
		//분산 = E(x^2)(숫자 제곱의 평균) - {E(x)}^2(숫자 평균의 제곱)으로 구할 수 있다.
		for(int i = 1; i <= N; i++) {
			long max = -1;
			int maxIndex = 0;
			for(int j = i; j <= N; j++) {
				long mean = (num[j] - num[j - i]);	//해당 구간의 숫자 평균
				//분산 = E(x^2) - {E(x)}^2 (나눗셈을 하면 오차가 생길 수 있으므로 곱셈으로 식을 바꿨다)
				//((a^2 + b^2 + c^2 +...) / n) - ((a + b + c...) / n)^2에서 첫항의 분모 문자에 n을 곱해주면
				//(((a^2 + b^2 + c^2 +...) * n) - (a + b + c...)^2) / n^2 이고 분모 n^2은 모든 구간에서 같으므로 없어도 비교하는데 무리없다.
				long tmp = ((powNum[j] - powNum[j - i]) * i) - (mean * mean);
				
				if(max < tmp) {	//i범위 구간에서 분산이 가장 큰 구간의 시작 인덱스를 구한다.
					max = tmp;
					maxIndex = j - i + 1;
				}
			}
			bw.write(maxIndex + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
