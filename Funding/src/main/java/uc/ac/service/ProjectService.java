package uc.ac.service;


import java.util.List;

import uc.ac.vo.ProductVO;
import uc.ac.vo.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> getAll();
	public List<ProjectVO> getContent(int pnum);
	public List<ProjectVO> getNewProject();
	public List<ProjectVO> getPopularProject();

	/**************************************************/
	public List<ProductVO> getProd(int pnum);

	/************ 프로젝트 조회수+1 *****************/

	public void phitUpdate(int pnum);

	/********* 인기있는 상품 4개 가져오기 ****************************/

	public List<ProjectVO> getHitItem();

	/******** 신상 4개 가져오기 ****************************/

	public List<ProjectVO> getNewItem();

	/************ 프로젝트 장바구니 추가 *****************/

	public void addCart(int id_fk, int project_num_fk, int prodNum_fk);

	/************ 프로젝트 장바구니 갯수 줄이기 *****************/

	public void minusProduct(int prodNum);
	/************ 프로젝트 장바구니 갯수 줄이기 *****************/

	public void plusMoney(int projectNum);
	/************ 프로젝트 검색 *****************/
	 public List<ProjectVO> search(String ptitle);

	 public void admit(String project_num);
}
