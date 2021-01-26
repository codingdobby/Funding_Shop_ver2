package uc.ac.funding;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import uc.ac.db.MemberDAO;
import uc.ac.db.ProjectDAO;
import uc.ac.db.UploadDAO;
import uc.ac.service.UploadService;
import uc.ac.vo.MemberVO;
import uc.ac.vo.PhotoVO;
import uc.ac.vo.ProductVO;
import uc.ac.vo.ProjectVO;
import uc.ac.vo.RewardVO;
import uc.ac.vo.UploadVO;

/**
 * Handles requests for the application home page.
 */

@Controller
public class UploadController {
	@Autowired
	private UploadService service;

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping("/upload")
	public String UploadMain(HttpServletRequest request, Model model) {// id,pwd확인

		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		List<UploadVO> boardBotari = service.getAll(id);

		model.addAttribute("boardList", boardBotari);

		return "/Upload/UploadList";
	}

	@RequestMapping("/go_insertProduct")
	public String go_insertProduct(HttpServletRequest request, Model model) {// id,pwd확인

		return "/Upload/UploadMain";
	}

	@RequestMapping("/insertProduct")
	public String insertProduct(HttpServletRequest request, @RequestParam("ppic1") MultipartFile ppic1, Model model) {// id,pwd확인

		String pTitle = request.getParameter("ptitle");
		String pContent = request.getParameter("pcontent");
		String pDate = request.getParameter("pdate");
		String pCategory = request.getParameter("pcategory");

		int totalMoney = Integer.parseInt(request.getParameter("totMoney"));

		HttpSession session = request.getSession();
		String id_fk = (String) session.getAttribute("id");

		/**********************************************************/

		String savePath = "E:\\portfolio\\Funding\\src\\main\\webapp\\resources\\photoUpload";

		String originalFilename = ppic1.getOriginalFilename(); // fileName.jpg
		String onlyFileName = originalFilename.substring(0, originalFilename.indexOf("."));
		// fileName String extension =
		originalFilename.substring(originalFilename.indexOf(".")); // .jpg

		String rename = originalFilename; // fileName_20150721-14-07-50.jpg
		String fullPath = savePath + "\\" + rename;

		if (!ppic1.isEmpty()) {
			try {
				byte[] bytes = ppic1.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fullPath)));
				stream.write(bytes);
				stream.close();
				System.out.println("성공");
				model.addAttribute("resultMsg", "파일을 업로드 성공!");
				System.out.println("성공");
			} catch (Exception e) {

				model.addAttribute("resultMsg", "파일을 업로드하는 데에 실패했습니다.");
				System.out.println("실패");
			}
		} else {
			model.addAttribute("resultMsg", "업로드할 파일을 선택해주시기 바랍니다.");
		}

		/**********************************************************/
		UploadVO vo = new UploadVO();
		vo.setPtitle(pTitle);
		vo.setPcontent(pContent);
		vo.setTotMoney(totalMoney);
		vo.setId_fk(id_fk);
		vo.setPdate(pDate);
		vo.setPpic1(originalFilename);
		vo.setpDetail_img(originalFilename);
		vo.setpCategory(pCategory);

		// 프로젝트 정보 저장
		service.insertProject(vo);

		session.setAttribute("ptitle", pTitle);

		return "Upload/UploadProduct";
	}

	@RequestMapping("/insert_OK")
	public String insert_OK(HttpServletRequest request, Model model) {// id,pwd확인
		HttpSession session = request.getSession();
		String ptitle = (String) session.getAttribute("ptitle");

		int project_num_fk = service.getProject_num_fk(ptitle);

		String productName = request.getParameter("prodName");
		int productPrice = Integer.parseInt(request.getParameter("prodPrice"));
		int productCount = Integer.parseInt(request.getParameter("prodCount"));
		// 상품 저장
		RewardVO vo = new RewardVO();
		vo.setProdName(productName);
		vo.setProdCount(productCount);
		vo.setProdPrice(productPrice);
		vo.setProject_num_fk(project_num_fk);

		service.insertReward(vo);

		return "redirect:upload";
	}

}
