package programmers;

import java.util.Arrays;

//카펫
public class Carpet {
	public static void main(String[] args) {
		int[] brown = {10, 8, 24, 13};
		int[] red = {2, 1, 24, 3};
		
		for(int i = 0; i < brown.length; i++) {
			System.out.println(Arrays.toString(solution(brown[i], red[i])));
		}
	}
	
	static int[] solution(int brown, int red) {
        int[] answer = {};
        
        int size = (brown - 4) / 2;
        int w = size % 2 == 0 ? size / 2 : size / 2 + 1, h = size - w;
        
        while(h >= 1) {
        	if(w * h == red) {
        		answer = new int[]{w + 2, h + 2};
        		break;
        	}
        	w++;
        	h--;
        	
        }
        return answer;
    }
}
