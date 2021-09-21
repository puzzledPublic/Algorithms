package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//우울한 방학
public class BJ17392 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//행복값(H)일때 H + 1일 동안은 우울함을 느낄 수 없다.
		//그러므로 M일의 방학기간에다 (H + 1)길이의 구간들을 적절하게 놓는다고 생각할 수 있다.
		//N개의 구간으로 M길이에 놓는다면 N + 1개의 사이를 만들 수 있다. (N개의 구간의 길이의 합이 M을 넘는다면 사이가 없지만)
		//이때 N + 1개의 사이를 최대한 고르게 길이를 갖게한다면 우울값을 최소화 할 수 있다.
		
		int sum = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(st.nextToken()) + 1;
		}
		
		int[] days = new int[N + 1];	//N + 1개의 사이들의 길이
		int remain = M - sum;	//우울함을 가지는 일 수
		
		int k = 0;
		while(remain > 0) {	//우울함을 가지는 일 수를 N + 1개의 사이들에게 고르게 나눈다.
			days[k % (N + 1)]++;
			k++;
			remain--;
		}
		
		int result = 0;
		for(int i = 0; i < days.length; i++) {
			result += (days[i] * (days[i] + 1) * (2 * days[i] + 1) / 6);	//각 사이들의 일 수에 대해 우울값을 구한다. (1^2 + 2^2 ... k^2) = k * (k + 1) * (2k + 1) / 6
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
