package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수열과 쿼리 16
public class BJ14428 {
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
		
		arr[0] = Integer.MAX_VALUE;
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
			return segTree[index] = left;	//**세그먼트 트리에 인덱스를 저장한다.
		}
		int mid = (left + right) / 2;
		int l = init(index * 2, left, mid);
		int r = init(index * 2 + 1, mid + 1, right);
		if(arr[l] <= arr[r]) {	//인덱스위치의 숫자를 비교하여 더 작은 숫자의 인덱스를 저장.
			return segTree[index] = l;
		}
		return segTree[index] = r;
	}
	
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {	//원하는 범위를 벗어나면 index = 0 => 숫자 = Integer.MAX_VALUE을 갖도록 한다.
			return 0;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		int l = query(index * 2, left, mid, qLeft, qRight);
		int r = query(index * 2 + 1, mid + 1, right, qLeft, qRight);
		if(arr[l] <= arr[r]) {
			return l;
		}
		return r;
	}
	
	static int update(int index, int left, int right, int valueIndex, int value) {
		if(left == right && left == valueIndex) {
			arr[valueIndex] = value;	//숫자를 바꿔야하므로 arr배열의 숫자를 바꾼다.
			return segTree[index] = valueIndex;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		int l = update(index * 2, left, mid, valueIndex, value);
		int r = update(index * 2 + 1, mid + 1, right, valueIndex, value);
		if(arr[l] <= arr[r]) {
			return segTree[index] = l;
		}
		return segTree[index] = r;
	}
}
