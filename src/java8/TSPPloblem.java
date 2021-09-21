package java8;

import java.util.ArrayList;
import java.util.List;

public class TSPPloblem {
	
	static int n = 4;
	static double dist[][] = {{0,1,2,4},
							  {1,0,3,0},
							  {2,3,0,5},
							  {4,0,5,0}};
	
	public static void main(String args[])
	{
		List<Integer> path = new ArrayList<>();
		List<Boolean> visited = new ArrayList<>();
		path.add(0);
		for(int i = 0 ; i<n; i++)
		{
			
			visited.add(i, false);
		}
		
		System.out.println("최소거리 "+shortestPath(path, visited, 0.0));
	}
	
	public static double shortestPath(List<Integer> path, List<Boolean> visited, double currentLength)
	{
		if(path.size() == n)
		{
			return currentLength + dist[path.get(0)][path.get(path.size()-1)];
		}
		double ret = Double.MAX_VALUE;
		
		for(int next = 0 ; next < n ; next++)
		{
			if(visited.get(next)||path.contains(next)) 
			{
				continue;
			}
			int here = path.get(path.size()-1);
			/*
			if(dist[here][next] == 0)
			{
				continue;
			}*/
			path.add(next);
			visited.add(next,true);
			System.out.println("dist["+here+"]["+next+"]");
			double cand = shortestPath(path, visited, currentLength+dist[here][next]);
			System.out.println(cand);
			ret = Math.min(ret, cand);
			visited.add(next, false);
			path.remove(path.size()-1);
		}
		return ret;
	}
}
