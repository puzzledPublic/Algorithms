package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//아름이의 돌 던지기
public class SWEA1285 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = 0, min = 987654321;	//0에 가까운 사람 수, 최소 거리
			for(int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				t = t > 0 ? t : -t;
				if(min > t) {
					min = t;
					num = 1;
				}else if(min == t) {
					num++;
				}
			}
			bw.write("#" + i + " " + min + " " + num + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
