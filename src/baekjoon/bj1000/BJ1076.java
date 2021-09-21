package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//저항
public class BJ1076 {
	static class RegistInfo{
		long value, mul;
		public RegistInfo(long value, long mul) {
			this.value = value;
			this.mul = mul;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] register = new String[3];
		String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		for(int i = 0; i < register.length; i++) {
			register[i] = br.readLine();
		}
		Map<String, RegistInfo> map = new HashMap<>();
		long k = 1;
		for(int i = 0; i < color.length; i++) {
			map.put(color[i], new RegistInfo(i, k));
			k *= 10;
		}
		long result = (map.get(register[0]).value * 10 + map.get(register[1]).value) * map.get(register[2]).mul;
		System.out.println(result);
		br.close();
	}
}
