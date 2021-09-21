package baekjoon.bj8000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//올림픽
public class BJ8979 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()), index = 0;
		int[][] arr = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			if(Integer.parseInt(st.nextToken()) == K) {
				index = i;
			}
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		int upCount = 0, sameCount = 0;	//자신 보다 등수가 높은 나라, 자신과 메달이 같은 나라
		for(int i = 0; i < N; i++) {
			if(index == i) {
				continue;
			}
			//자신보다 메달이 더 많아 높은 등수라면 upCount++
			if(arr[i][0] > arr[index][0]) {
				upCount++;
			}else if(arr[i][0] == arr[index][0] && arr[i][1] > arr[index][1]) {
				upCount++;
			}else if(arr[i][0] == arr[index][0] && arr[i][1] == arr[index][1] && arr[i][2] > arr[index][2]) {
				upCount++;
			}
			//자신과 메달이 같아 같은 등수라면 sameCount++, (upCount도 같이 올린다, 자신보다 높은 등수의 나라들 중 같은 등수들이 있을때 upCount를 증가 안해주면 바로 다음 등수로 나오기 때문에, ex: 1,2,2,4등)
			if(arr[i][0] == arr[index][0] && arr[i][1] == arr[index][1] && arr[i][2] == arr[index][2]) {
				upCount++;
				sameCount++;
			}
		}
		
		bw.write((upCount - sameCount + 1) +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
