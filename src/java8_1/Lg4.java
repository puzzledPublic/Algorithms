package java8_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lg4 {
	public static void main(String[] args) {
		int[] N = {5, 4};
		int[][][] directory = {
				{ {1, 2}, {1, 3}, {2, 4}, {2, 5} },
				{ {3, 2}, {3, 1}, {3, 4}}
		};
		int[][][] query = {
				{{1,5},{2,5},{3,5},{4,5}},
				{{4,2},{3,1},{2,2}}
		};
		for(int i = 0; i < N.length; i++) {
			System.out.println(Arrays.toString(solution(N[i], directory[i], query[i])));
		}
	}
	static boolean flag = false;
	static int[] solution(int N, int[][] directory, int[][] query) {
        int[] answer = new int[query.length];
        
        List<Integer>[] list = new List[N + 1];
        for(int i = 1; i <list.length; i++) {
        	list[i] = new ArrayList<>();
        }
        for(int i = 0; i < directory.length; i++) {
        	list[directory[i][0]].add(directory[i][1]);
        	list[directory[i][1]].add(directory[i][0]);
        }
        
        int[] chk = new int[N + 1];
        for(int i = 0; i <query.length; i++) {
        	Arrays.fill(chk, 0);
        	flag = false;
        	chk[query[i][0]] = 1;
        	dfs(list, chk, query[i][0], query[i][1]);
        	answer[i] = chk[query[i][1]];
        }
        return answer;
    }
	static void dfs(List<Integer>[] list, int[] chk, int start, int end) {
		if(flag == true) {
			return;
		}
		for(Integer i : list[start]) {
			if(chk[i] == 0) {
				chk[i] = chk[start] + 1;
				if(i == end) {
					flag = true;
					return;
				}else {
					dfs(list, chk, i, end);
				}
			}
		}
	}
}
