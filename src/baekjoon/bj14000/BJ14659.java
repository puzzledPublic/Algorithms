package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//한조서열정리하고옴ㅋㅋ
public class BJ14659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int height = arr[0], max = -1, count = 0;
		for(int i = 1; i < N; i++) {
			if(height > arr[i]) {	//연속하여 내림차순인 수의 개수를 구한다.
				count++;
			}else {
				height = arr[i];
				max = Math.max(max, count);
				count = 0;
			}
		}
		max = Math.max(max, count);
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
