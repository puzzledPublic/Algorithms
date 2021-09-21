package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//다음 순열
public class BJ10972 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(N, arr, bw);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int N, int[] arr, Writer w) throws IOException {
		int k = N - 1, t = N - 1;
		while(k > 0 && arr[k] < arr[k - 1]) {	//순열의 뒤부터 오름차순인지 탐색
			k--;
		}
		k--;
		
		if(k == -1) {	//전부 다 오름차순이라면 마지막 순열이다.
			w.write("-1\n");
			return;
		}
		for(int i = 0; i < k; i++) {
			w.write(arr[i] + " ");
		}
		while(arr[t] < arr[k]){	//현재 찾은 오름차순이 아닌곳에 있는 숫자보다 큰 숫자를 찾는다(현재 찾은 인덱스 보다 뒤쪽에서).
			t--;
		}
		int tmp = arr[k];	//그 두개 수를 교환.
		arr[k] = arr[t];
		arr[t] = tmp;
		k++;
		t = N - 1;	
		
		
		while(k < t) {	//그 다음 인덱스부터 마지막까지 역순으로 나열한다.	
			tmp = arr[k];
			arr[k] = arr[t];
			arr[t] = tmp;
			k++;
			t--;
		}
		for(int i = 0; i < N; i++) {
			w.write(arr[i] + " ");
		}
	}
}
