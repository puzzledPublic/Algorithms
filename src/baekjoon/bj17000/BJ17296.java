package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//But can you do it in 0.5x A presses?
public class BJ17296 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		int pressed = 0;
		for(int i = 0; i < N; i++) {
			double button = Double.parseDouble(st.nextToken());
			count += (int)button;
			if(button != 0) {	//0이 아니라면 버튼은 눌린 상태로 지속할 수 있다.
				pressed++;
			}
			if(pressed == 1 && (int)(button * 10) % 10 == 5) {	//첫번째로 버튼이 눌렸을때 0.5의 배수인 경우 1번 더 누르게 된다.
				count++;
			}
		}
		
		bw.write(count + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
