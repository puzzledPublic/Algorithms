package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//완전수
public class BJ14563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < T; i++) {
			int sum = -arr[i];	//N 제외
			for(int j = 1; j * j <= arr[i]; j++) {	//약수들 구하기
				if(arr[i] % j == 0) {	
					if(j * j == arr[i]) {	//중복되는 약수면 한번만 더하기
						sum += j;
					}else {	//약수를 합한다.
						sum += (j + (arr[i] / j));
					}
				}
			}
			if(sum == arr[i]) {
				bw.write("Perfect\n");
			}else if(sum < arr[i]) {
				bw.write("Deficient\n");
			}else {
				bw.write("Abundant\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
