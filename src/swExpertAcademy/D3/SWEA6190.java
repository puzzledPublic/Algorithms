package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//정곤이의 단조 증가하는 수
public class SWEA6190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			int max = -1;
			for(int j = 0; j < N - 1; j++) {	//모든 쌍의 곱에대해
				for(int k = j + 1; k < N; k++) {
					int mul = arr[j] * arr[k];
					boolean isIncrease = true;
					int before = mul % 10;
					while(mul > 0) {	//단조증가하는 숫자인지 검사
						if(mul % 10 > before) {
							isIncrease = false;
							break;
						}
						before = mul % 10;
						mul /= 10;
					}
					if(isIncrease && max < arr[j] * arr[k]) {	//단조 증가하고 현재까지의 최대숫자보다 크면 갱신
						max = arr[j] * arr[k];
					}
				}
			}
			bw.write("#" + i + " " + max + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
