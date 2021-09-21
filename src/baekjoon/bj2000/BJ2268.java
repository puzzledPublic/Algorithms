package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수들의 합
public class BJ2268 {
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		segTree = new long[N * 4];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int func = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(func == 0) {	//s ~ e 위치에 있는 수들의 합을 구한다.
				if(s > e) {	//s < e가 되도록 고정.
					int tmp = s;
					s = e;
					e = tmp;
				}
				bw.write(query(1, 1, N, s, e) + "\n");
			}else {	//s 위치에 있는 수를 e로 바꾼다.
				update(1, s, e, 1, N);
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
			return segTree[index] = value;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, valueIndex, value, left, mid) + update(index * 2 + 1, valueIndex, value, mid + 1, right);
	}
}
