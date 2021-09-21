package baekjoon.bj19000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//비드맨
public class BJ19590 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long sum = 0;
		for(int i = 0; i < N - 1; i++) {
			sum += arr[i];
		}
		
		//최대 구슬갯수가 나머지 구슬들의 합보다 크면 나머지 구슬들을 다 깰 수 있다.
		if(sum < arr[N - 1]) {
			bw.write((arr[N - 1] - sum) + "\n");
		}else {	//그게 아니라면
			if((sum + arr[N - 1]) % 2 == 0) {	//모든 구슬의 개수 합이 짝수면 다 깰 수 있다.
				bw.write("0\n");
			}else {	//홀수면 1개가 남는다.
				bw.write("1\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
