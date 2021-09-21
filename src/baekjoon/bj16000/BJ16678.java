package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//모독
public class BJ16678 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		//최소 해커를 고용하기 위해선
		//명예가 1,2,3,4...가 되게끔 만들어야한다
		//이때 현재 국회의원의 명예가 다음에 만들 명예(k)보다 낮으면 k를 그대로 유지한다.
		long k = 1, count = 0;
		for(int i = 1; i <= N; i++) {
			if(arr[i] >= k) {
				count += arr[i] - k;
				k++;
			}
		}
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	
	}
}
