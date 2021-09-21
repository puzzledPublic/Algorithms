package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//폭죽쇼
public class BJ1773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[] arr = new char[C + 1];
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			for(int j = n; j <= C; j += n) {	//각 입력 숫자의 배수를 체크.
				arr[j] = 'x';
			}
		}
		for(int i = 1; i <= C; i++) {	//체크된 갯수를 센다.
			if(arr[i] == 'x') {
				count++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
