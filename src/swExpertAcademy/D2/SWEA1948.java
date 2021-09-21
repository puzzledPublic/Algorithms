package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//날짜 계산기
public class SWEA1948 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] arr = new int[4];
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 4; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int day = 0;
			if(arr[0] == arr[2]) {	//월이 같을때
				day = arr[3] - arr[1];
			}else {
				day = days[arr[0]] - arr[1];	//첫 월
				for(int j = arr[0] + 1; j < arr[2]; j++) {	//중간 월
					day += days[j];
				}
				day += arr[3];	//마지막 월
			}
			bw.write("#" + i + " " + (day + 1) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
