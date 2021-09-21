package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//터렛
public class BJ1002 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);	//두 정점간의 거리. sqrt함수는 double 타입이므로 제곱하여 int 타입으로 계산하게 한다.
			int pr1 = r1 * r1 - 2 * r1 * r2 + r2 * r2;	//두 반지름간의 차이의 제곱 (r1 - r2)^2, 정점간의 거리를 제곱하였으므로 이것도 제곱.
			int pr2 = r1 * r1 + 2 * r1 * r2 + r2 * r2;	//두 반지름의 합의 제곱	(r1 + r2)^2 
			if(pr1 < d && d < pr2) {	//두 원이 두 점에서 만날때.
				bw.write("2\n");
			}else if(d != 0 && pr1 == d || pr2 == d) {	//두 원이 한 점에서 만날때
				bw.write("1\n");
			}else if(d < pr1 || pr2 < d) {	//두 원이 만나지 않을때
				bw.write("0\n");
			}else if(d == 0 && r1 == r2) {	//두 원이 같을때
				bw.write("-1\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
