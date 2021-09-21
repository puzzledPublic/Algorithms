package programmers;

import java.util.LinkedList;
import java.util.Queue;

//단어변환
public class WordTransformation {
	public static void main(String[] args) {
		String[] begin = {"hit", "hit"};
		String[] target = {"cog", "cog"};
		String[][] words = {
				{"hot", "dot", "dog", "lot", "log", "cog"},
				{"hot", "dot", "dog", "lot", "log"}
		};
		for(int i = 0; i < begin.length; i++) {
			System.out.println(solution(begin[i], target[i], words[i]));
		}
	}
	static class TempWord {
		String word;
		int step;
		TempWord(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}
	static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] chk = new boolean[words.length];
        Queue<TempWord> queue = new LinkedList<>();
        queue.add(new TempWord(begin, 0));
        while(!queue.isEmpty()) {
        	TempWord tw = queue.poll();
        	if(tw.word.equals(target)) {
        		answer = tw.step;
        		break;
        	}
        	for(int i = 0; i < words.length; i++) {
        		if(!chk[i] && canTransform(tw.word, words[i])) {
        			chk[i] = true;
        			queue.add(new TempWord(words[i], tw.step + 1));
        		}
        	}
        }
        return answer;
    }
	static boolean canTransform(String a, String b) {
		int count = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}
}
