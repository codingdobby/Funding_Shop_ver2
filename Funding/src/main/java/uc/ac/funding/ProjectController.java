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

import uc.ac.db.CatDAO;
import uc.ac.db.ProjectDAO;
import uc.ac.service.ProjectService;
import uc.ac.vo.CatVO;
import uc.ac.vo.NoticeVO;
import uc.ac.vo.ProdVO;
import uc.ac.vo.ProjectVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProjectController {

	@Autowired
	private CatDAO catDAO;

	@Autowired
	private ProjectService ProService;

	private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/project")
	public String Project(HttpServletRequest request, Model model) {// id,pwd확인
		/*
		 * ArrayList<CatVO> CatList = catDAO.getCat(); model.addAttribute("CatList",
		 * CatList);
		 */

		List<ProjectVO> boardBotari = ProService.getAll();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/ProjectMain";
	}

	@RequestMapping("/NewProject")
	public String NewProject(HttpServletRequest request, Model model) {// id,pwd확인
		
		List<ProjectVO> boardBotari = ProService.getNewProject();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/NewProjectMain";
	}
	
	@RequestMapping("/PopularProject")
	public String PopularProject(HttpServletRequest request, Model model) {// id,pwd확인
	
		List<ProjectVO> boardBotari = ProService.getPopularProject();

		model.addAttribute("projectBotari", boardBotari);

		return "/Project/PopularProject";
	}
	
	
	@RequestMapping("/fundDetail")
	public String Project_main(HttpServletRequest request, Model model) {// id,pwd확인

		int pnum = Integer.parseInt(request.getParameter("pnum"));

		List<ProjectVO> vo = ProService.getContent(pnum);// board테이블에서 no값 primary key로 해서 가져오기
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

		List<ProdVO> count = ProService.getProd(pnum);
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
	public String searchPage(HttpServletRequest request, Model model) {// id,pwd확인

		String ptitle = request.getParameter("search");
		ProjectVO vo = null;
		
		List<ProjectVO> search = ProService.search(ptitle);
		if(search==null) {
			model.addAttribute("search",null);
			
		}else {
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
	public String addCart(HttpServletRequest request, Model model) {// id,pwd확인
		HttpSession session = request.getSession();
		String id_fk = (String) session.getAttribute("id");
		int ProdNum_fk = Integer.parseInt(request.getParameter("prodNum_fk"));

		int Project_Num_fk = Integer.parseInt(request.getParameter("project_num_fk"));

		ProService.addCart(id_fk, Project_Num_fk, ProdNum_fk);
		// 물건 갯수 줄이기
		ProService.minusProduct(ProdNum_fk);

		// 가격 더하기
		ProService.plusMoney(Project_Num_fk);

		return "redirect:mycart";
	}

}
