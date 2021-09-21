package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나머지합
public class BJ10986 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] tmp = new int[M + 1];
		long result = 0;
		st = new StringTokenizer(br.readLine(), " ");
		arr[0] = Integer.parseInt(st.nextToken()) % M;
		for(int i = 1; i < N; i++) {
			arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;	//arr[i]는 A[0]~A[i]까지의 부분합에서 M으로 나눈 나머지.
		}
		for(int i = 0; i < N; i++) {	//M으로 나뉘는 구간합을 구하기 위해서는 arr[a~b] = arr[b] - arr[a - 1]인데
			if(arr[i] == 0) {			//모든 구간합을 구해야 한다. 이때 M으로 나뉘는 구간합은 i이하에서 arr[i]와 같은 수들의 갯수를 구하는것과 같다.
				result++;
			}
			result += tmp[arr[i]];
			tmp[arr[i]]++;
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
