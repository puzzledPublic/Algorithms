package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//승현이의 질문
public class SWEA7810 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[1000001];
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			Arrays.fill(arr, 0);
			for(int i = 0; i < N; i++) {	//해당 숫자가 몇개 존재하는지 계산
				arr[Integer.parseInt(st.nextToken())]++;
			}
			for(int i = 999999; i >= 0; i--) {	//부분합
				arr[i] += arr[i + 1];
			}
			for(int i = 1000000; i >= 0; i--) {
				if(arr[i] >= i) {	//i보다 크거나 같은 숫자가 i개 이상이면 출력 후 종료
					bw.write("#" + t + " " + i + "\n");
					break;
				}
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
