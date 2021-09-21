package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//조교의 성적 매기기
public class SWEA1983 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"}; 
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
			double[][] arr = new double[N][2];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken()) * 0.35 + Integer.parseInt(st.nextToken()) * 0.45 + Integer.parseInt(st.nextToken()) * 0.20;	//총점계산
				arr[j][1] = j + 1;	//학생번호
			}
			Arrays.sort(arr, (a, b) -> -Double.compare(a[0], b[0]));	//총점 내림차순
			for(int j = 0; j < arr.length; j++) {
				if(K == (int)arr[j][1]) {	//알고싶은 학생번호가 어디에 위치했는가
					bw.write("#" + i + " " + grade[(j / (N / 10))] + "\n");	//10의 비율로 점수가 나눠지므로
					break;
				}
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
