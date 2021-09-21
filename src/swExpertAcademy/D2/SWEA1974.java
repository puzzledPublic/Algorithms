package swExpertAcademy.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//스도쿠 검증
public class SWEA1974 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int[][] sudoku = new int[9][9];
		for(int i = 1; i <= T; i++) {
			int[] chkW = new int[10], chkH = new int[10];
			for(int j = 0; j < 9; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 9; k++) {
					sudoku[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			boolean fail = false;
			tal: for(int j = 0; j < 9; j++) {	//행, 열 숫자 검증
				for(int k = 0; k < 9; k++) {
					chkW[sudoku[j][k]]++;
					chkH[sudoku[k][j]]++;
				}
				int baseW = chkW[1];
				for(int k = 2; k < 10; k++) {
					if(baseW != chkW[k]) {
						fail = true;
						break tal;
					}
				}
				int baseH = chkH[1];
				for(int k = 2; k < 10; k++) {
					if(baseH != chkH[k]) {
						fail = true;
						break tal;
					}
				}
			}
			if(!fail) {
				int[] chk = new int[10];
				tal2 : for(int j = 0; j < 9; j += 3) {	//3x3 검증
					for(int k = 0; k < 9; k += 3) {
						for(int u = j; u < j + 3; u++) {
							for(int h = k; h < k + 3; h++) {
								chk[sudoku[u][h]]++;
							}
						}
						int base = chk[1];
						for(int u = 2; u < 10; u++) {
							if(base != chk[u]) {
								fail = true;
								break tal2;
							}
						}
					}
				}
			}
			if(fail) {
				bw.write("#" + i + " 0\n");
			}else {
				bw.write("#" + i + " 1\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
