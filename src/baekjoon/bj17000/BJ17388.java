package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//와글와글 숭고한
public class BJ17388 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[][] grade = new int[3][2];
		for(int i = 0; i < 3; i++) {
			grade[i][0] = Integer.parseInt(st.nextToken());
			grade[i][1] = i;
		}
		
		Arrays.sort(grade, (a, b) -> a[0] - b[0]);	//오름차순 정렬.
		if(grade[0][0] + grade[1][0] + grade[2][0] >= 100) {	//참여도 합이 100이상이면 OK
			bw.write("OK\n");
		}else {	//아니라면 최소 참여도를 가지는 학교 출력
			switch(grade[0][1]) {
				case 0:
					bw.write("Soongsil\n");
					break;
				case 1:
					bw.write("Korea\n");
					break;
				default:
					bw.write("Hanyang");
					break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
