package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//블랙잭
public class BJ2798 {
	static int[] arr;
	static int N, M, closest;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		solve(0, 0, 0);
		bw.write(closest + "\n");
		bw.flush();
		br.close();
	}
	
	static void solve(int start, int index, int sum) {
		if(start == 3) {	//3개를 선택했으면
			if(sum <= M && M - sum < M - closest) {	//M보다 작고 M에 더 가깝다면 갱신
				closest = sum;
			}
			return;
		}
		if(sum >= M) {	//3개를 선택하지 않았는데 M이상이면 바로 리턴
			return;
		}
		for(int i = index; i < arr.length; i++) {	//모든 경우 탐색
			solve(start + 1, i + 1, sum + arr[i]);
		}
	}
}
