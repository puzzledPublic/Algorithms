package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//조 만들기
public class SWEA8104 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[K + 1];
			
			int num = 1, s, add;
			for(int i = 1; i <= N; i++) {
				if(i % 2 == 1) {	//인덱스 1 ~ K까지
					s = 0;
					add = 1;
				}else {				//인덱스 K ~ 1까지
					s = K + 1;
					add = -1;
				}
				for(int j = 1; j <= K; j++) {
					arr[s += add] += num++;	//해당 인덱스에 숫자 저장
				}
			}
			
			//출력
			bw.write("#" + t + " ");
			for(int i = 1; i <= K; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
