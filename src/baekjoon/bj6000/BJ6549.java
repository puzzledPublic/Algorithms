package baekjoon.bj6000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//히스토그램에서 가장 큰 직사각형
public class BJ6549 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N;
		while((N = Integer.parseInt(st.nextToken())) != 0) {
			arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			bw.write(solve(0, N - 1) + "\n");
			st = new StringTokenizer(br.readLine(), " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	//분할정복
	static long solve(int left, int right) {
		if(left == right) {
			return arr[left];
		}
		int mid = (left + right) / 2;
		long ret = Math.max(solve(left, mid), solve(mid + 1, right));	//구간을 반으로 나눠 분할정복 (왼쪽, 오른쪽 구간에 최대 직사각형)
		
		int lo = mid, hi = mid + 1;
		long height = Math.min(arr[lo], arr[hi]);
		ret = Math.max(ret,  height * 2);
		
		while(left < lo || hi < right) {	//왼쪽, 오른쪽 구간을 서로 겹쳐서 직사각형을 이루는 경우
			if(hi < right && (lo == left || arr[lo - 1] < arr[hi + 1])) {
				hi++;
				height = Math.min(height, arr[hi]);
			}else {
				lo--;
				height = Math.min(height, arr[lo]);
			}
			ret = Math.max(ret, height * (hi - lo + 1));
		}
		return ret;
	}
}
