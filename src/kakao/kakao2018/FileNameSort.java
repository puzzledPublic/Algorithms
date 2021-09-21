package kakao.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//파일명 정렬
//stable sort = 버블정렬, 합병정렬, 선택정렬, 쉘정렬, 카운팅정렬, 버켓정렬
//unstable sort = 힙정렬, 퀵정렬
public class FileNameSort {
	static String[][] inputs= {
		{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"},
		{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"},
		{"A1.png", "a1.png", "A1", "a0.png", "a0.tt", "bt1","A00001.p", "a00001.p", "a01.p"},
		{"A2", "a1-1312"}
	};
	
	public static void main(String[] args) {
		for(int i = 0; i < inputs.length; i++) {
			solve(inputs[i]);
		}
//		solve2(inputs[3]);
	}
	
	
	static void solve2(String[] files) {
		FileName[] fileNames = new FileName[files.length];
		int n = 0, t = 0;
		for(int i = 0; i < files.length; i++) {	//파싱하는데 주의하자.
			boolean nCheck = false, tCheck = false;
			for(int j = 0; j < files[i].length() - 1; j++) {
				char prev = files[i].charAt(j);
				char next = files[i].charAt(j + 1);
				if(!nCheck && ((prev < '0' || prev > '9') && (next >= '0' && next <= '9'))) {
					n = j + 1;
					nCheck = true;
				}
				if(!tCheck && ((prev >= '0' && prev <= '9') && (next < '0' || next > '9'))) {
					t = j + 1;
					tCheck = true;
				}
				if(nCheck && tCheck) {
					break;
				}
			}
			if(!tCheck) {
				t = files[i].length();
				fileNames[i] = new FileName(files[i].substring(0, n), files[i].substring(n, t), "");
			}else {
				fileNames[i] = new FileName(files[i].substring(0, n), files[i].substring(n, t), files[i].substring(t));
			}
		}
		
		//버블 정렬 (stable sort)
		for(int i = 0; i < fileNames.length; i++) {
			for(int j = 1; j < fileNames.length - i; j++) {
				int compare = fileNames[j].head.compareToIgnoreCase(fileNames[j - 1].head);
				if(compare == 0) {
					if(Integer.parseInt(fileNames[j].number) < Integer.parseInt(fileNames[j - 1].number)) {
						FileName temp = fileNames[j];
						fileNames[j] = fileNames[j - 1];
						fileNames[j - 1] = temp;
					}
				}else if(compare < 0){
					FileName temp = fileNames[j];
					fileNames[j] = fileNames[j - 1];
					fileNames[j - 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(fileNames));
	}
	static void solve(String[] files) {
		int n = 0, t = 0;
		List<FileName> fileNames = new ArrayList<>();
		for(int i = 0; i < files.length; i++) {
			boolean nCheck = false, tCheck = false;
			for(int j = 0; j < files[i].length() - 1; j++) {
				char prev = files[i].charAt(j);
				char next = files[i].charAt(j + 1);
				if(!nCheck && ((prev < '0' || prev > '9') && (next >= '0' && next <= '9'))) {
					n = j + 1;
					nCheck = true;
				}
				if(!tCheck && ((prev >= '0' && prev <= '9') && (next < '0' || next > '9'))) {
					t = j + 1;
					tCheck = true;
				}
				if(nCheck && tCheck) {
					break;
				}
			}
			if(!tCheck) {
				t = files[i].length();
				fileNames.add(new FileName(files[i].substring(0, n), files[i].substring(n, t), ""));
			}else {
				fileNames.add(new FileName(files[i].substring(0, n), files[i].substring(n, t), files[i].substring(t)));
			}
		}
		//아마 mergeSort( stable sort)
		Collections.sort(fileNames, (a, b) -> {
			int result = a.head.compareToIgnoreCase(b.head);
			if(result == 0) {
				int an = Integer.parseInt(a.number);
				int bn = Integer.parseInt(b.number);
				return Integer.compare(an, bn);
			}
			return result;
		});
		
		System.out.println(Arrays.toString(fileNames.toArray()));
	}
}

class FileName{
	String head;
	String number;
	String tail;
	public FileName(String head, String number, String tail) {
		this.head = head;
		this.number = number;
		this.tail = tail;
	}
	@Override
	public String toString() {
		return this.head + this.number + this.tail;
	}
}
