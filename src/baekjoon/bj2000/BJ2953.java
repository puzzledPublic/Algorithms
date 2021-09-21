package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//나는 요리사다
public class BJ2953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int index = 1, max = -1;	//index = 최대 점수를 받은 요리사 번호, max = 최대 점수
		for(int i = 1; i <= 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for(int j = 0; j < 4; j++) {
				sum += Integer.parseInt(st.nextToken());
			}
			if(max < sum) {
				index = i;
				max = sum;
			}
		}
		
		bw.write(index + " " + max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
