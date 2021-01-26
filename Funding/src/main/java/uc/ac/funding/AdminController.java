package uc.ac.funding;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import uc.ac.db.MemberDAO;
import uc.ac.db.UploadDAO;
import uc.ac.service.MemberService;
import uc.ac.service.ProjectService;
import uc.ac.service.UploadService;
import uc.ac.vo.MemberVO;
import uc.ac.vo.UploadVO;

@Controller
public class AdminController {
	@Autowired
	private UploadService uploadService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private ProjectService projectService;

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("/Admin")
	public String Admin(Model model) {

		List<MemberVO> memberList = memberService.getAll();

		model.addAttribute("MemberList", memberList);

		return "/Admin/adminMain";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");

		memberService.delete(id);

		return "redirect:Admin";
	}

	@RequestMapping("/AdminProject")
	public String AdminProject(Model model) {

		List<UploadVO> ProjectBotari = uploadService.projectALL();

		model.addAttribute("ProjectList", ProjectBotari);

		return "Admin/AdminProject";
	}

	// 관리자가 승인하는 기능
	@RequestMapping("/admit")
	public String admit(HttpServletRequest request) {

		String project_num = request.getParameter("pnum");

		projectService.admit(project_num);

		return "redirect:AdminProject";
	}

}
