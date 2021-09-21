package kakao.kakao2017;


//단체 사진 찍기(2017 카카오 코드 본선)
public class TakingGroupPhoto {
	public static void main(String[] args) {
		int[] n = { 2, 2 };
		String[][] data = { 
				{ "N~F=0", "R~T>2" }, 
				{ "M~C<2", "C~M>1" } 
		};
		for(int i = 0; i < n.length; i++) {
			System.out.println(solution(n[i], data[i]));
		}
	}
	//캐릭터가 총 8명이고 검사할 양은 최대 100이므로 모든 순열을 만들어 검사해도 8! * 100 이므로 시간 내에 가능하다.
	static int solution(int n, String[] data) {
		int answer = 0;
		char[] list = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};		//캐릭 리스트
		do{		
			boolean chk = false;
			for(int i = 0; i < data.length; i++) {	//모든 조건을 순회
				char a = data[i].charAt(0), b = data[i].charAt(2), compare = data[i].charAt(3);
				int ai = 0, bi = 0, com, val = data[i].charAt(4) - '0';
				for(int j = 0; j < list.length; j++) {	//두 캐릭의 위치를 찾는다.
					if(a == list[j]) {
						ai = j;
					}
					if(b == list[j]) {
						bi = j;
					}
				}
				com = (ai > bi ? ai - bi : bi - ai) - 1;	//두 캐릭 사이의 거리
				
				//조건 검사
				if(compare == '=' && com != val) {
					chk = true;
					break;
				}else if(compare == '<' && com >= val) {
					chk = true;
					break;
				}else if(compare == '>' && com <= val) {
					chk = true;
					break;
				}
			}
			
			if(!chk) {
				answer++;
			}
		}while(nextPermutation(list));
		return answer;
	}
	
	static boolean nextPermutation(char[] list) {	//순열만들기
		int i = list.length - 1, j = list.length - 1;
		while(i - 1 >= 0 && list[i - 1] > list[i]) {
			i--;
		}
		if(i == 0) {
			return false;
		}
		while(list[i - 1] > list[j]) {
			j--;
		}
		char temp = list[i - 1];
		list[i - 1] = list[j];
		list[j] = temp;
		
		j = list.length - 1;
		while(i < j) {
			temp = list[i];
			list[i] = list[j];
			list[j] = temp;
			i++;
			j--;
		}
		return true;
	}
}
