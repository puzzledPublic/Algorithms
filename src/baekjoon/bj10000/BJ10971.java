package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//외판원 순회2
public class BJ10971 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[][] dist = new int[N][N];
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		
		//모든 도시의 순열을 만들어 계산해본다. (2 <= n <= 10이므로 O(n!*n)이지만 가능하다.)
		do {
			int temp = 0;
			boolean pass = false;
			for(int i = 0; i < arr.length - 1; i++) {
				if(dist[arr[i]][arr[i + 1]] == 0) {		//계산 중간에 가는 비용이 0이면 갈 수 없는 경로이므로 무시
					pass = true;
					break;
				}
				temp += dist[arr[i]][arr[i + 1]];		//순열에 따라 도시간의 비용 계산
			}
			if(dist[arr[arr.length - 1]][arr[0]] == 0) {	//마지막 도시에서 처음 도시로 오는 경로까지
				pass = true;
			}
			if(!pass) {
				temp += dist[arr[arr.length - 1]][arr[0]];
				if(min > temp) {	//최소비용 갱신
					min = temp;
				}
			}
		}while(nextPermutation(arr));	//다음 순열
		bw.write(min + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1, j = arr.length - 1;
		
		while(i > 0 && arr[i - 1] >= arr[i]) {
			i--;
		}
		
		if(i == 0) {
			return false;
		}
		
		while(arr[i - 1] > arr[j]) {
			j--;
		}
		
		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;
		
		j = arr.length - 1;
		
		while(i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		return true;
	}
}
