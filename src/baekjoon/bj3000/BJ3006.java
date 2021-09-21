package baekjoon.bj3000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//터보소트
public class BJ3006 {
	static int[] segTree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		segTree = new int[N * 4];
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num] = i;	//현재 숫자의 위치를 저장해놓는다.
		}
		
		init(1, 1, N);
		
		int count = 1;	//N번을 쿼리
		int up = 1;	// 1, N, 2, N-1, 3, N-2 ...을 위해 up과 down으로 나눔.
		int down = N;
		while(count <= N) {
			if(count % 2 == 1) {	//홀수번째인 경우
				if(arr[up] - 1 >= 1) {	//현재 숫자의 위치 이전의 수들의 개수를 알아내자.
					bw.write(query(1, 1, N, 1, arr[up] - 1) + "\n");
				}else {
					bw.write("0\n");
				}
				update(1, arr[up], 0, 1, N);	//해당 숫자를 제거하여 개수를 줄인다.
				up++;
			}else {	//짝수번째인 경우
				if(arr[down] + 1 <= N) {	//현재 숫자의 위치 이후의 수들의 개수를 알아내자.
					bw.write(query(1, 1, N, arr[down] + 1, N) + "\n");
				}else {
					bw.write("0\n");
				}
				update(1, arr[down], 0, 1, N);
				down--;
			}
			count++;
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int init(int index, int left, int right) {
		if(left == right) {
			return segTree[index] = 1;
		}
		int mid = (left + right) / 2;
		return segTree[index] = init(index * 2, left, mid) + init(index * 2 + 1, mid + 1, right);
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
	
	static int update(int index, int valueIndex, int value, int left, int right) {
		if(left == right && left == valueIndex) {
			return segTree[index] = 0;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, valueIndex, value, left, mid) + update(index * 2 + 1, valueIndex, value, mid + 1, right);
	}
}
