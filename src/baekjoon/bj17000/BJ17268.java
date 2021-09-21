package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//미팅의 저주
public class BJ17268 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		long mod = 987654321;
		arr[0] = arr[2] = 1;
		
		//둘러앉은 사람들에게 번호를 줘본다. (1 ~ N번)
		//1번하고 다른 한명을 짝지어 선을 그려본다.
		//그 선을 기준으로 양 옆으로 사람들이 나뉘는데 나뉜 두 그룹의 사람 수가 홀수라면 선이 교차하여 매칭된다.
		//그러면 1번은 2, 4, 6 ~ N인 짝수번호와 매칭될 때 교차하지 않고 모든 사람을 매칭할 수 있다.
		//arr[i]를 i명이 교차하지 않고 가능한 매칭 수라고 하자.
		//1번과 짝수번호를 매칭하고, 나뉜 두 그룹의 사람 수에서 가능한 매칭 수를 곱하여 모두 더하면 arr[i]의 매칭 수를 알 수 있다.
		for(int i = 4; i <= N; i += 2) {
			for(int j = 2; j <= i; j += 2) {
//				arr[i] += (arr[j - 2] * arr[i - j]) % mod;	//모듈러 연산 실패.
				arr[i] = (arr[i] + (arr[j - 2] * arr[i - j]) % mod) % mod;
			}
		}
		
		bw.write(arr[N] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
