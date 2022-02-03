package baekjoon.bj18000;

import java.io.*;
import java.util.*;

//좌표 압축
public class BJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[N];
        SortedSet<Integer> ss = new TreeSet<>();
        Map<Integer, Integer> m = new HashMap<>();

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            ss.add(arr[i]); //sortedSet으로 정렬 및 중복제거
        }

        Integer[] sortedArr = ss.toArray(new Integer[0]);
        for(int i = 0; i < sortedArr.length; i++) {
            m.put(sortedArr[i], i); //map에 해당 수의 압축된 위치 저장
        }

        for(int i = 0; i < N; i++) {    //원래 배열에서 수들의 압축된 위치 출력
            bw.write(m.get(arr[i]) + " ");
        }

        bw.close();
        br.close();
    }
}
