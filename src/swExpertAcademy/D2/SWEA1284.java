package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//수도 요금 경쟁
public class SWEA1284 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[5];
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 5; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			int A = arr[0] * arr[4];	//P * W
			int B = arr[2] >= arr[4] ? arr[1] : arr[1] + (arr[4] - arr[2]) * arr[3];	//W >= R이면 Q 아니면 Q + (R - W) * S
			bw.write("#" + i + " " + Math.min(A, B) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
