package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//사탕상자
public class BJ2243 {
	static int[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		segTree = new int[1_000_000 * 4];
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A == 1) {	//B순위의 사탕을 상자에서 꺼낸다
				int taste = findRankTaste(B);
				bw.write(taste + "\n");
				update(1, 1, 1_000_000, taste, -1);
			} else {	//B맛의 사탕 C개를 상자에 넣는다.
				int C = Integer.parseInt(st.nextToken());
				update(1, 1, 1_000_000, B, C);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int findRankTaste(int rank) {
		int start = 1, end = 1_000_000;
		
		while(start < end) {
			int mid = (start + end) / 2;
			int amount = query(1, 1, 1_000_000, 1, mid);
			if(amount >= rank) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
	
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return 0;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return query(index * 2, left, mid, qLeft, qRight) + query(index * 2 + 1, mid + 1, right, qLeft, qRight);
	}
	
	static int update(int index, int left, int right, int valueIndex, int value) {
		if(left == right && left == valueIndex) {
			return segTree[index] += value;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, left, mid, valueIndex, value) + update(index * 2 + 1, mid + 1, right, valueIndex, value);
	}
}
