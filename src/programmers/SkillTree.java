package programmers;

import java.util.StringTokenizer;

//스킬 트리
public class SkillTree {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	
	static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < skill_trees[i].length(); j++) {	//각 사용자 스킬트리에 대해 원본 스킬트리에 있는것만 추려낸다.
        		if(skill.indexOf(skill_trees[i].charAt(j)) != -1) {
        			sb.append(skill_trees[i].charAt(j));
        		}
        	}
        	boolean possible = true;
        	for(int j = 0; j < sb.length(); j++) {	//원본 스킬트리와 순서가 같은지 검사
        		if(skill.charAt(j) != sb.charAt(j)) {
        			possible = false;
        			break;
        		}
        	}
        	if(possible) {	//같다면 +1
        		answer++;
        	}
        }
   
        return answer;
    }
}
