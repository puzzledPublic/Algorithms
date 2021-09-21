package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//창고 다각형
public class BJ2304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map, (a, b) -> a[0] - b[0]);	//위치 순으로 정렬
		
		//왼쪽에서 최대 기둥 높이까지 훑고 오른쪽에서도 최대 기둥 높이까지 훑어 면적을 계산한다.
		//오목진 곳은 없어야 하므로 왼쪽에서 훑을때 현재 최대 기둥 높이 보다 더 큰 기둥이 나타날때 갱신한다.
		
		int result = 0;
		int start = map[0][0], height = map[0][1], end = 0;
		for(int i = 1; i < N; i++) {	//끝까지 훑으며 현재까지의 최고 높이보다 큰 기둥이라면 면적을 계산하고 최고 높이를 갱신한다.
			if(height <= map[i][1]) {
				result += (map[i][0] - start) * height;
				start = map[i][0];
				end = i;	//최고 높이인 기둥 인덱스
				height = map[i][1];
			}
		}
		
		result += height;	//최대 기둥 높이의 면적은 계산 안됐으므로 더해준다.
		
		int start2 = map[N - 1][0], height2 = map[N - 1][1];
		for(int i = N - 1; i >= end; i--) {		//이번엔 반대로 끝에서 최고 높이인 기둥 인덱스까지 위의 행동을 그대로 한다.
			if(height2 < map[i][1]) {
				result += (start2 - map[i][0]) * height2;
				start2 = map[i][0];
				height2 = map[i][1];
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
