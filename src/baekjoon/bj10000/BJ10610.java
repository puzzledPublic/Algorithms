package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//30 (그리디)
public class BJ10610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10];
		String s = br.readLine();
		int test = 0;
		for(int i = 0; i < s.length(); i++) {	
			arr[s.charAt(i) -'0']++;
			test += s.charAt(i) - '0';
			test %= 3;
		}
		if(test == 0 && arr[0] > 0) {	//각 숫자들의 합이 3의 배수이고 마지막 자리수에 0이 존재하면 30의 배수.
			for(int i = 9; i >= 0; i--) {	//최대값을 출력하므로 9부터 0까지 채운다.
				while(arr[i] != 0) {
					bw.write(i+"");
					arr[i]--;
				}
			}
		}else {
			bw.write("-1\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
