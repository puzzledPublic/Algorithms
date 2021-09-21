package kakao.kakao2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

//6번 매칭 점수
public class MatchingScore {
	public static void main(String[] args) {
		String[] word = {"blind", "Muzi"};
		String[][] pages = {
				{
					"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", 
					"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", 
					"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"
				},
				{
					"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", 
					"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"
				}
				
		};
		System.out.println(solution(word[1], pages[1]));
	}
	static class PageInfo {
		int index;
		double baseScore,linkScore, matchingScore;
		List<String> links;
		public PageInfo() {
			this.links = new ArrayList<>();
		}
	}

	static int solution(String word, String[] pages) {
		int answer = 0;
		word = word.toLowerCase();	//검색할 문자를 소문자로 통일
		Map<String, PageInfo> pageMap = new HashMap<>();	//Map<웹페이지 이름, 웹페이지 정보>
		for(int i = 0; i < pages.length; i++) {
			String html = pages[i].toLowerCase();	//html도 모두 소문자로 통일
			//웹페이지 이름 추출
			int pageNameIndexStart = html.indexOf("<meta property=\"og:url\" content=\"");	//이걸 "content=\""으로 했더니 테스트케이스 1개가 계속 틀림
			int pageNameIndexEnd = html.indexOf("\"", pageNameIndexStart + 33);
			String pageName = html.substring(pageNameIndexStart + 33, pageNameIndexEnd);
			
			PageInfo pi = new PageInfo();	//웹페이지 정보 담을 클래스
			pi.index = i;
			
			//body 태그내용을 추출
			int bodyIndexStart = html.indexOf("<body>");
			int bodyIndexEnd = html.indexOf("</body>", bodyIndexStart);
			String body = html.substring(bodyIndexStart + 6, bodyIndexEnd);
			
			//body 태그 내 a 태그(외부링크) 추출
			int next = 0;
			int hrefIndexStart;
			while((hrefIndexStart = body.indexOf("<a href=\"", next)) != -1) {
				int hrefIndexEnd = body.indexOf("\"", hrefIndexStart + 9);
				next = hrefIndexEnd;
				pi.links.add(body.substring(hrefIndexStart + 9, hrefIndexEnd));
			}
			
			//body 태그 내 단어들 검색
			next = 0;
			int wordIndexStart;
			while((wordIndexStart = body.indexOf(word, next)) != -1) {
				int wordIndexEnd = wordIndexStart + word.length();
				next = wordIndexEnd;
				//단어의 앞, 뒤로 알파벳이 없다면 성공
				if(!('a' <= body.charAt(wordIndexStart - 1) && body.charAt(wordIndexStart - 1) <= 'z') && !('a' <= body.charAt(wordIndexEnd) && body.charAt(wordIndexEnd) <= 'z')) {
					pi.baseScore++;
				}
			}
			//정보 저장
			pageMap.put(pageName, pi);
		}
		
		for(String key : pageMap.keySet()) {	//각 웹페이지에 대해
        	PageInfo pit = pageMap.get(key);
        	for(String url : pit.links) {		//외부링크에
        		if(pageMap.containsKey(url) && !key.equals(url)) {	//해당 외부링크의 웹페이지가 존재하면
        			pageMap.get(url).linkScore += pit.baseScore / pit.links.size();	//링크점수를 더해준다.
        		}
        	}
        }
		
		//매칭점수 순으로 정렬할 우선순위 큐
		PriorityQueue<PageInfo> pq = new PriorityQueue<>((a, b) -> {
        	int diff = -Double.compare(a.matchingScore, b.matchingScore);
        	if(diff == 0) {
        		return a.index - b.index;	//매칭점수가 같다면 인덱스 오름차순으로 정렬
        	}
        	return diff;
        });
        
        for(String key : pageMap.keySet()) {
        	PageInfo pit = pageMap.get(key);
        	pit.matchingScore = pit.baseScore + pit.linkScore;	//각 웹페이지의 매칭점수 계산
        	System.out.println(pit.index + " | " + pit.baseScore + " | " + pit.linkScore + " | " + pit.matchingScore);
        	pq.add(pit);	//정렬
        }
        
        return answer = pq.peek().index;	//맨 앞의 인덱스가 가장 높은 매칭점수 인덱스
	}
}
