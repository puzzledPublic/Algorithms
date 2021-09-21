package baekjoon.bj5000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//탄산 음료
public class BJ5032 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int E = Integer.parseInt(st.nextToken()), F = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		int count = 0;
		E += F;	//처음에 가진 빈병 수
		//F는 중간 연산을 저장하기 위한 변수로 쓰자.
		while(E > 0 && E >= C) {	//빈 병이 남아있고, 병을 바꿀 수 있는 동안
			F = E / C;	//바꾼 병 수
			count += F;	//추가
			E %= C;		//남은 병 수
			E += F;		//바꾼 병 수 또한 남은 병 수에 추가
		}
		
		bw.write(count + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
