package uc.ac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uc.ac.db.MemberDAO;
import uc.ac.vo.CartVO;
import uc.ac.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDAO;

	@Override
	public void join(MemberVO vo) {
		memberDAO.join(vo);

	}

	@Override
	public MemberVO checkMember(String id, String pwd) {

		return memberDAO.checkMember(id, pwd);
	}

	@Override
	public boolean loginCheck(String id, String pwd) {
		return memberDAO.loginCheck(id, pwd);
	}

	@Override
	public List<MemberVO> getAll() {
		return memberDAO.getAll();
		
	}

	@Override
	public List<MemberVO> getVerify() {
		return memberDAO.getVerify();
	}

	@Override
	public void delete(String id) {
		memberDAO.delete(id);

	}

	@Override
	public String checkID(String checkId) {
		return memberDAO.checkID(checkId);
	
	}

	@Override
	public void updateInfo(String nickname, String pwd, String phone, String address, String id) {
		memberDAO.updateInfo(nickname, pwd, phone, address, id);

	}

	@Override
	public void updatePwd(String pwd, String checkId) {
		memberDAO.updatePwd(pwd, checkId);

	}

	@Override
	public List<CartVO> getCart(String id_fk) {
		
		return memberDAO.getCart(id_fk);
	}

}
