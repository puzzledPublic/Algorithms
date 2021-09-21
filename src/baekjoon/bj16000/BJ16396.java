package baekjoon.bj16000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//선 그리기
public class BJ16396 {
	//(다른 풀이) 구간이 1 ~ 10000이므로 정렬하여 그리디하게 풀 필요 없이 배열에 덮어씌워 계산하는게 더 빠르다.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N + 1][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		arr[N][0] = arr[N][1] = 10001;	//맨 마지막 계산을 위한 패딩값
		
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);	//시작좌표를 가지고 오름차순 정렬
		
		int s = arr[0][0], e = arr[0][1], len = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i][0] <= e) {	//현재 시작점이 이전 종료점보다 낮은 경우 겹친다.
				if(arr[i][1] > e) {	//완전 포함이 아니라면 종료점을 갱신
					e = arr[i][1];
				}
			}else {					//현재 시작점이 이전 종료점보다 높은 경우 겹치지 않는다.
				len += e - s;		//현재까지 구한 구간을 더한다.
				s = arr[i][0];		//시작점과 종료점을 갱신한다.
				e = arr[i][1];
			}
		}
		
		bw.write(len + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
