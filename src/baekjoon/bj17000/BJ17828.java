package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//문자열 화폐
public class BJ17828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		if(N * 26 >= X && X >= N) {
			char[] arr = new char[N];
			Arrays.fill(arr, 'A');
			
			X -= N;
			int i = arr.length - 1;
			while(X > 25) {
				arr[i--] += 25;
				X -= 25;
			}
			arr[i] += X;
			
			for(char ch : arr) {
				bw.write(ch);
			}
		}else {
			bw.write("!\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
