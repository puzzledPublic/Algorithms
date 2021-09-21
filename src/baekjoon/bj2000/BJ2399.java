package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//거리의 합
public class BJ2399 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long[] arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);	//좌표 순으로 정렬
		
		//x좌표 순으로 세 정점을 A, B, C라고 할때 모든 정점간 거리의 합은 2 * (AB + AC + BC)가 된다.
		//AC(A와 C간의 거리) 는 AB + BC와 같으므로 2 * 2 * AC가 된다.
		//이를 N개의 정점으로 일반화하면 
		//AN = AB + BN = AC + CN ... 
		//B(N-1) = BC + C(N-1) = BD + D(N-1)...
		//C(N-2) = CD + D(N-2) = CE + E(N-2)...같이 된다.
		//결국 2 * (AN * (A,N의 인덱스 거리) + B(N-1) * (B,(N-1)의 인덱스 거리) ...)가 된다.
		
		int start = 0, end = N - 1;
		long result = 0;
		
		while(start < end) {
			result += Math.abs(arr[start] - arr[end]) * (end - start);
			start++;
			end--;
		}
		
		bw.write((result * 2) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
