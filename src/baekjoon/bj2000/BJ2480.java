package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//주사위 세개
public class BJ2480 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] dice = new int[3];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < 3; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(dice);
		
		int result = 0;
		if(dice[0] == dice[1] && dice[1] == dice[2]) {			//A = B = C인 경우
			result = 10000 + dice[2] * 1000;
		}else if(dice[0] == dice[1] || dice[1] == dice[2]) {	//A = B OR B = C 인 경우(정렬했고 A = B = C는 A = C일리는 없다.)
			result = 1000 + dice[1] * 100;
		}else {													//A, B, C 모두 다른 경우
			result = dice[2] * 100;
		}
		
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
