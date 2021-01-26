package uc.ac.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

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

		return SqlSession.selectList(namespace + ".getAll", id_fk);
	}

	/******** 상품 넣기	 *****************************************************/
	public void insertProject(UploadVO vo) {
		ArrayList<UploadVO> data = new ArrayList<UploadVO>();

		data.add(vo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", data);

		SqlSession.insert(namespace + ".insertProject", map);

	}

	public void insertReward(RewardVO vo) {

		ArrayList<RewardVO> data = new ArrayList<RewardVO>();

		data.add(vo);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("reward", data);

		SqlSession.insert(namespace + ".insertReward", map);

	}

	public int getProject_num_fk(String ptitle) {
		System.out.println(ptitle);
		return SqlSession.selectOne(namespace + ".getProject_num_fk", ptitle);
	}

}
