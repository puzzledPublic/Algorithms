package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최소값 (세그먼트 트리, RMQ)
public class BJ10868 {
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		segTree = new int[N * 4];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		init(arr, 1, 0, N - 1);
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write(query(1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, 0, N - 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int init(int[] arr, int index, int left, int right) {
		if(left == right) {
			return segTree[index] = arr[left];
		}
		int mid = (left + right) / 2;
		
		return segTree[index] = Math.min(init(arr, 2 * index, left, mid), init(arr, 2 * index + 1, mid + 1, right));
	}
	
	static int query(int index, int left, int right, int nodeLeft, int nodeRight) {
		if(left <= nodeLeft && nodeRight <= right) {
			return segTree[index];
		}
		if(left > nodeRight || right < nodeLeft) {
			return Integer.MAX_VALUE;
		}
		int mid = (nodeLeft + nodeRight) / 2;
		return Math.min(query(2 * index, left, right, nodeLeft, mid), query(2 * index + 1, left, right, mid + 1, nodeRight));
	}
}
