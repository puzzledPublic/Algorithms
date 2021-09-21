package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//최솟값과 최댓값
public class BJ2357 {
	static class MaxMin {
		int max, min;	//최대, 최소
		MaxMin(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}
	//세그먼트 트리
	static class SegmentTree {
		private int size;
		private MaxMin[] segTree;
		public SegmentTree(int[] arr, int size) {
			this.size = size;
			//size == 2의 제곱이면(size & -size == size) 세그먼트 트리는 Full Binary Tree가 되고 세그먼트 트리 크기는 2 * size - 1, 아니라면 2^(log(size) + 1) - 1이 된다.
			//여기서는 대충 4배로 함
			this.segTree = new MaxMin[4 * size];	
			this.segTreeInit(arr, 0, this.size - 1, 1);
		}
		
		public MaxMin query(int left, int right) {
			return this.segQuery(left, right, 0, size - 1, 1);
		}
		
		//세그먼트 트리 초기화.
		private MaxMin segTreeInit(int[] arr, int left, int right, int node) {
			if(left == right) {	//리프노드인 경우 자기 자신이므로 최소, 최대는 동일
				return this.segTree[node] = new MaxMin(arr[left], arr[left]);
			}
			
			int mid = (left + right) / 2;
			MaxMin mami = segTreeInit(arr, left, mid, node * 2);
			MaxMin mami2 = segTreeInit(arr, mid + 1, right, node * 2 + 1);
			
			return this.segTree[node] = new MaxMin(Math.max(mami.max, mami2.max), Math.min(mami.min, mami2.min));
		}
		//쿼리
		private MaxMin segQuery(int left, int right, int nodeLeft, int nodeRight, int node) {
			if(left > nodeRight || right < nodeLeft) {	//구하고자 하는 left, right 범위가 현재 탐색 범위 (nodeLeft, nodeRight)를 아예 벗어나면 더이상 찾을 필요 없음
				return new MaxMin(Integer.MIN_VALUE, Integer.MAX_VALUE);
			}
			if(left <= nodeLeft && nodeRight <= right) {	//구하고자 하는 left, right 범위에 현재 탐색 범위가 포함되면 해당 구간의 최대,최소 객체 반환
				return this.segTree[node];
			}
			int mid = (nodeLeft + nodeRight) / 2;
			
			//양 구간의 최대, 최소 객체를 비교하여 그 중 최대, 최소 객체를 반환
			MaxMin mami = segQuery(left, right, nodeLeft, mid, node * 2);
			MaxMin mami2 = segQuery(left, right, mid + 1, nodeRight, node * 2 + 1);
			return new MaxMin(Math.max(mami.max, mami2.max), Math.min(mami.min, mami2.min));
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		SegmentTree segTree = new SegmentTree(arr, arr.length);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			MaxMin mami = segTree.query(a - 1, b - 1);
			bw.write(mami.min + " " + mami.max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
