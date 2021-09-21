package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//이차원 배열과 연산
public class BJ17140 {
	static class Numcon{
		int number, count;
		Numcon(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[100][100];
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Numcon> list = new ArrayList<>();
		
		int time = 0, row = 3, col = 3;	//시작 row, col 크기
		while(time <= 100) {
			if(arr[r - 1][c - 1] == k) {	//해당 위치가 원하는 숫자면 종료
				break;
			}
			if(row >= col) {	//행 연산
				int max = 0;
				for(int i = 0; i < row; i++) {
					list.clear();
					for(int j = 0; j < col ; j++) {
						if(arr[i][j] != 0) {
							boolean in = false;
							for(Numcon nc : list) {
								if(nc.number == arr[i][j]) {	//중복된 숫자가 있으면
									nc.count++;	//숫자 갯수 증가
									in = true;
									break;
								}
							}
							if(!in) {	//중복된 숫자가 없다면
								list.add(new Numcon(arr[i][j], 1));	//새로 추가
							}
							arr[i][j] = 0;	//0으로 초기화해준다 (현재 행에 채워진 숫자 갯수보다 다음에 채울 갯수가 더 적을 수 있다)
						}
					}
					
					list.sort((a, b) -> {	//숫자가 적은 수가 앞에 오도록, 같다면 숫자가 더 작은 수가 앞에 오도록 정렬
						if(a.count == b.count) {
							return a.number - b.number;
						}
						return a.count - b.count;
					});
					
					for(int j = 0; j < list.size(); j++) {	//현재 행에 숫자들을 채운다.
						if(j * 2 < 100) {	//배열 크기를 넘어가면 안되므로 검사
							arr[i][j * 2] = list.get(j).number;
							if(j * 2 + 1 < 100) {
								arr[i][j * 2 + 1] = list.get(j).count;
							}
						}
					}
					if(max < list.size() * 2) {	//채워진 최대 열 크기를 구한다.
						max = list.size() * 2;
					}
 				}
				col = Math.min(max, 100);	//열 크기가 100보단 작아야한다.
			}else {	//열 연산
				int max = 0;
				for(int j = 0; j < col; j++) {
					list.clear();
					for(int i = 0; i < row; i++) {
						if(arr[i][j] != 0) {
							boolean in = false;
							for(Numcon nc : list) {
								if(nc.number == arr[i][j]) {
									nc.count++;
									in = true;
									break;
								}
							}
							if(!in) {
								list.add(new Numcon(arr[i][j], 1));
							}
							arr[i][j] = 0;
						}
					}
					list.sort((a, b) -> {
						if(a.count == b.count) {
							return a.number - b.number;
						}
						return a.count - b.count;
					});
					for(int i = 0; i < list.size(); i++) {
						if(i * 2 < 100) {
							arr[i * 2][j] = list.get(i).number;
							if(i * 2 + 1 < 100) {
								arr[i * 2 + 1][j] = list.get(i).count;
							}
						}
					}
					if(max < list.size() * 2) {
						max = list.size() * 2;
					}
				}
				row = Math.min(max, 100);
			}
			time++;
		}
		bw.write((time > 100 ? "-1" : time) + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
