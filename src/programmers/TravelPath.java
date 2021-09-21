package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//여행경로
public class TravelPath {
	public static void main(String[] args) {
		String[][][] tickets = {
				{
					{"ICN", "JFK"},
					{"HND", "IAD"},
					{"JFK", "HND"}
				},
				{
					{"ICN", "SFO"},
					{"ICN", "ATL"},
					{"SFO", "ATL"},
					{"ATL", "ICN"},
					{"ATL", "SFO"}
				},
				{
					{"ICN", "ATL"},
					{"ATL", "SFO"},
					{"SFO", "ATL"}
				}
		};
		for(int i = 0; i < tickets.length; i++) {
			System.out.println(Arrays.toString(solution(tickets[i])));
		}
	}
	static boolean completed;
	static String[] solution(String[][] tickets) {
		completed = false;
        String[] answer = new String[tickets.length + 1];
        Map<String, Integer> ticket = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tickets.length; i++) {
        	if(ticket.containsKey(tickets[i][0] + tickets[i][1])) {
        		ticket.replace(tickets[i][0] + tickets[i][1], ticket.get(tickets[i][0] + tickets[i][1]) + 1);
        	}else {
        		ticket.put(tickets[i][0] + tickets[i][1], 1);
        	}
        }
        for(int i = 0; i < tickets.length; i++) {
        	if(map.containsKey(tickets[i][0])) {
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	}else {
        		map.put(tickets[i][0], new ArrayList<>());
        		map.get(tickets[i][0]).add(tickets[i][1]);
        	}
        }
        for(String s : map.keySet()) {
        	map.get(s).sort((a,b) -> a.compareTo(b));
        }
        stack.add("ICN");
        dfs(map, ticket, stack, "ICN", answer);
        return answer;
    }
	
	static void dfs(Map<String, List<String>> map, Map<String, Integer> ticket, Stack<String> stack, String from, String[] answer) {
		if(completed) {
			return;
		}
		boolean chk = false;
		for(String key : ticket.keySet()) {
			if(ticket.get(key) != 0) {
				chk = true;
				break;
			}
		}
		if(!chk) {
			stack.toArray(answer);
			completed = true;
			return;
		}
		if(map.containsKey(from)) {
			for(String to : map.get(from)) {
				if(ticket.containsKey(from + to) && ticket.get(from + to) > 0) {
					ticket.replace(from + to, ticket.get(from + to) - 1);
					stack.push(to);
					dfs(map, ticket, stack, to, answer);
					stack.pop();
					ticket.replace(from + to, ticket.get(from + to) + 1);
				}
			}
		}
	}
}
