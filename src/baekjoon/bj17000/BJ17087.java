package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//숨바꼭질6
public class BJ17087 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] positions = new int[N];	//각 동생들의 위치.
		int[] diffs = new int[N];	//수빈이와 각 동생들의 거리 차이.
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			positions[i] = Integer.parseInt(st.nextToken());
			diffs[i] = Math.abs(positions[i] - S);
		}
		
		//모든 동생들의 거리 차이들의 GCD가 모든 동생을 찾기위한 거리 D의 최대값이 된다.
		int gcd = diffs[0];
		for(int i = 1; i < N; i++) {
			gcd = getGCD(gcd, diffs[i]);
		}
		
		bw.write(gcd + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//최대공약수.
	static int getGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a % b);
	}
}
