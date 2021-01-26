package uc.ac.funding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uc.ac.service.CategoryService;
import uc.ac.service.MemberService;
import uc.ac.service.ProjectService;
import uc.ac.vo.CategoryVO;
import uc.ac.vo.MemberVO;
import uc.ac.vo.ProjectVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private MemberService service;

	@Autowired
	private ProjectService ProjectService;

	@Autowired
	private CategoryService categoryService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model) {// id,pwd�솗�씤

		List<MemberVO> verifyBotari = service.getVerify();
		model.addAttribute("verifyBotari", verifyBotari);

		/************* 최다 조회 상품 ******************************/

		List<ProjectVO> hitBotari = ProjectService.getHitItem();
		model.addAttribute("hitBotari", hitBotari);

		/************* 신규 아이템 ******************************/

		List<ProjectVO> newBotari = ProjectService.getNewItem();
		model.addAttribute("newBotari", newBotari);

		if (verifyBotari.isEmpty() || hitBotari.isEmpty() || newBotari.isEmpty()) {
			return "/FirstPage/main_ready";
		} else {
			return "/FirstPage/main";
		}
	}

	// 페이지 이동해도 카테고리 보여주기 ajax통신
	@ResponseBody
	@RequestMapping(value = "/nav", method = RequestMethod.POST)
	public Map<String, List> nav() {

		List<CategoryVO> category = categoryService.getCategory();
		Map<String, List> map = new HashMap<String, List>();

		map.put("category", category);

		return map;

	}

	@RequestMapping("/main.do")
	public String main(HttpServletRequest request, Model model) {// id,pwd�솗�씤

		List<MemberVO> verifyBotari = service.getVerify();
		model.addAttribute("verifyBotari", verifyBotari);

		/************* 최다 조회 상품 ******************************/

		List<ProjectVO> hitBotari = ProjectService.getHitItem();
		model.addAttribute("hitBotari", hitBotari);

		/************* 신규 아이템 ******************************/

		List<ProjectVO> newBotari = ProjectService.getNewItem();
		model.addAttribute("newBotari", newBotari);

		if (verifyBotari.isEmpty() || hitBotari.isEmpty() || newBotari.isEmpty()) {
			return "/FirstPage/main_ready";
		} else {
			return "/FirstPage/main";
		}

	}

	/*********** 濡쒓렇�씤 湲곕뒫 ******************************/
	// 濡쒓렇�씤 �럹�씠吏�濡� �씠�룞
	@RequestMapping("/go_login.do")
	public String go_login(HttpServletRequest request) {// id,pwd�솗�씤

		return "/Login/login";
	}

	// 濡쒓렇�씤 �븯�뒗 湲곕뒫
	@RequestMapping("/loginOK.do")
	public String loginOK(HttpServletRequest request, Model model) {// id,pwd�솗�씤

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberVO find = service.checkMember(id, pwd);

		if (find != null) {// �쉶�썝
			System.out.println(find.getNickname() + "회원님^^");

			// 濡쒓렇�씤 �꽦怨듭떆 session媛앹껜�뿉 �꽦怨듯븳 �궗�엺�쓽 �씠由꾩쓣 name蹂��닔�뿉 ���옣

			HttpSession session = request.getSession();
			session.setAttribute("name", find.getNickname());
			session.setAttribute("id", find.getId());
			session.setAttribute("phone", find.getPhone());
			session.setAttribute("address", find.getAddress());
			session.setAttribute("verify", find.getVerify());

			List<MemberVO> verifyBotari = service.getVerify();
			model.addAttribute("verifyBotari", verifyBotari);

			// response.sendRedirect("main.jsp");
		} else {
			System.out.println("비회원");
			// response.sendRedirect("memberJoin.jsp");

		}
		// return "FirstPage/main";
		return "redirect:main.do";
	}

	// 濡쒓렇�븘�썐
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {// id,pwd�솗�씤
		return "/Login/logout";
	}

	/*********************** �쉶�썝媛��엯 湲곕뒫 ******************/
	// �룞�쓽 �럹�씠吏�濡� �씠�룞
	@RequestMapping("/agree.do")
	public String MemJoin(HttpServletRequest request) {// id,pwd�솗�씤

		return "/Login/agree";
	}

	@RequestMapping("/go_insert.do")
	public String go_insert(HttpServletRequest request) {// id,pwd�솗�씤

		return "/Login/MemJoin";
	}

	// �쉶�썝媛��엯 �젙蹂� �엯�젰
	@RequestMapping("/loginInsert.do")
	public String loginInsert(HttpServletRequest request) {// id,pwd�솗�씤
		String name = request.getParameter("nickname");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		MemberVO vo = new MemberVO(name, id, pwd, phone, address, 0);
		// memberDAO dao = new memberDAO();
		service.join(vo);// DB�뿉 �엯�젰諛쏆� �쉶�썝�젙蹂�(vo)瑜� ���옣

		return "redirect:main.do";

	}

	/*********************** 鍮꾨�踰덊샇 愿��젴 湲곕뒫 ******************/

	@RequestMapping("/findPwd.do")
	public String findPwd(HttpServletRequest request, Model model) {// id,pwd�솗�씤

		return "/Login/findPwd";
	}

	@RequestMapping(value = "/findPwdTest.do", method = RequestMethod.POST) // �씠�룞
	@ResponseBody
	public String findPwdTest(HttpServletRequest request, Model model, String checkid) {

		if (checkid.equals("")) {
			return "nothing";
		}
		String checkId = service.checkID(checkid);

		if (checkId != null) {// �쉶�썝

			// 濡쒓렇�씤 �꽦怨듭떆 session媛앹껜�뿉 �꽦怨듯븳 �궗�엺�쓽 �씠由꾩쓣 name蹂��닔�뿉 ���옣
			HttpSession session = request.getSession();
			session.setAttribute("checkid", checkid);
			return "success";

		} else {
			return "fail";

		}

	}

	@RequestMapping("/findPwd2.do") // �씠�룞
	public String findPwd2() {

		return "/Login/findPwd2";
	}

	@RequestMapping("/update_pwd.do")
	public String update_pwd(HttpServletRequest request) {// id,pwd�솗�씤
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);

		HttpSession session = request.getSession();
		String checkid = (String) session.getAttribute("checkid");
		System.out.println(checkid);

		service.updatePwd(pwd, checkid);

		return "redirect:main.do";
	}

}
