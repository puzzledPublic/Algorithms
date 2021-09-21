package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordChain {
	static List<List<Integer>> adj;
	static Graph[][] graph;
	static List<Integer> indegree, outdegree;
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int N;
		N = input.nextInt();
		
		List<String> words = new ArrayList<String>();
		adj = new ArrayList<List<Integer>>();
		graph = new Graph[26][26];
		for(int i = 0; i < N; i++) {
			words.add(input.next());
		}
		
		System.out.println(solve(words));
	}
	
	static void getEulerCircuit(int here, List<Integer> circuit) {
		for(int there = 0; there < adj.size(); there++) {
			while(adj.get(here).get(there) > 0) {
				adj.get(here).set(there, adj.get(here).get(there) - 1);
				getEulerCircuit(there, circuit);
			}
		}
		circuit.add(here);
	}
	
	static List<Integer> getEulerTrailOrCircuit() {
		List<Integer> circuit = new ArrayList<Integer>();
		for(int i = 0; i < 26; i++) {
			if(outdegree.get(i) == indegree.get(i) + 1) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		
		for(int i = 0; i < 26; i++) {
			if(outdegree.get(i) != 0) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		return circuit;
	}
	
	static boolean checkEuler() {
		int plus1 = 0, minus1 = 0;
		for(int i = 0; i < 26; i++) {
			int delta = outdegree.get(i) - indegree.get(i);
			if(delta < -1 || 1 < delta) {
				return false;
			}
			if(delta == 1) {
				plus1++;
			}
			if(delta == -1) {
				minus1++;
			}
		}
		return (plus1 == 1 && minus1 == 1) || (plus1 == 0 && minus1 == 0);
	}
	
	static StringBuilder solve(List<String> words) {
		makeGraph(words);
		StringBuilder result = new StringBuilder();
		if(!checkEuler()) {
			return result.append("IMPOSSIBLE");
		}
		List<Integer> circuit = getEulerTrailOrCircuit();
		System.out.println(circuit);
		if(circuit.size() != words.size() + 1) {
			return result.append("IMPOSSIBLE");
		}
		
		Collections.reverse(circuit);
		
		for(int i = 1; i < circuit.size(); i++) {
			int a = circuit.get(i - 1);
			int b = circuit.get(i);
			if(result.length() > 0) {
				result.append(" ");
			}
			result.append(graph[a][b].wordList.get(graph[a][b].wordList.size() - 1));
			graph[a][b].wordList.remove(graph[a][b].wordList.size() - 1);
			
		}
		return result;
	}
	static void makeGraph(List<String> words) {
		
		for(int i = 0; i < graph.length; i++) {
			for(int j = 0; j < graph[0].length; j++) {
				graph[i][j] = new Graph();
			}
		}
		
		for(int i = 0; i < 26; i++) {
			adj.add(new ArrayList<Integer>());
			for(int j = 0; j < 26; j++) {
				adj.get(i).add(0);
			}
		}
		
		indegree = new ArrayList<Integer>(26);
		outdegree = new ArrayList<Integer>(26);
		for(int i = 0 ; i < 26; i++) {
			indegree.add(0);
			outdegree.add(0);
		}
		
		for(int i = 0; i < words.size(); i++) {
			String temp = words.get(i);
			int a = temp.charAt(0) - 'a';
			int b = temp.charAt(temp.length() - 1) - 'a';
			graph[a][b].wordList.add(temp);
			adj.get(a).set(b, adj.get(a).get(b) + 1);
			outdegree.set(a, outdegree.get(a) + 1);
			indegree.set(b, indegree.get(b) + 1);
		}
	}
}

class Graph {
	List<String> wordList;
	public Graph() {
		this.wordList = new ArrayList<String>();
	}
}