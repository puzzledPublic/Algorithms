package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//시각 덧셈
public class SWEA1976 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[4];
			for(int j = 0; j < 4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int time = (arr[1] + arr[3] >= 60 ? arr[0] + arr[2] + 1 : arr[0] + arr[2]);
			time = time > 12 ? time % 12 : time;
			time = time == 0 ? 12 : time;	//0시인 경우 12시로 바꾸기
			int minute = (arr[1] + arr[3]) % 60;
			bw.write("#" + i + " " + time + " " + minute + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
