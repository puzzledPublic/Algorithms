package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//부분수열의 합
public class BJ1208 {
	static int N, S;
	static long result;
	static int ALen, BLen;
	static int[] A, B;
	static Map<Integer, Long> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		if(N == 1) {	//원소가 1개라면 바로 비교
			if(S == Integer.parseInt(st.nextToken())) {
				result = 1;
			}else {
				result = 0;
			}
		}else {	//원소가 2개 이상인 경우. 배열을 2개로 나눈다. 
			//(원소가 최대 40개이므로 모든 조합의 수는 2^40개이다.)
			//그러므로 반으로 나눠 2^20개씩 두번 살펴본 후 두개의 각 원소 집합들의 합 중 S를 만족하는지를 검사한다.
			//주의할 것은 조합의 수가 2^40개이므로 결과는 Long타입이 필요.
			ALen = N % 2 == 0 ? N / 2 : N / 2 + 1;
			BLen = N / 2;
			A = new int[ALen];
			B = new int[BLen];
			
			for(int i = 0; i < ALen; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < BLen; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		solveA();
		solveB();
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solveA() {	//배열 A의 조합.
		for(int i = 1; i < (1 << ALen); i++) {
			int sum = 0;
			for(int j = 0; j < ALen; j++) {
				if((i & (1 << j)) > 0) {
					sum += A[j];
				}
			}
			if(sum == S) {	//배열 A의 조합에서 S를 만족하는 경우.
				result++;
			}
			if(map.containsKey(sum)) {	//배열 B의 조합과 비교를 위해 저장.
				map.replace(sum, map.get(sum) + 1L);
			}else {
				map.put(sum, 1L);
			}
		}
	}
	
	static void solveB() {	//배열 B의 조합.
		for(int i = 1; i < (1 << BLen); i++) {
			int sum = 0;
			for(int j = 0; j < BLen; j++) {
				if((i & (1 << j)) > 0) {
					sum += B[j];
				}
			}
			if(sum == S) {	//배열 B의 조합에서 S를 만족하는 경우.
				result++;
			}
			if(map.containsKey(S - sum)) {	//A + B = S를 구하는데 A는 이미 저장해 놨으므로 A = S - B를 만족하는 A가 존재하는지 검사
				result += map.get(S - sum);
			}
		}
	}
}
