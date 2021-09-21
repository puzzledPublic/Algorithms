package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//보물왕 태혁
public class SWEA7829 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		//약수를 만들때를 생각해보면
		//k가 있을때 1부터 시작하여 나눠보자.
		//맨 처음에 어떤 수 n으로 나뉘면 k / n도 약수이며 
		//약수들을 오름차순으로 뒀을 때 n은 맨 처음 k / n은 맨 마지막에 위치한다.
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			long num = (long)arr[0] * (long)arr[N - 1];
			bw.write("#" + t + " " + num + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
