package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//준홍이의 카드놀이
public class SWEA7102 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] sum = new int[N + M + 1];	//1~N과 1~M에서 하나씩 뽑아 더했을때 나올 수 있는 숫자는 2~N+M
			for(int j = 1; j <= N; j++) {	//각각을 더했을때 나오는 숫자 갯수 계산
				for(int k = 1; k <= M; k++) {
					sum[j + k]++;
				}
			}
			
			int k = 0;
			int[] result = new int[21];
			int max = 0;
			for(int j = 1; j <= N + M; j++) {	//나올 수 있는 숫자 갯수가 많은것을 고른다.
				if(max < sum[j]) {
					max = sum[j];
					k = 0;
					result[k++] = j;
				}else if(max == sum[j]) {
					result[k++] = j;
				}
			}
			
			//출력
			bw.write("#" + i + " ");
			for(int j = 0; j < k; j++) {
				bw.write(result[j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
