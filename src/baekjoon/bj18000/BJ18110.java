package baekjoon.bj18000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//solved.ac
public class BJ18110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cut = (int)Math.round((double)(N * 15) / 100.0);	//앞 뒤로 삭제해야 할 15%를 구한다.
		
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i = cut; i < N - cut; i++) {	//앞 뒤에서 15%만큼 무시하고 나머지의 합을 구한다.
			sum += arr[i];
		}
		
		bw.write(Math.round((double)sum / (N - (cut * 2))) + "\n");	//평균을 출력한다.
		
		bw.flush();
		bw.close();
		br.close();
	}
}
