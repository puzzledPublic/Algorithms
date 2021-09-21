package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
//영어 끝말잇기
public class EnglishWordChain {
	public static void main(String[] args) {
		int[] n = {3, 5, 2};
		String[][] words = {
				{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
				{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
				{"hello", "one", "even", "never", "now", "world", "draw"},
		};
		
		for(int i = 0; i < n.length; i++) {
			System.out.println(Arrays.toString(solution(n[i], words[i])));
		}
	}
	
	static int[] solution(int n, String[] words) {
        int[] answer = {};
        answer = new int[2];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
        	if(set.contains(words[i]) || (i - 1 >= 0 && words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0))) {
        		answer[0] = (i % n) + 1;
        		answer[1] = (i + 1) % n == 0 ? (i + 1) / n : (i + 1) / n + 1;
        		break;
        	}
        	set.add(words[i]);
        }
        
        return answer;
    }
}
