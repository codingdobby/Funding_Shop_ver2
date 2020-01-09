package uc.ac.service;

import java.util.List;

import uc.ac.vo.CartVO;
import uc.ac.vo.MemberVO;

public interface MemberService {
	// 회원가입
	public void join(MemberVO vo);

	public MemberVO checkMember(String id, String pwd);

	/************** 회원인지 확인 *******************************************************/
	public boolean loginCheck(String id, String pwd);

	// 회원 목록 가져오기
	public List<MemberVO> getAll();

	/**************
	 * verify값 가져오기
	 *****************/
	public List<MemberVO> getVerify();

	/******************* 삭제 *******************************/

	public void delete(String id);

	/************** 비밀번호 관련 기능 **************************************/

	public String checkID(String checkid);

	/********************* 마이페이지에서 값 수정 ****************************/
	public void updateInfo(String nickname, String pwd, String phone, String address, String id);

	/********************* 비밀번호 재설정 ****************************/

	public void updatePwd(String pwd, String checkid);

	public List<CartVO> getCart(String id_fk);

}
