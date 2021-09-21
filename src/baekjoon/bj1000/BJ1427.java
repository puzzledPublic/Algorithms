package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//소트 인사이드
public class BJ1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		solve(s, bw);
		bw.close();
		br.close();
	}
	static void solve(String s, Writer w) throws IOException {
		int[] arr = new int[s.length()];
		for(int i = 0; i < arr.length; i++) {	//숫자를 각 자리 수들로 분리
			arr[i] = s.charAt(i) - '0';
		}
		for(int i = 0; i < arr.length - 1; i++) {	//정렬(내림차순)
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int i = 0; i < arr.length; i++) {	//출력
			w.write(arr[i] + "");
		}
		w.write("\n");
		w.flush();
	}
}
