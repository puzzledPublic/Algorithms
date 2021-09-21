package swExpertAcademy.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//상원이의 연속 합
public class SWEA7510 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			int time = 0, k = 1;	//time = N을 연속합으로 나타낼 수 있는 경우의 수, k = 연속하는 수의 갯수
			//모두 더해 N을 만족하는 k개의 연속하는 수를 나타내보면 N = n + (n + 1) + (n + 2) ... (n + k)이고
			//N = k*n + sum(1~k-1)이다.
			//여기서 N이 되려면 (N - (sum(1~k-1))) % k == 0이 되어야하고 (k는 자연수이므로) n은 1이상이어야 한다.(자연수의 연속합이므로)
			while(true) {
				if((N - (k * (k - 1)) / 2) / k == 0) {	//n이 0이 되면 더이상 검사할 필요가 없다.
					break;
				}
				if((N - (k * (k - 1)) / 2) % k == 0) {	//나누어 떨어지면 n은 자연수이고 1이상이므로 n으로 시작하는 k개의 연속된 수의 합으로 N을 나타낼 수 있다.
					time++;
				}
				k++;
			}
			bw.write("#" + i + " " + time + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
