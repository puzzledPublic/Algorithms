package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//주혁이의 복권 당첨
public class SWEA6900 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[] winCode = new String[N];	//당첨번호
			int[] winPrize = new int[N];		//당첨금
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				winCode[j] = st.nextToken();
				winPrize[j] = Integer.parseInt(st.nextToken());
			}
			
			int totalPrize = 0;	//최종 당첨 금액
			for(int j = 0; j < M; j++) {	//각 고유번호에 대해
				String code = br.readLine();
				for(int k = 0; k < N; k++) {	//모든 당첨번호에 대조한다.
					boolean isWin = true;
					for(int u = 0; u < 8; u++) {	//각 자리수에대해
						if(winCode[k].charAt(u) != '*' && winCode[k].charAt(u) != code.charAt(u)) {	//당첨코드가 *가 아니고, 숫자가 서로 다르면 당첨 안됨.
							isWin = false;
							break;
						}
					}
					if(isWin) {	//당첨됐다면 당첨금 추가 후 다음 고유번호로
						totalPrize += winPrize[k];
						break;
					}
				}
			}
			
			bw.write("#" + i + " " + totalPrize + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
