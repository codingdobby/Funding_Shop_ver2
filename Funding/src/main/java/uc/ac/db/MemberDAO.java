package uc.ac.db;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import uc.ac.vo.CartVO;
import uc.ac.vo.MemberVO;

@Component // MemberDAO 클래스로 부터 객체(memberDAO)를 생성해서 빈으로 컨테이너에 등록 시킴
public class MemberDAO {

	@Autowired
	private org.apache.ibatis.session.SqlSession SqlSession;

	String namespace = "mybatis.mybatis-config.xml";

	// 회원가입
	public void join(MemberVO vo) {

		SqlSession.insert(namespace + ".join", vo);
	}

	public MemberVO checkMember(String id, String pwd) {

		HashMap<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		data.put("pwd", pwd);

		return SqlSession.selectOne(namespace + ".checkMember", data);
	}

	/************** 회원인지 확인 *******************************************************/
	public boolean loginCheck(String id, String pwd) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("id", id);
		data.put("pwd", pwd);
		return SqlSession.selectOne(namespace + ".loginCheck", data);

	}

	// 회원 목록 가져오기
	public List<MemberVO> getAll() {
		return SqlSession.selectList(namespace + ".getAll");

	}

	/**************
	 * verify값 가져오기
	 *****************/
	public List<MemberVO> getVerify() {//

		return SqlSession.selectList(namespace + ".getVerify");
	}

	/******************* 삭제 *******************************/

	public void delete(String id) {

		SqlSession.selectList(namespace + ".delete", id);
	}

	/************** 비밀번호 관련 기능 **************************************/

	public String checkID(String checkid) {

		return SqlSession.selectOne(namespace + ".checkID", checkid);
	}

	/********************* 마이페이지에서 값 수정 ****************************/
	public void updateInfo(String nickname, String pwd, String phone, String address, String id) {// 회원1명 DB에 등록

		SqlSession.selectList(namespace + ".list");
	}

	/********************* 비밀번호 재설정 ****************************/

	public void updatePwd(String pwd, String checkid) {//
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("pwd", pwd);
		data.put("checkid", checkid);

		SqlSession.update(namespace + ".updatePwd", data);
	}

//*************************************************************************/
	public List<CartVO> getCart(String id_fk) {// namecard table에 있는 모든 레코드를 넘겨줌
		return SqlSession.selectList(namespace + ".list");
	}

}
