package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//소수 찾기
public class BJ1978 {
	static boolean[] arr = new boolean[1001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr[1] = true;
		for(int i = 2; i * i <= 1000; i++) {
			for(int j = i * 2; j <= 1000; j += i) {
				arr[j] = true;
			}
		}
		int count = 0;
		while(st.hasMoreTokens()) {
			if(!arr[Integer.parseInt(st.nextToken())]) {
				count++;
			}
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
