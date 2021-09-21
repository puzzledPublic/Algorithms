package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//구간 곱 구하기 (세그먼트 트리)
public class BJ11505 {
	static long[] segTree;
	static long[] arr;
	static long MOD = 1_000_000_007L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		segTree = new long[4 * N];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1, 1, N);
		
		for(int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == 1) {
				update(1, b, c, 1, N);
			}else {
				bw.write(query(1, b, c, 1, N) + "\n");
			}
			System.out.println(Arrays.toString(segTree));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static long init(int index, int left, int right) {
		if(left == right) {
			return segTree[index] = arr[left];
		}
		
		int mid = (left + right) / 2;
		return segTree[index] = (init(2 * index, left, mid) * init(2 * index + 1, mid + 1, right)) % MOD;
	}
	
	static long query(int index, int qLeft, int qRight, int left, int right) {
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		
		if(right < qLeft || left > qRight) {	//곱해야 하므로 범위에 포함되지 않으면 1을 리턴
			return 1;
		}
		
		int mid = (left + right) / 2;
		return (query(2 * index, qLeft, qRight, left, mid) * query(2 * index + 1, qLeft, qRight, mid + 1, right)) % MOD;
	}
	
	static long update(int index, int numIndex, long num, int left, int right) {
		if(left == right && numIndex == left) {
			return segTree[index] = num;
		}
		
		if(numIndex < left || right < numIndex) {
			return segTree[index];
		}
		
		int mid = (left + right) / 2;
		return segTree[index] = (update(2 * index, numIndex, num, left, mid) * update(2 * index + 1, numIndex, num, mid + 1, right)) % MOD;
	}
}
