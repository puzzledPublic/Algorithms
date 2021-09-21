package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수열과 쿼리 17
public class BJ14438 {
	static int[] segTree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		segTree = new int[N * 4];
		arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int Q = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(Q == 1) {
				update(1, 1, N, A, B);
			} else {
				bw.write(query(1, 1, N, A, B) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int init(int index, int left, int right) {
		if(left == right) {
			return segTree[index] = arr[left];
		}
		int mid = (left + right) / 2;
		return segTree[index] = Math.min(init(index * 2, left, mid), init(index * 2 + 1, mid + 1, right));
	}
	
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return Integer.MAX_VALUE;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return Math.min(query(index * 2, left, mid, qLeft, qRight), query(index * 2 + 1, mid + 1, right, qLeft, qRight));
	}
	
	static int update(int index, int left, int right, int valueIndex, int value) {
		if(left == right && left == valueIndex) {
			return segTree[index] = value;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = Math.min(update(index * 2, left, mid, valueIndex, value), update(index * 2 + 1, mid + 1, right, valueIndex, value));
	}
}
