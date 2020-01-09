package uc.ac.funding;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.annotation.WebFilter;
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

import net.sf.json.JSONArray;
import uc.ac.db.MemberDAO;
import uc.ac.db.ProjectDAO;
import uc.ac.service.CatService;
import uc.ac.service.MemberService;
import uc.ac.service.ProjectService;
import uc.ac.vo.CatVO;
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
	private ProjectService ProService;

	@Autowired
	private CatService CatService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping("/")
	public String home(HttpServletRequest request, Model model) {// id,pwd확인

		List<MemberVO> verifyBotari = service.getVerify();
		model.addAttribute("verifyBotari", verifyBotari);

		/************* 인기 있는 상품 가져오기 ******************************/

		List<ProjectVO> hitBotari = ProService.getHitItem();
		model.addAttribute("hitBotari", hitBotari);

		/************* 새상품 가져오기 ******************************/

		List<ProjectVO> newBotari = ProService.getNewItem();
		model.addAttribute("newBotari", newBotari);

		return "/FirstPage/main";
	}

	@RequestMapping(value = "/nav", method = RequestMethod.POST)
	public void nav(Model model) {// id,pwd확인

		List<CatVO> category = CatService.getCat();
		System.out.println("value : " + category.get(0).getCateName());

		JSONArray jsonArray = new JSONArray();
		model.addAttribute("jsonList", jsonArray.fromObject(category));

	}

	@RequestMapping("/main.do")
	public String main(HttpServletRequest request, Model model) {// id,pwd확인
		List<CatVO> category = CatService.getCat();
		model.addAttribute("category", category);
		List<MemberVO> verifyBotari = service.getVerify();
		model.addAttribute("verifyBotari", verifyBotari);

		/************* 인기 있는 상품 가져오기 ******************************/

		List<ProjectVO> hitBotari = ProService.getHitItem();
		model.addAttribute("hitBotari", hitBotari);

		/************* 새상품 가져오기 ******************************/

		List<ProjectVO> newBotari = ProService.getNewItem();
		model.addAttribute("newBotari", newBotari);

		return "/FirstPage/main";
	}

	/*********** 로그인 기능 ******************************/
	// 로그인 페이지로 이동
	@RequestMapping("/go_login.do")
	public String go_login(HttpServletRequest request) {// id,pwd확인

		return "/Login/login";
	}

	// 로그인 하는 기능
	@RequestMapping("/loginOK.do")
	public String loginOK(HttpServletRequest request, Model model) {// id,pwd확인

		String id = request.getParameter("id");// 아이디 값 가져오기
		String pwd = request.getParameter("pwd");// 비밀번호 값 가져오기

		MemberVO find = service.checkMember(id, pwd);

		if (find != null) {// 회원
			System.out.println(find.getNickname() + "회원^^");

			// 로그인 성공시 session객체에 성공한 사람의 이름을 name변수에 저장

			HttpSession session = request.getSession();
			session.setAttribute("name", find.getNickname());
			session.setAttribute("id", find.getId());
			session.setAttribute("phone", find.getPhone());
			session.setAttribute("address", find.getAddress());
			session.setAttribute("verify", find.getVerify());

			List<MemberVO> verifyBotari = service.getVerify();
			model.addAttribute("verifyBotari", verifyBotari);

			// response.sendRedirect("main.jsp");
		} else {// 비회원
			System.out.println("비회원");
			// response.sendRedirect("memberJoin.jsp");

		}
		// return "FirstPage/main";
		return "redirect:main.do";
	}

	// 로그아웃
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) {// id,pwd확인
		return "/Login/logout";
	}

	/*********************** 회원가입 기능 ******************/
	// 동의 페이지로 이동
	@RequestMapping("/agree.do")
	public String MemJoin(HttpServletRequest request) {// id,pwd확인

		return "/Login/agree";
	}

	@RequestMapping("/go_insert.do")
	public String go_insert(HttpServletRequest request) {// id,pwd확인

		return "/Login/MemJoin";
	}

	// 회원가입 정보 입력
	@RequestMapping("/loginInsert.do")
	public String loginInsert(HttpServletRequest request) {// id,pwd확인
		String name = request.getParameter("nickname");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		MemberVO vo = new MemberVO(name, id, pwd, phone, address, 0);
		// memberDAO dao = new memberDAO();
		service.join(vo);// DB에 입력받은 회원정보(vo)를 저장

		return "redirect:main.do";

	}

	/*********************** 비밀번호 관련 기능 ******************/

	@RequestMapping("/findPwd.do")
	public String findPwd(HttpServletRequest request, Model model) {// id,pwd확인

		return "/Login/findPwd";
	}

	@RequestMapping(value = "/findPwdTest.do", method = RequestMethod.POST) // 이동
	@ResponseBody
	public String findPwdTest(HttpServletRequest request, Model model, String checkid) {

		if (checkid.equals("")) {
			return "nothing";
		}
		String checkId = service.checkID(checkid);

		if (checkId != null) {// 회원

			// 로그인 성공시 session객체에 성공한 사람의 이름을 name변수에 저장
			HttpSession session = request.getSession();
			session.setAttribute("checkid", checkid);
			return "success";

		} else {
			return "fail";

		}

	}

	@RequestMapping("/findPwd2.do") // 이동
	public String findPwd2() {

		return "/Login/findPwd2";
	}

	@RequestMapping("/update_pwd.do")
	public String update_pwd(HttpServletRequest request) {// id,pwd확인
		String pwd = request.getParameter("pwd");
		System.out.println(pwd);

		HttpSession session = request.getSession();
		String checkid = (String) session.getAttribute("checkid");
		System.out.println(checkid);

		service.updatePwd(pwd, checkid);

		return "redirect:main.do";
	}

	public class ErrorHandling {
		String path = "/error";

		@RequestMapping(value = "/404")
		public String error404() {
			return path + "/404";
		}
		
		@RequestMapping(value = "/500")
		public String error500() {
			return path + "/500";
		}
	}

}
