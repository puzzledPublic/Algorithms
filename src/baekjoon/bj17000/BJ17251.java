package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//힘 겨루기
public class BJ17251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int max = -1, first = 0, last = 0;
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			if(max < t) {	//나열된 힘들 중 가장 센 힘을 찾는다. 힘이 같다면 맨 왼쪽 것과 맨 오른쪽의 위치를 알아낸다.
				max = t;
				first = last = i;
			}else if(max == t) {
				last = i;
			}
		}
		//가장 센 힘 왼쪽에서 팀을 나눈다면 Blue가 이기고 가장 센 힘 오른쪽에서 팀을 나눈다면 Red가 이긴다.
		//각각 이기는 횟수를 세서 비교하여 출력한다.
		int RedWin = N - last - 1;
		int BlueWin = first;
		
		bw.write((RedWin == BlueWin ? "X" : (RedWin > BlueWin ? "R" : "B")));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
