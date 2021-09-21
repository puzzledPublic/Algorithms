package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

//가장 큰 금민수
public class BJ1526 {
	static int N;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		solve("0", bw);
		
		bw.write(max + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	static void solve(String str, Writer w) {
		int current = Integer.parseInt(str);	//현재 숫자
		if(current > N) {	//N보다 큰 숫자라면 리턴
			return;
		}
		if(current > max) {	//max값 보다 크면 max 갱신
			max = current;
		}
		
		solve(str + "7", w);	//7또는 4를 마지막에 붙여본다.
		solve(str + "4", w);
	}
}
