package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//음주 코딩
public class BJ5676 {
	static int[] segTree;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			StringTokenizer st = new StringTokenizer(str, " ");
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			segTree = new int[N * 4];
			arr = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			init(1, 1, N);
			
			for(int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char operate = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(operate == 'C') {
					update(1, 1, N, a, b);
				} else {
					int mul = query(1, 1, N, a, b);
					bw.write((mul == 0 ? "0" : mul > 0 ? "+" : "-"));
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int init(int index, int left, int right) {
		if(left == right) {
			return segTree[index] = arr[left] == 0 ? 0 : (arr[left] > 0 ? 1 : -1);	//곱해서 양수, 0, 음수인지만 판별하면 되므로 1, 0, -1로 저장한다.
		}
		int mid = (left + right) / 2;
		return segTree[index] = init(index * 2, left, mid) * init(index * 2 + 1, mid + 1, right);
	}
	
	static int query(int index, int left, int right, int qLeft, int qRight) {
		if(right < qLeft || left > qRight) {
			return 1;
		}
		if(qLeft <= left && right <= qRight) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return query(index * 2, left, mid, qLeft, qRight) * query(index * 2 + 1, mid + 1, right, qLeft, qRight);
	}
	
	static int update(int index, int left, int right, int valueIndex, int value) {
		if(left == right && left == valueIndex) {
			return segTree[index] = value == 0 ? 0 : (value > 0 ? 1 : -1);
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, left, mid, valueIndex, value) * update(index * 2 + 1, mid + 1, right, valueIndex, value);
	}
}
