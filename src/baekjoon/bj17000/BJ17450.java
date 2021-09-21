package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//과자 사기
public class BJ17450 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		double[] snu = new double[3];
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken()) * 10;	//10개 가격
			int weight = Integer.parseInt(st.nextToken()) * 10;	//10개 무게
			if(cost >= 5000) {	//가격이 5000원이 넘는 경우
				cost -= 500;
			}
			snu[i] = (double)weight / cost;	//가성비
		}
		
		if(snu[0] < snu[1]) {
			if(snu[1] < snu[2]) {
				bw.write("U\n");
			}else {
				bw.write("N\n");
			}
		}else if(snu[1] < snu[2]) {
			if(snu[0] < snu[2]) {
				bw.write("U\n");
			}else {
				bw.write("S\n");
			}
		}else {
			bw.write("S\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
