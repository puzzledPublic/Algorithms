package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//간단한 압축 풀기
public class SWEA1946 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int count = 1;
			bw.write("#" + i + "\n");
			for(int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				char alpha = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				while(num > 0) {
					bw.write(alpha);
					if(count % 10 == 0) {	//10번 찍었으면 줄바꿈
						bw.write("\n");
					}
					num--;
					count++;
				}
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
