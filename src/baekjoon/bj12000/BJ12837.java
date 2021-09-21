package baekjoon.bj12000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가계부 (Hard)
public class BJ12837 {
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		segTree = new long[N * 4];
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(num == 1) {
				update(1, s, e, 1, N);	//생후 s일에 e를 추가.
			}else {
				bw.write(query(1, 1, N, s, e) + "\n");	//생후 s일부터 e일까지 변화한 양.
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
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
	
	static long update(int index, int valueIndex, int value, int left, int right) {
		if(left == right && left == valueIndex) {
			return segTree[index] += value;	//수를 교체하는 것이 아닌 추가하는 것에 주의.
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, valueIndex, value, left, mid) + update(index * 2 + 1, valueIndex, value, mid + 1, right);
	}
}
