package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//색깔 통일하기
public class BJ17307 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		//각 버튼에서 왼쪽, 오른쪽으로 나눠 왼쪽을 모두 같은 색으로 통일하는 횟수, 오른쪽을 모두 같은 색으로 통일하는 횟수 중
		//더 큰 것이 그 버튼을 눌렀을때 모든 색을 통일하는 횟수가 된다.
		
		int[] left = new int[N];	//i번 버튼에서 왼쪽 버튼으로 바꾸는데 걸리는 횟수
		int[] right = new int[N];	//i번 버튼에서 오른쪽 버튼으로 바꾸는데 걸리는 횟수
		
		long totalRight = 0, totalLeft = 0;
		for(int i = 0; i < N; i++) {
			if(i - 1 >= 0) {	//왼쪽 버튼으로 바꾸는 횟수 계산
				if(arr[i - 1] < arr[i]) {
					left[i] = C - arr[i] + arr[i - 1]; 
				}else {
					left[i] = arr[i - 1] - arr[i];
				}
			}
			if(i + 1 < N) {	//오른쪽 버튼으로 바꾸는 횟수 계산
				if(arr[i] <= arr[i + 1]) {
					right[i] = arr[i + 1] - arr[i];
				}else {
					right[i] = C - arr[i] + arr[i + 1];
				}
 			}
			totalRight += right[i];	//0번 버튼부터 탐색하므로 오른쪽의 모든 횟수들을 더해놓는다.
		}
		
		long button = 1, min = Long.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			totalLeft += left[i];	//i버튼에서 왼쪽을 모두 통일하는데 드는 횟수
			long count = Math.max(totalLeft, totalRight);
			if(min > count) {	//횟수가 가장 적게드는 버튼을 저장
				button = i + 1;
				min = count;
			}
			totalRight -= right[i];	//i버튼에서 오른쪽을 모두 통일하는데 드는 횟수
		}
		
		bw.write(button + "\n" + min + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
