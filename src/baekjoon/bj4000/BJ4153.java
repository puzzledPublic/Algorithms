package baekjoon.bj4000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//직각삼각형
public class BJ4153 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] side = new int[3];
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 3; i++) {
				side[i] = Integer.parseInt(st.nextToken());
			}
			if(side[0] == 0 && side[1] == 0 && side[2] == 0) {	//0 0 0 = 종료
				break;
			}
		
			Arrays.sort(side);
			
			if(side[0] * side[0] + side[1] * side[1] == side[2] * side[2]) {	//가장 긴변의 제곱 = 나머지 두변의 제곱의 합 => 직각삼각형
				bw.write("right\n");
			}else {
				bw.write("wrong\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
