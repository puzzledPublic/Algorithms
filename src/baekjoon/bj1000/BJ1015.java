package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.StringTokenizer;

//수열 정렬
public class BJ1015 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		solve(n, br.readLine(), bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, String s, Writer w) throws IOException {
		StringTokenizer st = new StringTokenizer(s, " ");
		int[] arr = new int[n];	//A 배열
		int[] sorted = new int[n];	//정렬한 A배열 = 비내림차순인 B배열
		boolean[] chk = new boolean[n];	//동일한 숫자를 체크하기 위한 배열
		for(int i = 0; i < n ; i++) {
			sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
		//A배열에서 P배열을 적용해 비내림차순인 B배열이 되므로 A[i] -> B[j]로 이동하며 p[i] = j이다
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!chk[j] && arr[i] == sorted[j]) {	
					chk[j] = true;	//동일한 숫자를 체크하지 않도록 표시
					w.write(j + " ");
					break;
				}
			}
		}
	}
}
