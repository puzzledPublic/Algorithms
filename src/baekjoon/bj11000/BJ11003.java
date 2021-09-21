package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//최소값 찾기
public class BJ11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] result = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		Deque<Integer> deque = new ArrayDeque<>();
		
	    for(int n = 0 ; n < N ; ++n){
	    	arr[n] = Integer.parseInt(st.nextToken());
	        while(!deque.isEmpty() && arr[deque.peekLast()] > arr[n]) {
	        	deque.pollLast();
	        }
	        deque.offer(n);
	        if(deque.peekFirst() < n - L + 1) {
	        	deque.pollFirst();
	        }
	        result[n] = arr[deque.peekFirst()];
	    }
	    for(int n = 0 ; n < N ; ++n) {
	    	bw.write(result[n] + " ");
	    }
//시간초과
//		int s = 0;
//		for(int i = 0; i < N; i++) {
//			if(i - s == L) {
//				if(deque.peekFirst() == arr[s]) {
//					deque.pollFirst();
//				}
//				s++;
//			}
//			arr[i] = Integer.parseInt(st.nextToken());
//			while(!deque.isEmpty() && deque.peekLast() > arr[i]) {
//				deque.pollLast();
//			}
//			deque.offer(arr[i]);
//			result[i] = deque.peekFirst();
//		}
//		for(int i = 0; i < N; i++) {
//			bw.write(result[i] + " ");
//		}
		bw.flush();
		bw.close();
		br.close();
	}
}
//  세그먼트 트리로 시간초과
//public class BJ11003 {
//	static int[] segTree;
//	static int[] arr;
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
//		int size = 1;
//		while(2 * N > size) {
//			size *= 2;
//		}
//		arr = new int[N];
//		segTree = new int[size + 1];
//		st = new StringTokenizer(br.readLine(), " ");
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		init(1, 0, N - 1);
//		
//		for(int i = 0; i < N; i++) {
//			bw.write(query(i - L + 1, i, 1, 0, N - 1) + " ");
//		}
//		bw.flush();
//		bw.close();
//		br.close();
//	}
//	//세그먼트 트리 초기화
//	static int init(int node, int left, int right) {
//		if(left == right) {
//			return segTree[node] = arr[left];
//		}
//		int mid = (left + right) / 2;
//		return segTree[node] = Math.min(init(node * 2, left, mid), init(node * 2 + 1, mid + 1, right));
//	}
//	//세그먼트 트리 쿼리연산
//	static int query(int left, int right, int node, int nodeLeft, int nodeRight) {
//		if(right < nodeLeft || nodeRight < left) {
//			return 1000000001;
//		}
//		if(left <= nodeLeft && nodeRight <= right) {
//			return segTree[node];
//		}
//		int mid = (nodeLeft + nodeRight) / 2;
//		return Math.min(query(left, right, node * 2, nodeLeft, mid), query(left, right, node * 2 + 1, mid + 1, nodeRight));
//	}
//}
