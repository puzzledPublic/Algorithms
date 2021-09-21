package swExpertAcademy.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//영양사 수정
public class SWEA8050 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int comp = 0;
			for(int i = 0; i < K; i++) {
				comp <<= 1;
				comp |= 1;
			}
			int[] nutri = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < K; j++) {
					nutri[i] <<= 1;
					if(Integer.parseInt(st.nextToken()) == 1) {
						nutri[i] |= 1;
					}
				}
				nutri[i] ^= nutri[i - 1];
			}
			int max = 0, count = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j <= N; j++) {
					int tmp = nutri[j] ^ nutri[j - i - 1];
					if(tmp == 0 || tmp == comp) {
						if(max < i + 1) {
							max = i + 1;
						}
						count++;						
					}
					
				}
			}
			bw.write("#" + t + " " + max + " " + count + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
