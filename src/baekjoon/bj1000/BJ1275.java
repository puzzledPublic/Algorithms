package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//커피숍2
public class BJ1275 {
	static long[] segTree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		segTree = new long[N * 4];
		arr = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		init(1, 1, N);	//세그먼트 트리 초기화
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(x > y) {	//x > y가 입력 될 수도 있으므로 x < y가 되도록 고정.
				int tmp = x;
				x = y;
				y = tmp;
			}
			bw.write(query(1, 1, N, x, y) + "\n");	//x ~ y위치 사이에 있는 모든 수들의 합을 구한다.
			update(1, b, a, 1, N);	//a 위치에 있는 숫자를 b로 바꾼다.
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
		return segTree[index] = init(index * 2, left, mid) + init(index * 2 + 1, mid + 1, right);
	}
	
	static long query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return 0;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return query(index * 2, left, mid, qLeft, qRight) + query(index * 2 + 1, mid + 1, right, qLeft, qRight);
	}
	
	static long update(int index, int value, int valueIndex, int left, int right) {
		if(left == right && left == valueIndex) {
			return segTree[index] = value;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, value, valueIndex, left, mid) + update(index * 2 + 1, value, valueIndex, mid + 1, right);
	}
}
