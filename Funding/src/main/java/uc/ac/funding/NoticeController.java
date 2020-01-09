package uc.ac.funding;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pageing.Pagination;
import uc.ac.service.BoardServiceImp;
import uc.ac.service.NoticeService;
import uc.ac.service.NoticeServiceImp;
import uc.ac.vo.NoticeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class NoticeController {

	@Autowired
	private NoticeService service;

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@RequestMapping("/notice")
	public String notice(HttpServletRequest request, Model model, @RequestParam("num") int num) throws Exception {// id,pwd확인

		/* List<NoticeVO> boardBotari = service.getAll(); */

		int count = service.cnt();
		System.out.println("count : " + count);
		// 한 페이지에 출력할 게시물 갯수
		int postNum = 10;

		int pageNum = (int) Math.ceil((double) count / postNum);
		int displayPost = (num - 1) * postNum;// 출력할 게시물

		// 한번에 표시할 페이징 번호의 갯수
		int pageNum_cnt = 10;

		// 표시되는 페이지 번호 중 마지막 번호
		int endPageNum = (int) (Math.ceil((double) num / (double) pageNum_cnt) * pageNum_cnt);
		System.out.println("end Page" + endPageNum);
		// 표시되는 페이지 번호 중 첫번째 번호
		int startPageNum = endPageNum - (pageNum_cnt - 1);
		System.out.println("startPageNum" + startPageNum);
		// 마지막 번호 재계산
		int endPageNum_tmp = (int) (Math.ceil((double) count / (double) pageNum_cnt));
		// 마지막 페이지 번호 = > (현재 페이지 번호/한번에 표시할 페이지 번호의 갯수)* 한번에 표시할 페이지 번호 갯수
		if (endPageNum > endPageNum_tmp) {
			endPageNum = endPageNum_tmp;
		}

		// 앞 뒤
		boolean prev = startPageNum == 1 ? false : true;
		boolean next = endPageNum * pageNum_cnt >= count ? false : true;

		List<NoticeVO> list = null;
		list = service.listPage(displayPost, postNum);

		// 시작 및 끝 번호
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);

		model.addAttribute("pageNum", pageNum);
		model.addAttribute("list", list);

		model.addAttribute("prev", prev);
		model.addAttribute("next", next);

		model.addAttribute("select", num);

		/* model.addAttribute("boardList", boardBotari); */

		return "/Notice/NoticeList";
	}

	@RequestMapping("/listContent.do") // 상세내용
	public String listContent(HttpServletRequest request, Model model) throws Exception {// id,pwd확인

		int no = Integer.parseInt(request.getParameter("no"));
		NoticeVO vo = service.getContent(no);// board테이블에서 no값 primary key로 해서 가져오기
		service.hitUpdate(no);
		model.addAttribute("vo", vo);

		return "/Notice/NoticeContent";
	}

	@RequestMapping("/go_noticeWrite.do") // 글쓰기 이동
	public String go_noticeWrite(HttpServletRequest request) {// id,pwd확인

		return "/Notice/NoticeWrite";
	}

	@RequestMapping("noticeOK.do") // 글쓰기 기능
	public String noticeOK(HttpServletRequest request, Model model) {// id,pwd확인

		HttpSession session = request.getSession();

		String nTitle = request.getParameter("nTitle");
		String nContent = request.getParameter("nContent");
		String nWriter = (String) session.getAttribute("name");

		service.noticeInsert(nTitle, nContent, nWriter);// DB에 입력받은 회원정보(vo)를 저장

		return "redirect:notice?num=1";
	}

	@RequestMapping("notice_delete.do") // 글삭제
	public String notice_delete(HttpServletRequest request, Model model ,@RequestParam(value="num") int num) {// id,pwd확인

		
		System.out.println("글번호 체크 : " + num);
		service.noticeDelete(num);

		return "redirect:notice?num=1";
	}
}
