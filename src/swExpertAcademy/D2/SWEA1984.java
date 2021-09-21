package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//중간 평균값 구하기
public class SWEA1984 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10];
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			double count = 0;
			for(int j = 1; j < 9; j++) {
				count += arr[j];
			}
			bw.write("#" + i + " " + (int)((count / 8) + 0.5) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
