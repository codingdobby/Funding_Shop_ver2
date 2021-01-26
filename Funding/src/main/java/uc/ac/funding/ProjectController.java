package uc.ac.funding;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uc.ac.db.CategoryDAO;
import uc.ac.db.ProjectDAO;
import uc.ac.service.ProjectService;
import uc.ac.vo.CategoryVO;
import uc.ac.vo.NoticeVO;
import uc.ac.vo.ProductVO;
import uc.ac.vo.ProjectVO;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService ProService;

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@RequestMapping("/project")
	public String Project(Model model) {

		List<ProjectVO> boardBotari = ProService.getAll();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/ProjectMain";
	}

	@RequestMapping("/NewProject")
	public String NewProject(Model model) {

		List<ProjectVO> boardBotari = ProService.getNewProject();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/NewProjectMain";
	}

	@RequestMapping("/PopularProject")
	public String PopularProject(Model model) {

		List<ProjectVO> boardBotari = ProService.getPopularProject();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/PopularProject";
	}

	@RequestMapping("/fundDetail")
	public String Project_main(HttpServletRequest request, Model model) {

		int pnum = Integer.parseInt(request.getParameter("pnum"));

		List<ProjectVO> vo = ProService.getContent(pnum);
		ProjectVO result = null;
		for (int i = 0; i < vo.size(); i++) {

			result = new ProjectVO();
			result.setPtitle(vo.get(i).getPtitle());
			result.setPpic1(vo.get(i).getPpic1());
			result.setNickname(vo.get(i).getNickname());
			result.setPmoney(vo.get(i).getPmoney());
			result.setTotMoney(vo.get(i).getTotMoney());
			result.setPdate(vo.get(i).getPdate());
			result.setProject_num(vo.get(i).getProject_num());
			result.setPcontent(vo.get(i).getPcontent());

		}

		ProService.phitUpdate(pnum);

		List<ProductVO> count = ProService.getProd(pnum);
		ProjectVO countRes = null;

		for (int i = 0; i < vo.size(); i++) {

			countRes = new ProjectVO();
			countRes.setProdCount(count.get(i).getProdCount());

		}

		model.addAttribute("result", result);
		model.addAttribute("countRes", countRes);

		return "/Project/ProjectContent";
	}

	@RequestMapping("/searchPage")
	public String searchPage(HttpServletRequest request, Model model) {

		String ptitle = request.getParameter("search");
		ProjectVO vo = null;

		List<ProjectVO> search = ProService.search(ptitle);
		if (search == null) {
			model.addAttribute("search", null);

		} else {
			for (int list = 0; list < search.size(); list++) {
				vo = new ProjectVO();
				vo.setPtitle(search.get(list).getPtitle());
				vo.setProject_num(search.get(list).getProject_num());
				vo.setPpic1(search.get(list).getPpic1());
				vo.setPdate(search.get(list).getPdate());

			}

			model.addAttribute("search", vo);
		}
		return "/Search/searchOK";

	}

	@RequestMapping("/addCart")
	public String addCart(HttpServletRequest request, Model model) {// id,pwd�솗�씤
		HttpSession session = request.getSession();
		String id_fk = (String) session.getAttribute("id");
		int ProdNum_fk = Integer.parseInt(request.getParameter("prodNum_fk"));

		int Project_Num_fk = Integer.parseInt(request.getParameter("project_num_fk"));

		ProService.addCart(id_fk, Project_Num_fk, ProdNum_fk);

		ProService.minusProduct(ProdNum_fk);

		ProService.plusMoney(Project_Num_fk);

		return "redirect:mycart";
	}
	
	//댓글 등록
	@ResponseBody
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public void addComment(HttpServletRequest request) {
		String str1  = request.getParameter("values");
		
	}
	
	

}
