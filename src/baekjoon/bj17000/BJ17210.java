package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//문문문
public class BJ17210 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());
		int open = Integer.parseInt(br.readLine());
		if(N > 5) {	//규칙에 따르면 연속으로 같은 행동을 할 수 없고 2, 3의배수에는 같은 행동을 해야하므로 필연적으로 6번째 문에서 규칙을 위반한다.
			bw.write("Love is open door\n");
		}else {
			for(int i = 1; i < N; i++) {
				open = (open + 1) % 2;
				bw.write(open + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
