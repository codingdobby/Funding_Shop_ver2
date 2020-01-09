package uc.ac.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uc.ac.vo.ProdVO;
import uc.ac.vo.ProjectVO;

@Component
public class ProjectDAO {

	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.project.xml";

	public List<ProjectVO> getAll() {
		return SqlSession.selectList(namespace + ".getAll");
	}

	public List<ProjectVO> getContent(int pnum) {
		return SqlSession.selectList(namespace + ".getContent", pnum);

	}

	public List<ProjectVO> getNewProject() {
		return SqlSession.selectList(namespace + ".getNewProject");

	}

	public List<ProjectVO> getPopularProject() {
		return SqlSession.selectList(namespace + ".getPopularProject");

	}
	/**************************************************/
	public List<ProdVO> getProd(int pnum) {
		return SqlSession.selectList(namespace + ".getProd", pnum);

	}

	/************ 프로젝트 조회수+1 *****************/

	public void phitUpdate(int pnum) {

		SqlSession.update(namespace + ".phitUpdate", pnum);
	}

	/********* 인기있는 상품 4개 가져오기 ****************************/

	public List<ProjectVO> getHitItem() {
		return SqlSession.selectList(namespace + ".getHitItem");
	}

	/******** 신상 4개 가져오기 ****************************/

	public List<ProjectVO> getNewItem() {// namecard table에 있는 모든 레코드를 넘겨줌
		return SqlSession.selectList(namespace + ".getNewItem");
	}

	/************ 프로젝트 장바구니 추가 *****************/

	public void addCart(int id_fk, int project_num_fk, int prodNum_fk) {
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("id_fk", id_fk);
		data.put("project_num_fk", project_num_fk);
		data.put("prodNum_fk", prodNum_fk);

		SqlSession.insert(namespace + ".addCart", data);
	}

	/************ 프로젝트 장바구니 갯수 줄이기 *****************/

	public void minusProduct(int prodNum) {
		SqlSession.update(namespace + ".minusProduct", prodNum);
	}

	/************ 프로젝트 장바구니 갯수 줄이기 *****************/

	public void plusMoney(int projectNum) {
		SqlSession.update(namespace + ".plusMoney", projectNum);
	}

	/************ 프로젝트 검색 *****************/
	public List<ProjectVO> search(String ptitle) {// namecard table에 모든 레코드를 넘겨줌
		return SqlSession.selectList(namespace + ".search", ptitle);
	}

}
