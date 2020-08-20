package kr.co.yaga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.yaga.domain.BoardVO;
import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.PageMaker;
import kr.co.yaga.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller	
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor	
public class BoardController {
	
	private BoardService service;
	
	// 야가 소개 페이지
	@RequestMapping("/introduction")
	public String introduction() {	
		log.info("introduction Request~!");
		return "/board/introduction";
	}
	
	// 예약 입력 폼 처리
	@GetMapping("/reserve")
	public void reserve() {
		log.info("Request reserveForm~!");
	}
	
	// 문의 게시판 게시글 리스트(with 페이지네이션)
	@GetMapping("/list")
	public void list(Model model, Criteria criteria) throws Exception {
		log.info("list: " + criteria);	
		model.addAttribute("list", service.getListWithPaging(criteria));
		// 페이지네이션 계산 하는 객체
		PageMaker pageMaker = new PageMaker();	
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCnt(service.getTotal(criteria));
		
		log.info("total: " + service.getTotal(criteria));
		model.addAttribute("pageMaker", pageMaker);		
		
	}		
		
	// 게시글 등록 처리
	@PostMapping("/register")
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
		
		log.info("register: " + boardVO.toString());
		service.register(boardVO);
		log.info("bno: " + boardVO.getBno());
		// 1회성 데이터 전달(게시글 등록 시 bno를 전달 해 모달창 표시)
		rttr.addFlashAttribute("result", boardVO.getBno());
		return "redirect:/board/list";
	}
	
	// 게시글 입력 폼 처리
	@GetMapping("/register")
	public void register() {
		log.info("register Form~!");
	}
	
	// 게시글 상세 조회
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") int bno, Model model, @ModelAttribute("criteria")Criteria criteria) {
		log.info("get or modify");
		log.info("criteria: " + criteria);
		model.addAttribute("board", service.get(bno));
	}	
	
	// 게시글 수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO boardVO, RedirectAttributes rttr, @ModelAttribute("criteria") Criteria criteria) {
		log.info("modify: " + boardVO);		
		// 화면에서 넘어온 pageNum, perPageNum 잘 찍힘
		log.info("criteria: " + criteria);
				
		if(service.modify(boardVO)) {	
			log.info("service.modify request~!!");
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list" + criteria.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr, @ModelAttribute("criteria") Criteria criteria) {
		log.info("remove~!!" + bno);	
		log.info("criteria: " + criteria);
		
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list" + criteria.getListLink();	
	}	
	
		
}
