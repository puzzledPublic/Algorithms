package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//두 배열의 합
public class BJ2143 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken()) + A[i - 1];	//A[i] = i까지의 모든 합.
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= M; i++) {
			B[i] = Integer.parseInt(st.nextToken()) + B[i - 1];	//B[i] = i까지의 모든 합.
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 1; i <= N; i++) {	//A의  모든 부분합을 구한다.
			for(int j = i; j <= N; j++) {
				int sum = A[j] - A[i - 1]; //i~j까지의 부분 합.
				if(map.containsKey(sum)) {	//map에 저장.
					map.replace(sum, map.get(sum) + 1);
				}else {
					map.put(sum, 1);
				}
			}
		}
		
		long count = 0;	//각 A와 B의 부분 합 개수가 최대 N*(N+1)/2가 된다.(1<= N, M <=1000) 경우의 수가 최대 (N*(N+1)/2)*(M*(M+1)/2)이므로 int범위를 넘어설 수 있다. 
		for(int i = 1; i <= M; i++) {	//B의 모든 부분합을 구한다.
			for(int j = i; j <= M; j++) {
				int sum = B[j] - B[i - 1];	//i~j까지으 부분 합.
				Integer amount = map.get(T - sum);	//A의 부분합 + B의 부분합 = T를 만족하는 경우의 수를 구해야한다. A는 저장해놨으므로 T - B = A가 있는지 보면 된다.
				if(amount != null) {	//존재하면 경우의 수 증가.
					count += amount;
				}
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
