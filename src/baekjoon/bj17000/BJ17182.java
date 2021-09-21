package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//우주 탐사선
public class BJ17182 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] floyd = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				floyd[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//플로이드 와샬
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i != j && floyd[i][j] > floyd[i][k] + floyd[k][j]) {
						floyd[i][j] = floyd[i][k] + floyd[k][j];
					}
				}
			}
		}
		
		int minTime = Integer.MAX_VALUE, index = 0;
		int[] arr = new int[N];	//순열 배열
		arr[0] = K;	//시작 지점
		for(int i = 1; i < arr.length; i++) {
			if(index == K) {
				index++;
			}
			arr[i] = index++;
		}
		

		do {	//모든 경로를 세워 돌면서 시간을 잰다.
			int time = 0;
			for(int i = 1; i < arr.length; i++) {
				time += floyd[arr[i - 1]][arr[i]];
			}
			if(minTime > time) {	//최소 시간 갱신
				minTime = time;
			}
//			System.out.println(Arrays.toString(arr));
		}while(permutation(arr));
		
		bw.write(minTime + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	//순열 생성
	static boolean permutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;
		
		while(i - 1 > 0 && arr[i - 1] > arr[i]) {
			i--;
		}
		
		if(i == 1) {
			return false;
		}
		
		while(arr[i - 1] > arr[j]) {
			j--;
		}
		
		int tmp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = tmp;
		
		j = arr.length - 1;
		
		while(i < j) {
			tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;
		}
		
		return true;
	}
}
