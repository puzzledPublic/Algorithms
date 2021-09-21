package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//가랏! RC카!
public class SWEA1940 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int dist = 0, speed = 0;
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int operator = Integer.parseInt(st.nextToken());
				if(operator == 1) {
					speed += Integer.parseInt(st.nextToken());
				}else if(operator == 2) {
					speed -= Integer.parseInt(st.nextToken());
					speed = speed < 0 ? 0 : speed;	//속도는 0이상이어야 한다.
				}
				dist += speed;
			}
			bw.write("#" + i + " " + dist + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
