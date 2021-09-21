package kakao.kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//뉴스 클러스터링 (자카드 유사도)
public class NewsClustering {
	
	static String[] inputStr1 = {"FRANCE", "handshake", "aa1+aa2", "E=M*C^2", "a*b","aab ac", "ab"};
	static String[] inputStr2 = {"french", "shake hands", "AAAA12", "e=m*c^2", "c-d","aab aa", "cd"};
	
	public static void main(String[] args) {
		
		
		for(int i = 0 ; i < inputStr1.length; i++) {
			System.out.println(solve(inputStr1[i], inputStr2[i]));
		}
	}
	
	static int solve(String str1, String str2) {
		double result = 1.0;
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		
		eraseExceptionChar(list, str1);
		eraseExceptionChar(list2, str2);
		
		int x = 0, y = 0;
		int[] check = new int[list.size()];
		for(int i = 0; i < list2.size(); i++) {
			for(int j = 0; j < list.size(); j++) {
				if(check[j] == 0 && list.get(j).equals(list2.get(i))) {
					check[j] = 1;
					x++;
					break;
				}
			}
		}
		y = list.size() - x + list2.size();
		
		if(x != 0) {	//교집합이 있는 경우
			result = (double) x / (double) y;
		}else if(list.size() > 0 || list2.size() > 0) {	//모두 공집합이 아니고, 교집합이 없는 경우
			result = 0;
		}
		
		return (int)(65536 * result);
	}
	
	static void eraseExceptionChar(List<String> list, String str) {
		char preCh, postCh;
		for(int i = 0; i < str.length() - 1; i++) {
			preCh = str.charAt(i);
			if(preCh < 'a' || preCh > 'z') {
				continue;
			}
			postCh = str.charAt(i + 1);
			if(postCh < 'a' || postCh > 'z') {
				i += 1;
				continue;
			}
			list.add("" +preCh + postCh);
		}
	}
}
