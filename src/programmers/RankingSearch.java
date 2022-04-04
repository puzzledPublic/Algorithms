package programmers;

import java.util.*;

//순위 검색
public class RankingSearch {
    public static void main(String[] args) {
        String[] info = {
                "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
        };

        String[] query = {
                "java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"
        };

        Arrays.stream(solution(info, query)).forEach(r -> System.out.print(r + " "));
    }

    static int[] solution(String[] info, String[] query) {
        int[] answer = {};

        String[] langs = {"cpp", "java", "python", "-"};
        String[] fields = {"backend", "frontend", "-"};
        String[] careers = {"junior", "senior", "-"};
        String[] soulFoods = {"chicken", "pizza", "-"};

        //Map<점수를 제외한 쿼리, 해당 쿼리를 만족하는 점수 리스트>
        Map<String, List<Integer>> queryMap = new HashMap<>();
        List<Info> queryList = new ArrayList<>();   //점수를 제외한 미리 생성해놓은 쿼리들
        for(int i = 0; i < langs.length; i++) {
            for(int i2 = 0; i2 < fields.length; i2++) {
                for(int i3 = 0; i3 < careers.length; i3++) {
                    for(int i4 = 0; i4 < soulFoods.length; i4++) {
                        Info q = new Info(langs[i], fields[i2], careers[i3], soulFoods[i4], -1);
                        queryList.add(q);
                        queryMap.put(q.query, new ArrayList<>());
                    }
                }
            }
        }

        //참가자들 입력 분석
        for(int i = 0; i < info.length; i++) {
            String[] splittedInfo = info[i].split(" ");
            String lang = splittedInfo[0];
            String field = splittedInfo[1];
            String career = splittedInfo[2];
            String soulFood = splittedInfo[3];
            int grade = Integer.parseInt(splittedInfo[4]);
            for(Info q : queryList) {   //미리 생성해 놓은 쿼리에 해당되면 참가자의 점수를 저장
                if(q.lang != "-" && !q.lang.equals(lang)) continue;
                if(q.field != "-" && !q.field.equals(field)) continue;
                if(q.career != "-" && !q.career.equals(career)) continue;
                if(q.soulFood != "-" && !q.soulFood.equals(soulFood)) continue;
                queryMap.get(q.query).add(grade);
            }
        }

        //점수가 담긴 리스트를 오름차순 정렬
        queryMap.forEach((s, list) -> list.sort(Comparator.naturalOrder()));

        List<Integer> results = new ArrayList<>();

        //쿼리 분석
        for(int i = 0; i < query.length; i++) {
            String q = query[i].substring(0, query[i].lastIndexOf(" "));
            int grade = Integer.parseInt(query[i].substring(query[i].lastIndexOf(" ") + 1));
            List<Integer> gradeList = queryMap.get(q);
            //이분탐색, 쿼리의 점수 보다 같거나 큰 수의 위치를 찾는다.
            int start = 0, end = gradeList.size();
            while(start < end) {
                int mid = (start + end) / 2;
                if(gradeList.get(mid) > grade) {
                    end = mid;
                }else if(gradeList.get(mid) < grade) {
                    start = mid + 1;
                }else {
                    if(mid - 1 >= 0 && gradeList.get(mid - 1) == grade) {
                        end = mid;
                    }else {
                        start = mid;
                        break;
                    }
                }
            }

            results.add(gradeList.size() - start);
        }

        return answer = results.stream().mapToInt(a -> a).toArray();
    }

    static class Info {
        int grade;
        String lang, field, career, soulFood;
        String query;
        Info(String lang, String field, String career, String soulFood, int grade) {
            this.lang = lang;
            this.field = field;
            this.career = career;
            this.soulFood = soulFood;
            this.grade = grade;
            this.query = lang + " and " + field + " and " + career + " and " + soulFood;
        }
    }
}
