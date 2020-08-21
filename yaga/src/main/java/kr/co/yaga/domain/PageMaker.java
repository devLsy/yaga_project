package kr.co.yaga.domain;

import lombok.ToString;
import lombok.extern.log4j.Log4j;

@ToString
@Log4j
public class PageMaker {

	private int totalCnt;				// 전체 게시글 수
	private int startPage;			// 시작 번호
	private int endPage;			// 종료 번호
	private boolean prev, next;	// 이전, 다음
		
	private int displayPageNum = 10;		// 화면 하단에 보여지는 페이지 버튼의 수
	
	private Criteria criteria;		// 페이지 번호, 한 페이지 보여줄 게시글 갯수
	
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		log.info("total: " + totalCnt);
		// 전체 게시글 갯수 설정 시점에 데이터들 계산
		calcDate();	
	}
	
	// 페이지 계산식	
	private void calcDate() {
//	한페이지에 보여줄 페이지가 10이라는 전제
	endPage = (int) (Math.ceil(criteria.getPage() / (double)displayPageNum) * displayPageNum);
	startPage = (endPage - displayPageNum) + 1;
	log.info("endPage: " + endPage);
	log.info("startPage: " + startPage);	
	
	int tempEndPage = (int) Math.ceil(totalCnt / (double)criteria.getPerPageNum());
	log.info("tempEndPage: " + tempEndPage);
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
			
		// 시작페이지가 1이 아니면 prev 활성화
		if(startPage != 1) { prev = true; }
		// 종료 페이지 * 표시될 목록 게시글 수가 전체 게시글수보다 크거나 같지 않으면 next 활성화  
		next = endPage * criteria.getPerPageNum() >= totalCnt ? false : true;
	}
	
	// url parameter에 page, perPageNum 추가(우선 기능 구현 다 하고 나중에 리팩토링)
//	public String makeQuery(int page) {
//		UriComponents uriComponents = UriComponentsBuilder.newInstance()
//									.queryParam("page", page)
//									.queryParam("perPageNum", criteria.getPerPageNum())
//									.build();
//		return uriComponents.toUriString();
//	}
		
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}
		
	public Criteria getCriteria() {
		return criteria;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCnt() {
		return totalCnt;
	}
	
}
