package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//수2
public class BJ1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[L];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		//문제에서 N을 포함하는 Unlucky 구간이란 뜻은 [A, B]에서 A <= N <= B란 뜻. A 또는 B가 N이라는 뜻이 아니다.
		for(int i = 0; i < L; i++) {
			if(arr[i] == N) {	//해당 수를 포함하면 무조건 0개
				bw.write("0\n");
				break;
			}else if(arr[i] > N) {
				int s = i - 1 >= 0 ? arr[i - 1] : 0;	//N보다 작은 이전 값
				int e = arr[i];	//N보다 큰 값
				bw.write(((e - N) * (N - s) - 1) + "\n");	//[A, B]에서 A가 될 수 있는 숫자는 A <= N이고 B가 될 수 있는 숫자는 N <= B이다.
				//A에서 숫자하나를 뽑고 B에서 숫자 하나를 뽑는 경우의 수(aC1 * bC1, a, b는 A, B가 될 수 있는 숫자 개수)를 구하고 A = B = N인 경우 1가지를 빼면 (A < B이므로) 원하는 답이다.
				break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
