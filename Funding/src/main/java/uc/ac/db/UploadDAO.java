package uc.ac.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import uc.ac.vo.ProdVO;
import uc.ac.vo.ProjectVO;
import uc.ac.vo.RewardVO;
import uc.ac.vo.UploadVO;

@Component
public class UploadDAO {
	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.Upload.xml";

	/****************** 관리자용 프로젝트 전체보기 **************************************/
	public List<UploadVO> projectALL() {//
		return SqlSession.selectList(namespace + ".projectAll");
	}

	public List<UploadVO> getAll(String id_fk) {//
		System.out.println(id_fk);
		return SqlSession.selectList(namespace + ".getAll", id_fk);
	}

	/************************
	 * 관리자 승인 기능
	 **************************************************/

	public void admit(String pnum) {
		SqlSession.update(namespace + ".admit", pnum);

	}

	/**************************************************************************/


	///////////////////////////////////////////////////////////////////////////////
	/*************************
	 * 상품 넣기
	 *****************************************************/
	public void insertproj(UploadVO vo) {
		ArrayList<UploadVO> data = new ArrayList<UploadVO>();

		data.add(vo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", data);

		SqlSession.insert(namespace + ".insertProj", map);

	}

	public void insertRew(RewardVO vo) {
		
		ArrayList<RewardVO> data = new ArrayList<RewardVO>();

		data.add(vo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("reward", data);


		SqlSession.insert(namespace + ".insertRew",map);

	}
	
	public int getProject_num_fk(String ptitle) {
		System.out.println(ptitle);
		return SqlSession.selectOne(namespace+".getProject_num_fk",ptitle);
	}

	/***********************
	 * fk에 넣을 기본키 가져오기
	 ***************************************************/

	public UploadVO getPnum(String id_fk) {
		return null;

	}

	public ProdVO getRewId(String pwriter) {

	}

	/***********************
	 * fk에 넣을 기본키 가져오기
	 ***************************************************/

	/*************************
	 * 프로젝트 정보
	 *****************************************************/
	public void insertinfo(int pnum, String id_fk, int reward) {

	}

	/*************************
	 * 프로젝트 정보 end
	 *****************************************************/

	public UploadVO getProject_fk(String ptitle, String id) {

		return vo;

	}

	

}
