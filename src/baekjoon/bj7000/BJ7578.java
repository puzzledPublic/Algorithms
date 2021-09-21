package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//공장
public class BJ7578 {
	static long[] segTree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1_000_001];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[num] = i;
		}
		//1 2 3 4 5
		//2 1 5 4 3 다음과 같은 입력이라고 하면
		//아랫줄의 각 숫자를 추가할때 숫자보다 큰 숫자들의 개수가 꼬인선의 수가 된다.
		//2를 추가하면 아직 2보다 큰 수는 없으므로 0, 1추가하면 1보다 큰 수의 개수는 현재 1개이므로 1...
		//매번 숫자가 추가되고 그 숫자보다 큰 수의 개수를 얻어야 하므로 세그먼트 트리를 사용해서 빠르게 처리할 수 있다.
		
		segTree = new long[500_000 * 4];
		
		long count = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			count += arr[num] + 1 > N ? 0 : query(1, 1, 500_000, arr[num] + 1, N);
			update(1, arr[num], 1, 500_000);
		}
		
		bw.write(count + "\n");
		
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
	
	static long update(int index, int valueIndex, int left, int right) {
		if(left == right && valueIndex == left) {
			return segTree[index] += 1;
		}
		if(valueIndex < left || valueIndex > right) {
			return segTree[index];
		}
		int mid = (left + right) / 2;
		return segTree[index] = update(index * 2, valueIndex, left, mid) + update(index * 2 + 1, valueIndex, mid + 1, right);
	}
}
