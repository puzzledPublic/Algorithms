package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//서버실
public class BJ17245 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		long amountOfComputer = 0;
		int[] arr = new int[N * N];
		int k = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[k] = Integer.parseInt(st.nextToken());
				amountOfComputer += arr[k];
				k++;
			}
		}
		
		long halfOfCoumputer = amountOfComputer % 2 == 0 ? amountOfComputer / 2 : amountOfComputer / 2 + 1;	//컴퓨터의 절반 개수를 구한다. (홀수인 경우 +1)
		long start = 0, end = amountOfComputer + 1;
		while(start < end) {	//mid 분에 컴퓨터 개수의 절반 이상이 켜지는가?
			long mid = (start + end) / 2;
			long amount = 0;
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] <= mid) {
					amount += arr[i];
				}else {
					amount += mid;
				}
			}
			if(halfOfCoumputer <= amount) {
				end = mid;
			}else {
				start = mid + 1;
			}
		}
		
		bw.write(start + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
