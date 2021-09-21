package baekjoon.bj17000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//수강바구니
public class BJ17488 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] courseLimit = new int[M + 1];	//각 과목당 신청가능 학생 수
		List<List<Integer>> applyStudent = new ArrayList<>();	//각 과목당 신청한 학생들
		List<List<Integer>> registeredCourse = new ArrayList<>();	//각 학생이 신청한 과목들
		
		//초기화
		for(int i = 0; i <= M; i++) {
			applyStudent.add(new ArrayList<>());
		}
		
		for(int i = 0; i <= N; i++) {
			registeredCourse.add(new ArrayList<>());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 1; i <= M; i++) {
			courseLimit[i] = Integer.parseInt(st.nextToken());
		}
		
		//1차, 2차 두번 수강 신청
		for(int k = 0; k < 2; k++) {
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int num;
				while((num = Integer.parseInt(st.nextToken())) != -1) {
					courseLimit[num]--;	//과목에 신청시마다 제한 수 감소
					applyStudent.get(num).add(i);	//각 과목을 신청한 학생 추가
				}
			}
			
			for(int i = 1; i <= M; i++) {
				if(courseLimit[i] >= 0) {	//제한 인원 수가 음수라면 과목 신청 인원 초과.
					for(int student : applyStudent.get(i)) {	//과목 신청 인원 초과가 아닌 경우 각 학생은 수강신청 성공하게 된다. 
						registeredCourse.get(student).add(i);
					}
					applyStudent.get(i).clear();	//성공한 인원들을 제거한다.
				}
			}
		}
		
		for(int i = 1; i < registeredCourse.size(); i++) {
			if(registeredCourse.get(i).isEmpty()) {	//수강 신청된게 없다면 망했어요
				bw.write("망했어요\n");
			}else {	//수강 신청 성공 시 과목들 출력
				Collections.sort(registeredCourse.get(i));	//과목을 오름차순 출력해야하므로 정렬
				for(int course : registeredCourse.get(i)) {
					bw.write(course + " ");
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}