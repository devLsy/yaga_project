package kr.co.yaga.domain;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter	
public class Criteria {

	private int page;								 // 현재 페이지 번호
	private int perPageNum;					// 한 페이지에 보여줄 게시글 수
	
	private String type;							// 검색에 사용할 변수(타입)
	private String keyword;						// 검색에 사용할 변수(키워드)
	// 기본 생성자에서 페이지 번호, 페이지 보여줄 게시글 수 초기화
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		this.perPageNum = perPageNum;
	}
	
	// 검색조건이 (T,W,C)로 구성되어 있어서 배열로 한번에 처리하기 위함(mybatis로 넘길 paramerter값)
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	// spring의 UriComponentsBuilder 이용해서 parameter들을 연결해 url 형태로 가공
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("page", this.page)
				.queryParam("PerPageNum", this.getPerPageNum())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		
		return builder.toUriString();
	}
	
	// 페이지가 음수가 나오면 1로 고정
	public void setPage(int page) {
	    if(page <= 0) { this.page = 1; return;}
	    this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	// 페이지당 출력되는 게시글수가 음수 혹은 100을 넘어가면 10으로 고정
	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	// 시작 페이지
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
}