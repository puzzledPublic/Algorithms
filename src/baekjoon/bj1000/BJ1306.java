package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//달려라 홍준
public class BJ1306 {
	static int[] segTree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		segTree = new int[N * 4];
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);
		
		for(int i = M; i <= N - M + 1; i++) {	//i - (M - 1) ~ i + (M - 1) 범위에서 최대값을 구하자.
			bw.write(query(1, 1, N, i - (M - 1), i + (M - 1)) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	//세그먼트 트리 초기화
	static int init(int index, int left, int right) {
		if(left == right) {
			return segTree[index] = arr[left];
		}
		int mid = (left + right) / 2;
		return segTree[index] = Math.max(init(index * 2, left, mid), init(index * 2 + 1, mid + 1, right));
	}
	
	//세그먼트 트리에서 qLeft ~ qRight범위 중 최대값 쿼리.
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return -1;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return Math.max(query(index * 2, left, mid, qLeft, qRight), query(index * 2 + 1, mid + 1, right, qLeft, qRight));
	}
}
