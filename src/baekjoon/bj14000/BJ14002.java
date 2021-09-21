package baekjoon.bj14000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//가장 긴 증가하는 부분 수열 4
public class BJ14002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];	//dp[i] = i번째까지 가장 긴 증가 부분 수열
		int[] backTrack = new int[N];	//부분 수열을 추적하기 위한 배열
		
		Arrays.fill(dp, 1);
		
		for(int i = 0; i < N; i++) {	//자기자신을 가리키도록 한다.
			backTrack[i] = i;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(arr[j] < arr[i]) {
					if(dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						backTrack[i] = j;	//수열이 arr[j] -> arr[i] 순으로 된다.
					}
				}
			}
		}
		
		int max = -1, maxIndex = -1;
		for(int i = 0; i < N; i++) {	//가장 긴 부분 수열 길이와 수열의 마지막 숫자 인덱스를 구한다
			if(max < dp[i]) {
				max = dp[i];
				maxIndex = i;
			}
		}
		
		List<Integer> list = new ArrayList<>();
		int next = maxIndex;
		while(backTrack[next] != next) {	//그 인덱스를 가지고 백트래킹하며 수열을 만든다.
			list.add(arr[next]);
			next = backTrack[next];
		}
		list.add(arr[next]);
		
		bw.write(max + "\n");	//가장 긴 부분 수열 길이 출력
		for(int i = list.size() - 1; i >= 0; i--) {	//가장 긴 부분 수열 출력
			bw.write(list.get(i) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
